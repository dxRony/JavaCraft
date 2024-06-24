package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class DeclaracionVector extends Instruccion {

    private String mutabilidad;// mutabilidad del vector
    private String identificador;// identificador del vector
    private int dimension;// dimension del vector -> 1D o 2D
    private LinkedList<Instruccion> valores; // valores entrantes al vector

    public DeclaracionVector(Tipo tipo, int linea, int columna, String mutabilidad, String identificador,
            int dimension, LinkedList<Instruccion> valores) {
        super(tipo, linea, columna);
        this.mutabilidad = mutabilidad;
        this.identificador = identificador;
        this.dimension = dimension;
        this.valores = valores;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        System.out.println("entrando a declaracion vector");
        System.out.println("Datos entrantes.");
        System.out.println("mutabilidad: " + mutabilidad);
        System.out.println("identificador: " + identificador);
        System.out.println("dimension: " + dimension);
        System.out.println("valores: ");
        for (Instruccion valor : valores) {
            System.out.println(valor.tipo.getTipo());
        }

        // if para reconocer si el arreglo es 1D o 2D
        if (dimension == 1) {// si es 1D
            // creando el array del tamaño de los valores
            System.out.println("es de dimension 1");
            Object[] vector1D = new Object[valores.size()];
            System.out.println("tamaño del vector: " + vector1D.length);

            for (int i = 0; i < valores.size(); i++) {// recorriendo los valores
                var valor = valores.get(i).interpretar(arbol, tabla);
                if (valor instanceof Errores) {
                    return valor;
                }
                //comparar tipos
                // ingresando el valor a la posicion i
                vector1D[i] = valor;
            }
            // manejando mutabilidad
            boolean mutabilidadBool = false;

            if (mutabilidad.equals("var")) {
                mutabilidadBool = true;
            } else if (mutabilidad.equals("const")) {
                mutabilidadBool = false;
            }
            // creando simbolo -> vector 1D
            Simbolo s = new Simbolo(identificador, this.tipo, "Vector", tabla.getNombre(), vector1D, mutabilidadBool,
                    this.linea, this.columna);
            boolean creacion = tabla.setVariable(s);
            if (!creacion) {
                return new Errores("SEMANTICO", "El vector ya existe", this.linea, this.columna);
            }

        } else if (dimension == 2) {
            // creando array 2D del tamaño de los valores
            Object[][] vector2D = new Object[valores.size()][];

            for (int i = 0; i < valores.size(); i++) {
                // interpretando las filas
                LinkedList<Instruccion> valoresDeFila = (LinkedList<Instruccion>) valores.get(i).interpretar(arbol,
                        tabla);
                vector2D[i] = new Object[valoresDeFila.size()];
                for (int j = 0; j < valoresDeFila.size(); j++) {
                    var ins = valoresDeFila.get(j).interpretar(arbol, tabla);
                    if (ins instanceof Errores) {
                        return ins;
                    }
                    vector2D[i][j] = ins;
                }
            }
            // manejando mutabilidad
            boolean mutabilidadBool = false;

            if (mutabilidad.equals("var")) {
                mutabilidadBool = true;
            } else if (mutabilidad.equals("const")) {
                mutabilidadBool = false;
            }
            Simbolo s = new Simbolo(identificador, this.tipo, "Vector", tabla.getNombre(), vector2D, mutabilidadBool,
                    this.linea, this.columna);
            boolean creacion = tabla.setVariable(s);
            if (!creacion) {
                return new Errores("SEMANTICO", "El vector ya existe", this.linea, this.columna);
            }
        }
        return null;
    }
}