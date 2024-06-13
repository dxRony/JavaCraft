package olc1_vj24_3363565520917.backend.instrucciones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class Declaracion extends Instruccion {

    public String identificador;// nombre de la variable
    public Instruccion valor;// contenido de la variable
    public String mutabilidad;

    // manejar valor por defecto
    public Declaracion(Tipo tipo, int linea, int columna, String identificador, Instruccion valor, String mutabilidad) {
        super(tipo, linea, columna);
        this.identificador = identificador;
        this.valor = valor;
        this.mutabilidad = mutabilidad;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // interpretando la expresion, para saber el tipo
        var valorInterpretado = this.valor.interpretar(arbol, tabla);

        // manejando la mutabilidad
        boolean mutabilidadBool = false;

        if (mutabilidad.equals("var")) {// si es var, es mutable
            mutabilidadBool = true;
        } else if (mutabilidad.equals("const")) {
            mutabilidadBool = false;
        }

        if (valorInterpretado instanceof Errores) {// validando si hay error
            return valorInterpretado;
        }
        
        if (this.valor.tipo.getTipo() != this.tipo.getTipo()) {// validando los tipos (que coincidan)
            return new Errores("SEMANTICO", "Tipos erroneos", this.linea, this.columna);
        }

        Simbolo s = new Simbolo(this.tipo, this.identificador, valorInterpretado, mutabilidadBool);// creando el simbolo

        boolean creacion = tabla.setVaribale(s);// mandando el simbolo a la tabla

        if (!creacion) {// viendo si se creo el simbolo
            return new Errores("SEMANTICO", "la variable ya existe", this.linea, this.columna);
        }
        return null;
    }

}
