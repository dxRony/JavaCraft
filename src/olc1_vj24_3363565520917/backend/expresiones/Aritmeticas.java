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
            case RESTA ->
                this.resta(opIzq, opDer);
            case MULTIPLICACION ->
                this.multiplicacion(opIzq, opDer);
            case DIVISION ->
                this.division(opIzq, opDer);
            case POTENCIA ->
                this.potenciacion(opIzq, opDer);
            case MODULO ->
                this.modulo(opIzq, opDer);
            case NEGACION ->
                this.negacion(Unico);
            default ->
                new Errores("SEMANTICO", "No se esperaba este operador: " + this.operacion + ", ", this.linea,
                        this.columna);
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
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        String caracterString = (String) op2; // casteo de op2
                        char caracter = caracterString.charAt(0); // conversion de string a caracter
                        return (int) op1 + (int) caracter;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
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
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 + (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (double) op1 + (int) caracter;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter + (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter + (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return (String) op1 + (String) op2;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return (String) op1 + (String) op2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return (String) op1 + op2.toString();
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return (String) op1 + op2.toString();
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return (String) op1 + (String) op2;
                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object resta(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) op1 - (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 - (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        String caracterString = (String) op2; // casteo de op2
                        char caracter = caracterString.charAt(0); // conversion de string a caracter
                        return (int) op1 - (int) caracter;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 - (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 - (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op2; // casteo de op2
                        char caracter = caracterString.charAt(0); // conversion de string a caracter
                        return (double) op1 - (int) caracter;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter - (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter - (double) op2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object multiplicacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) op1 * (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 * (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        String caracterString = (String) op2; // casteo de op2
                        char caracter = caracterString.charAt(0); // conversion de string a caracter
                        return (int) op1 * (int) caracter;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 * (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 * (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op2; // casteo de op2
                        char caracter = caracterString.charAt(0); // conversion de string a caracter
                        return (double) op1 * (int) caracter;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter * (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter * (double) op2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object division(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        if ((int) op2 == 0) {
                            return new Errores("SEMANTICO", "No se puede dividir dentro de 0", this.linea,
                                    this.columna);
                        } else {
                            this.tipo.setTipo(tipoDato.DECIMAL);
                            return ((double) (int) op1 / (int) op2);
                        }
                    }
                    case DECIMAL -> {
                        if ((double) op2 == 0) {
                            return new Errores("SEMANTICO", "No se puede dividir dentro de 0", this.linea,
                                    this.columna);
                        } else {
                            this.tipo.setTipo(tipoDato.DECIMAL);
                            return ((double) (int) op1 / (double) op2);
                        }
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op2; // casteo de op2
                        char caracter = caracterString.charAt(0); // conversion de string a caracter
                        if (caracter == 0) {
                            return new Errores("SEMANTICO", "No se puede dividir dentro de 0", this.linea,
                                    this.columna);
                        } else {
                            double division = ((double) (int) op1 / (int) caracter);
                            return division;
                        }

                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (double) op1 / (int) op2);
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (double) op1 / (double) op2);
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op2; // casteo de op2
                        char caracter = caracterString.charAt(0); // conversion de string a caracter
                        return ((double) (double) op1 / (int) caracter);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return ((double) (double) caracter / (int) op2);
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return ((double) (double) caracter / (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object potenciacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        int resultado = (int) Math.pow((int) op1, (int) op2);
                        return resultado;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        double resultado = Math.pow((int) op1, (double) op2);
                        return resultado;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        double resultado = Math.pow((double) op1, (int) op2);
                        return resultado;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        double resultado = Math.pow((double) op1, (double) op2);
                        return resultado;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object modulo(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (int) op1 % (int) op2);
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (int) op1 % (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (double) op1 % (int) op2);
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (double) op1 % (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "No se esperaba este tipo de dato", this.linea, this.columna);
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
