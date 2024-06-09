package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Logicos extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresRelacionales operacion;
    private Instruccion operandoUnico;

    public Logicos(int linea, int columna, OperadoresRelacionales operacion, Instruccion operandoUnico) {
        super(new Tipo(tipoDato.BOOLEANO), linea, columna);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    public Logicos(int linea, int columna, Instruccion operando1, Instruccion operando2,
            OperadoresRelacionales operacion) {
        super(new Tipo(tipoDato.BOOLEANO), linea, columna);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // TODO Auto-generated method stub
        return null;
    }

}
