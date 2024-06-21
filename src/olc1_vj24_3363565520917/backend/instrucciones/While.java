package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

/*
    * Condicion -> expresion 
    * Intrucciones
 */
public class While extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;

    public While(int linea, int columna, Instruccion condicion, LinkedList<Instruccion> instrucciones) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // validar la condicion booleana
        var cond = this.condicion.interpretar(arbol, tabla);

        if (cond instanceof Errores) {
            return cond;
        }
        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion no es bool", this.linea, this.columna);
        }
        while ((boolean) this.condicion.interpretar(arbol, tabla)) {
            // creando el entorno para el while
            var newTabla = new tablaSimbolos(tabla);
            newTabla.setNombre(tabla.getNombre() + " WHILE (linea: " + this.linea + ")");
            for (var i : this.instrucciones) {// ejecutando lista de instrucciones
                if (i instanceof Break) {
                    return null;
                }
                if (i instanceof Continue) {
                    break;
                }
                var res = i.interpretar(arbol, newTabla);
                if (res instanceof Break) {
                    return null;
                }
                if (res instanceof Continue) {
                    break;
                }
                if (res instanceof Errores) {
                    return new Errores("SEMANTICO", "Instrucciones dentro de este while, no son validas", this.linea,
                            this.columna);
                }
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        }
        return null;
    }
}
