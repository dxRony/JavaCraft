package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
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
        //boolean condicion = false;

        if (cond instanceof Errores) {
            return cond;
        }
        /*
         * if (cond.equals("true")) {
         * System.out.println("la condicion es true");
         * condicion = true;
         * } else if (cond.equals("false")) {
         * System.out.println("la condicion es false");
         * 
         * condicion = false;
         * }
         */
        var newTabla = new tablaSimbolos(tabla);

        if ((boolean) cond) {
            for (var i : this.instruccionesA) {
                var resultado = i.interpretar(arbol, newTabla);
                if (resultado instanceof Errores) {
                    arbol.errores.add((Errores) resultado);
                    // continue;
                }
            }
        } else {
            for (var i : this.instruccionesB) {
                var resultado = i.interpretar(arbol, newTabla);
                if (resultado instanceof Errores) {
                    arbol.errores.add((Errores) resultado);
                    // continue;
                }
            }
        }
        return null;
    }
}
