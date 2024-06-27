package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.expresiones.Return;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Caso extends Instruccion {

    private Instruccion expresion;// si es null no se compara nada, es un default
    private LinkedList<Instruccion> instrucciones;// las instrucciones del caso a ejecutar
    private boolean esCaso;// si es true es un caso, si es false es un default

    public Caso(Instruccion expresion, LinkedList<Instruccion> instrucciones, boolean esCaso) {
        super(new Tipo(tipoDato.VOID), 0, 0);
        this.expresion = expresion;
        this.instrucciones = instrucciones;
        this.esCaso = esCaso;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        if (!esCaso) {// validando si es caso o default
            return true;
        }
        var valor = this.expresion.interpretar(arbol, tabla);

        if (valor instanceof Errores) {
            return valor;
        }
        return valor;// devolviendo valor
    }

    public Object ejecutarCaso(Arbol arbol, tablaSimbolos tabla) {

        var newTabla = new tablaSimbolos(tabla); // creando el entorno del caso
        newTabla.setNombre(tabla.getNombre() + " MATCH (linea: " + this.linea + ")");
        arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        for (var instruccion : this.instrucciones) {
            var resultado = instruccion.interpretar(arbol, newTabla);
            if (resultado instanceof Errores) {
                return new Errores("SEMANTICO", "Instrucciones dentro de este match, no son validas", this.linea,
                        this.columna) != null;
            }
            if (resultado instanceof Break || resultado instanceof Continue 
            || resultado instanceof Return) {
                return resultado;    
            }
        }
        return null;
    }

    public Instruccion getExpresion() {
        return expresion;
    }

    public void setExpresion(Instruccion expresion) {
        this.expresion = expresion;
    }

    public boolean isEsCaso() {
        return esCaso;
    }

    public void setEsCaso(boolean esCaso) {
        this.esCaso = esCaso;
    }
}
