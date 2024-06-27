package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.expresiones.Return;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class IfElse extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instruccionesA;
    private LinkedList<Instruccion> instruccionesB;

    public IfElse(int linea, int columna, Instruccion condicion, LinkedList<Instruccion> instruccionesA,
            LinkedList<Instruccion> instruccionesB) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.condicion = condicion;
        this.instruccionesA = instruccionesA;
        this.instruccionesB = instruccionesB;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);

        if (cond instanceof Errores) {
            return cond;
        }
        var newTabla = new tablaSimbolos(tabla);
        newTabla.setNombre(tabla.getNombre() + " IF ElSE (linea: " + this.linea + ")");

        if ((boolean) cond) {
            for (var i : this.instruccionesA) {
                if (i instanceof Break || i instanceof Continue || i instanceof Return) {
                    return i;
                }
                var resultado = i.interpretar(arbol, newTabla);
                if (resultado instanceof Break || resultado instanceof Continue || resultado instanceof Return) {
                    return resultado;
                }
                if (resultado instanceof Errores) {
                    return new Errores("SEMANTICO", "Instrucciones dentro de este if, no son validas", this.linea,
                            this.columna);
                }
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        } else {
            for (var i : this.instruccionesB) {
                if (i instanceof Break || i instanceof Continue 
                || i instanceof Return) {
                    return i;
                }
                var resultado = i.interpretar(arbol, newTabla);
                if (resultado instanceof Break || resultado instanceof Continue 
                || resultado instanceof Return) {
                    return resultado;
                }
                if (resultado instanceof Errores) {
                    if (resultado instanceof Errores) {
                        return new Errores("SEMANTICO", "Instrucciones dentro de este else, no son validas", this.linea,
                                this.columna);
                    }
                }
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        }
        return null;
    }
}
