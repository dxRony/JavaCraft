package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Round extends Instruccion{

    private Instruccion valorDecimal;

    public Round(int linea, int columna, Instruccion valorDecimal) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.valorDecimal = valorDecimal;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //interpretando el valor
        Object resValorDecimal = valorDecimal.interpretar(arbol, tabla);
        if (resValorDecimal instanceof Errores) {
            return resValorDecimal;
        }
        //verificando que sea decimal
        if (valorDecimal.tipo.getTipo() != tipoDato.DECIMAL) {
            return new Errores("SEMANTICO", "Solo se puede redondear un decimal", this.linea, this.columna);
        }
        double valor = (double) resValorDecimal;
        this.tipo.setTipo(tipoDato.ENTERO);
        return  (int) Math.round(valor);
    }
}