package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

/*
 * Instrucciones
 * condicion -> expresion
 */
public class DoWhile extends Instruccion {

    private LinkedList<Instruccion> instrucciones;
    private Instruccion condicion;

    public DoWhile(int linea, int columna, LinkedList<Instruccion> instrucciones, Instruccion condicion) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.instrucciones = instrucciones;
        this.condicion = condicion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        var cond = this.condicion.interpretar(arbol, tabla);

        if (cond instanceof Errores) {
            return cond;
        }

        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion no es bool", this.linea, this.columna);
        }

        do {
            var newTabla = new tablaSimbolos(tabla);
            newTabla.setNombre(tabla.getNombre() + " WHILE (linea: " + this.linea + ")");
            for (var i : this.instrucciones) {// ejecutando lista de instrucciones
                if (i instanceof Break) {
                    return null;
                }
                var resIns = i.interpretar(arbol, newTabla);
                if (resIns instanceof Break) {
                    return null;
                }
                if (resIns instanceof Errores) {
                    return new Errores("SEMANTICO", "Instrucciones dentro de este do-while, no son validas", this.linea,
                            this.columna);
                }
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        } while ((boolean) this.condicion.interpretar(arbol, tabla));
        return null;
    }

}
