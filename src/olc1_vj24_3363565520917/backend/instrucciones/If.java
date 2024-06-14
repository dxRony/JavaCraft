package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class If extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;

    public If(int linea, int columna, Instruccion condicion, LinkedList<Instruccion> instrucciones) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);

        boolean condicion = false;

        if (cond instanceof Errores) {
            return cond;
        }
        if (cond.equals("true")) {
            condicion = true;
        } else if (cond.equals("false")) {
            condicion = false;
        }
        // validando que cond sea booleana
        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {

            return new Errores("SEMANTICO", "Expresion invalidad", this.linea, this.columna);
        }
        
        var newTabla = new tablaSimbolos(tabla);
        if ((boolean) condicion) {
            for (var i : this.instrucciones) {
                var resultado = i.interpretar(arbol, newTabla);
                /*
                 * manejo de errores
                 */
            }
        }
        return null;
    }
}
