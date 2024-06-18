package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

/*
     * Asignacion
     * Condicion -> expresion -> 
     * actualizacion -> incremento -> i++
     *                  decremento -> i--
     *                  asignacion -> i = i + 1
     * instrucciones
     * 
 */
public class For extends Instruccion {

    private Instruccion asignacion;
    private Instruccion condicion;
    private Instruccion actualizacion;
    private LinkedList<Instruccion> instrucciones;

    public For(int linea, int columna, Instruccion asignacion, Instruccion condicion,
            Instruccion actualizacion, LinkedList<Instruccion> instrucciones) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.asignacion = asignacion;
        this.condicion = condicion;
        this.actualizacion = actualizacion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        var newTabla = new tablaSimbolos(tabla);
        newTabla.setNombre(tabla.getNombre() + " FOR (linea: " + this.linea + ")");

        var res1 = this.asignacion.interpretar(arbol, newTabla);
        // asignacion o declaracion
        if (res1 instanceof Errores) {
            return res1;
        }
        // validar condicion booleana
        var cond = this.condicion.interpretar(arbol, newTabla);

        if (cond instanceof Errores) {
            return cond;
        }
        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion no es bool", this.linea, this.columna);
        }
        while ((boolean) this.condicion.interpretar(arbol, newTabla)) {// interpretando la condicion hasta que se cumpla
            // creando nuevo entorno
            var newTabla2 = new tablaSimbolos(newTabla);
            newTabla2.setNombre(newTabla.getNombre() + " INS FOR (linea: " + this.linea + ")");
            for (var i : this.instrucciones) {// si se cumple lo anterior, se ejecutan las instrucciones
                if (i instanceof Break) {
                    return null;
                }
                var resIns = i.interpretar(arbol, newTabla2);
                if (resIns instanceof Break) {
                    return null;
                }
                if (resIns instanceof Errores) {
                    return new Errores("SEMANTICO", "Instrucciones dentro de este for, no son validas", this.linea,
                            this.columna);
                }
            }
            // actualizando la variable
            var act = this.actualizacion.interpretar(arbol, newTabla);

            if (act instanceof Errores) {
                return act;
            }
            arbol.agregarSimbolos(newTabla2.obtenerSimbolos());
        }
        return null;
    }
}
