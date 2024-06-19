package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Logicos extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresLogicos operacion;
    private Instruccion operandoUnico;

    public Logicos(int linea, int columna, OperadoresLogicos operacion, Instruccion operandoUnico) {
        super(new Tipo(tipoDato.BOOLEANO), linea, columna);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    public Logicos(int linea, int columna, Instruccion operando1, Instruccion operando2,
            OperadoresLogicos operacion) {
        super(new Tipo(tipoDato.BOOLEANO), linea, columna);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object opIzq = null, opDer = null, Unico = null;

        if (this.operandoUnico != null) {
            Unico = this.operandoUnico.interpretar(arbol, tabla);
        } else {
            opIzq = this.operando1.interpretar(arbol, tabla);
            if (opIzq instanceof Errores) {
                return opIzq;
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Errores) {
                return opDer;
            }
        }
        return switch (operacion) {
            case OR ->
                this.or(opIzq, opDer);
            case AND ->
                this.and(opIzq, opDer);
            case XOR ->
                this.xor(opIzq, opDer);
            case NOT ->
                this.not(Unico);
            default ->
                new Errores("SEMANTICO", "No se esperaba este operador", this.linea,
                        this.columna);
        };
    }

    public Object or(Object op1, Object op2) {       
        this.tipo.setTipo(tipoDato.BOOLEANO);
        return (boolean) op1 || (boolean) op2;
    }

    public Object and(Object op1, Object op2) {       
        this.tipo.setTipo(tipoDato.BOOLEANO);
        return (boolean) op1 && (boolean) op2;
    }

    public Object xor(Object op1, Object op2) {
        this.tipo.setTipo(tipoDato.BOOLEANO);
        return (boolean) op1 ^ (boolean) op2;
    }

    public Object not(Object op1) {       
        this.tipo.setTipo(tipoDato.BOOLEANO);
        return !(boolean) op1;
    }
}
