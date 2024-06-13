package olc1_vj24_3363565520917.backend.instrucciones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class Declaracion extends Instruccion {

    public String identificador;
    public Instruccion valor;

    public Declaracion(Tipo tipo, int linea, int columna, String identificador, Instruccion valor) {
        super(tipo, linea, columna);
        this.identificador = identificador;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // interpretando la expresion
        var valorInterpretado = this.valor.interpretar(arbol, tabla);
        // validando si hay error
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }
        // validando el tipo
        if (this.valor.tipo.getTipo() != this.tipo.getTipo()) {
            return new Errores("SEMANTICO", "Tipos erroneeasds", this.linea, this.columna);
        }

        Simbolo s = new Simbolo(this.tipo, this.identificador, valorInterpretado);

        boolean creacion = tabla.setVaribale(s);

        if (!creacion) {
            return new Errores("SEMANTICO", "la variable ya existe", this.linea, this.columna);
        }
        return null;
    }

}
