package olc1_vj24_3363565520917.backend.expresiones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AccesoVector extends Instruccion {

    private String identificador;
    private Instruccion indice1;
    private Instruccion indice2;

    public AccesoVector(int linea, int columna, String identificador, Instruccion indice1,
            Instruccion indice2) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.identificador = identificador;
        this.indice1 = indice1;
        this.indice2 = indice2;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Simbolo vectorExistente = tabla.getVariable(identificador);
        if (vectorExistente == null) {
            return new Errores("SEMANTICO", "El vector: " + this.identificador + ", no existe", this.linea,
                    this.columna);
        }
        if (vectorExistente.getTipo2().equalsIgnoreCase("Vector")) {// acceso a vector 1D o 2D
            if (indice2 == null) {
                var indiceVector1 = indice1.interpretar(arbol, tabla);
                if (indiceVector1 instanceof Errores) {
                    return indiceVector1;
                }
                Object[] vector1D = (Object[]) vectorExistente.getValor();
                this.tipo.setTipo(vectorExistente.getTipo().getTipo());
                return vector1D[(int) indiceVector1];

            } else {
                var indiceVector1 = indice1.interpretar(arbol, tabla);
                if (indiceVector1 instanceof Errores) {
                    return indiceVector1;
                }
                var indiceVector2 = indice2.interpretar(arbol, tabla);
                if (indiceVector2 instanceof Errores) {
                    return indiceVector2;
                }

                Object[][] vector2D = (Object[][]) vectorExistente.getValor();
                this.tipo.setTipo(vectorExistente.getTipo().getTipo());
                return vector2D[(int) indiceVector1][(int) indiceVector2];
            }
        } else if (vectorExistente.getTipo2().equalsIgnoreCase("Lista")) {// acceso a lista
            var lista = (LinkedList<Object>) vectorExistente.getValor();

            var indiceObtener = indice1.interpretar(arbol, tabla);
            if (indiceObtener instanceof Errores) {
                return indiceObtener;
            }
            this.tipo.setTipo(vectorExistente.getTipo().getTipo());
            return lista.get((int) indiceObtener);
        } else {
            return new Errores("SEMANTICO", "El id no pertenece a una lista", this.linea, this.columna);
        }
    }
}