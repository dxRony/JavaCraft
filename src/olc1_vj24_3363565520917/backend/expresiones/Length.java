package olc1_vj24_3363565520917.backend.expresiones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Length extends Instruccion {

    private Instruccion expresion;

    public Length(int linea, int columna, Instruccion expresion) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        var resExpresion = this.expresion.interpretar(arbol, tabla);
        if (resExpresion instanceof Errores) {
            return resExpresion;
        }
        
        // viendo si expresion es una cadena
        if (resExpresion.getClass() == String.class) {
            //si es cadena
            this.tipo.setTipo(tipoDato.ENTERO);
            return (int) resExpresion.toString().length();
        } else if (resExpresion.getClass() == LinkedList.class) {
            //si es una lista
            this.tipo.setTipo(tipoDato.ENTERO);
            return (int) ((LinkedList) resExpresion).size();

        } else if (resExpresion.getClass().isArray()) {
            //si es un vector
            int largo = 0;
            if (resExpresion.getClass().getComponentType().isArray()) {
                //si es vector 2D
                    largo = ((Object[]) resExpresion).length;
            } else {
                //si es vector 1D
                largo = ((Object[]) resExpresion).length;
            }
            this.tipo.setTipo(tipoDato.ENTERO);
            return largo;
        } else{
            return new Errores("SEMANTICO", "No se puede obtener el largo de este dato", this.linea, this.columna);
        }
    }
}