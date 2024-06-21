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

        if (cond instanceof Errores) {
            return cond;
        }

        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) { // validando que cond sea booleana
            return new Errores("SEMANTICO", "Expresion invalida", this.linea, this.columna);
        }

        var newTabla = new tablaSimbolos(tabla);// creando tabla que contiene una tabla anterior de la que nos dan
        newTabla.setNombre(tabla.getNombre() + " IF (linea: " + this.linea + ")");

        if ((boolean) cond) {
            for (var i : this.instrucciones) {// recorriendo las instrucciones de adentro del bloque
                if (i instanceof Break || i instanceof Continue) {
                    return i;
                }
                var resultado = i.interpretar(arbol, newTabla);// le mandamos la tabla del bloque y que la interprete
                if (resultado instanceof Break || resultado instanceof Continue) {
                    return resultado;
                }
                if (resultado instanceof Errores) {
                    return new Errores("SEMANTICO", "Instrucciones dentro de este if, no son validas", this.linea,
                            this.columna);
                }
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        }

        return null;
    }
}
