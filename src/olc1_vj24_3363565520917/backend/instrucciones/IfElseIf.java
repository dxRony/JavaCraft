package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class IfElseIf extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;
    private Instruccion elseIf;

    public IfElseIf(int linea, int columna, Instruccion condicion, LinkedList<Instruccion> instrucciones,
            Instruccion elseIf) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.elseIf = elseIf;
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

        var newTabla = new tablaSimbolos(tabla);
        newTabla.setNombre(tabla.getNombre() + " IF ELSE IF (linea: " + this.linea + ")");

        if ((boolean) cond) {
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    return i;
                }
                var resultado = i.interpretar(arbol, newTabla);
                if (resultado instanceof Break) {
                    return resultado;
                }
                if (resultado instanceof Errores) {
                    return new Errores("SEMANTICO", "Instrucciones dentro de este else if, no son validas", this.linea,
                            this.columna);
                }
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        } else if (elseIf != null) {
            var resultado = elseIf.interpretar(arbol, tabla);
            if (resultado instanceof Break) {
                return resultado;
            }
            if (resultado instanceof Errores) {
                arbol.errores.add((Errores) resultado);
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        }
        return null;
    }
}
