package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Aritmeticas extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresAritmeticos operacion;
    private Instruccion operandoUnico;

    // constructor para la negacion
    public Aritmeticas(int linea, int columna, OperadoresAritmeticos operacion, Instruccion operandoUnico) {
        super(new Tipo(tipoDato.ENTERO), linea, columna);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    // contructor para las operaciones
    public Aritmeticas(int linea, int columna, Instruccion operando1, Instruccion operando2,
            OperadoresAritmeticos operacion) {
        super(new Tipo(tipoDato.ENTERO), linea, columna);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Object opIzq = null, opDer = null, Unico = null;// limpiando los operadores, antes de iniciar
        if (this.operandoUnico != null) {// si el operando unico no es nulo, significa que hay una negacion
            Unico = this.operandoUnico.interpretar(arbol, tabla);// interpretando el operador unico
        } else {// si es nulo, quiere decir que hay una operacion aritmetica a realizar
            opIzq = this.operando1.interpretar(arbol, tabla);// interpretando el 1er operador
            if (opIzq instanceof Errores) {
                return opIzq;// si hay un error lo retorna
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Errores) {
                return opDer;
            }
        }

        return switch (operacion) {
            case SUMA ->
                this.suma(opIzq, opDer);

            case NEGACION ->
                this.negacion(Unico);
            default ->
                new Errores("SEMANTICO", "No se esperaba este operador", this.linea, this.columna);
        };
    }

    public Object suma(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {// evaluando el 1er tipo del operando, para luego ver el operando2
            case ENTERO -> {
                switch (tipo2) {// evaluando el tipo del segundo operando, para determinar su tipo final
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) op1 + (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 + (double) op2;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 + (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return (double) op1 + (double) op2;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CADENA -> {
                this.tipo.setTipo(tipoDato.CADENA);
                return op1.toString() + op2.toString();
            }
            default -> {
                return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object negacion(Object op1) {
        var opU = this.operandoUnico.tipo.getTipo();
        switch (opU) {// cuando el operador es unario,
            case ENTERO -> {
                this.tipo.setTipo(tipoDato.ENTERO);
                return (int) op1 * -1;
            }
            case DECIMAL -> {
                this.tipo.setTipo(tipoDato.DECIMAL);
                return (double) op1 * -1;
            }
            default -> {
                return new Errores("SEMANTICO", "Negacion erronea", this.linea, this.columna);
            }
        }
    }

}
