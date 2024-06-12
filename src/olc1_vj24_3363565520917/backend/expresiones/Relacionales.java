package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Relacionales extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresRelacionales operacion;

    public Relacionales(int linea, int columna, Instruccion operando1, Instruccion operando2,
            OperadoresRelacionales operacion) {
        super(new Tipo(tipoDato.BOOLEANO), linea, columna);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object opIzq = null, opDer = null;

        opIzq = this.operando1.interpretar(arbol, tabla);
        if (opIzq instanceof Errores) {
            return opIzq;
        }

        opDer = this.operando2.interpretar(arbol, tabla);
        if (opDer instanceof Errores) {
            return opDer;
        }
        return switch (operacion) {
            case IGUALACION ->
                this.igualacion(opIzq, opDer);
            case DIFERENCIACION ->
                this.diferenciacion(opIzq, opDer);
            case MENORQUE ->
                this.menorQue(opIzq, opDer);
            case MENORIGUALQUE ->
                this.menorIgualQue(opIzq, opDer);
            case MAYORQUE ->
                this.mayorQue(opIzq, opDer);
            case MAYORIGUALQUE ->
                this.mayorIgualQue(opIzq, opDer);
            default ->
                new Errores("SEMANTICO", "No se esperaba este operador", this.linea, this.columna);
        };
    }

    public Object igualacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 == (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 == (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (int) op1 == (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (int) op1 == bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 == (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 == (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (double) op1 == (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (double) op1 == bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool == (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool == (double) op2;
                    }
                    case CARACTER -> {
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return bool == (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        boolean bool1 = false;
                        boolean bool2 = false;
                        if (op1.equals("true")) {
                            bool1 = true;
                        } else if (op1.equals("false")) {
                            bool1 = false;
                        }
                        if (op2.equals("true")) {
                            bool2 = true;
                        } else if (op2.equals("false")) {
                            bool2 = false;
                        }
                        return bool1 == bool2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter == (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter == (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString1 = (String) op1;
                        char caracter1 = caracterString1.charAt(0);
                        String caracterString2 = (String) op2;
                        char caracter2 = caracterString2.charAt(0);
                        return (int) caracter1 == (int) caracter2;
                    }
                    case BOOLEANO -> {
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter == bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String cadena1 = op1.toString();
                        String cadena2 = op2.toString();
                        return cadena1.equals(cadena2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object diferenciacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 != (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 != (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (int) op1 != (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (int) op1 != bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 != (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 != (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (double) op1 != (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (double) op1 != bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool != (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool != (double) op2;
                    }
                    case CARACTER -> {
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return bool != (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        boolean bool1 = false;
                        boolean bool2 = false;
                        if (op1.equals("true")) {
                            bool1 = true;
                        } else if (op1.equals("false")) {
                            bool1 = false;
                        }
                        if (op2.equals("true")) {
                            bool2 = true;
                        } else if (op2.equals("false")) {
                            bool2 = false;
                        }
                        return bool1 != bool2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter != (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter != (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString1 = (String) op1;
                        char caracter1 = caracterString1.charAt(0);
                        String caracterString2 = (String) op2;
                        char caracter2 = caracterString2.charAt(0);
                        return (int) caracter1 != (int) caracter2;
                    }
                    case BOOLEANO -> {
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter != bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String cadena1 = op1.toString();
                        String cadena2 = op2.toString();
                        return !cadena1.equals(cadena2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object menorQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 < (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 < (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (int) op1 < (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (int) op1 < bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 < (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 < (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (double) op1 < (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (double) op1 < bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter < (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter < (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString1 = (String) op1;
                        char caracter1 = caracterString1.charAt(0);
                        String caracterString2 = (String) op2;
                        char caracter2 = caracterString2.charAt(0);
                        return (int) caracter1 < (int) caracter2;
                    }
                    case BOOLEANO -> {
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter < bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool < (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool < (double) op2;
                    }
                    case CARACTER -> {
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return bool < (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool1 = 10;
                        int bool2 = 10;
                        if (op1.equals("true")) {
                            bool1 = 1;
                        } else if (op1.equals("false")) {
                            bool1 = 0;
                        }
                        if (op2.equals("true")) {
                            bool2 = 1;
                        } else if (op2.equals("false")) {
                            bool2 = 0;
                        }
                        return bool1 < bool2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object menorIgualQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 <= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 <= (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (int) op1 <= (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (int) op1 <= bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 <= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 <= (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (double) op1 <= (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (double) op1 <= bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter <= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter <= (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString1 = (String) op1;
                        char caracter1 = caracterString1.charAt(0);
                        String caracterString2 = (String) op2;
                        char caracter2 = caracterString2.charAt(0);
                        return (int) caracter1 <= (int) caracter2;
                    }
                    case BOOLEANO -> {
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter <= bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool <= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool <= (double) op2;
                    }
                    case CARACTER -> {
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return bool <= (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool1 = 10;
                        int bool2 = 10;
                        if (op1.equals("true")) {
                            bool1 = 1;
                        } else if (op1.equals("false")) {
                            bool1 = 0;
                        }
                        if (op2.equals("true")) {
                            bool2 = 1;
                        } else if (op2.equals("false")) {
                            bool2 = 0;
                        }
                        return bool1 <= bool2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object mayorQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 > (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 > (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (int) op1 > (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (int) op1 > bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 > (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 > (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (double) op1 > (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (double) op1 > bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter > (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter > (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString1 = (String) op1;
                        char caracter1 = caracterString1.charAt(0);
                        String caracterString2 = (String) op2;
                        char caracter2 = caracterString2.charAt(0);
                        return (int) caracter1 > (int) caracter2;
                    }
                    case BOOLEANO -> {
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter > bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool > (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool > (double) op2;
                    }
                    case CARACTER -> {
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return bool > (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool1 = 10;
                        int bool2 = 10;
                        if (op1.equals("true")) {
                            bool1 = 1;
                        } else if (op1.equals("false")) {
                            bool1 = 0;
                        }
                        if (op2.equals("true")) {
                            bool2 = 1;
                        } else if (op2.equals("false")) {
                            bool2 = 0;
                        }
                        return bool1 > bool2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object mayorIgualQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 >= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 >= (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (int) op1 >= (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (int) op1 >= bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 >= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 >= (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return (double) op1 >= (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        return (double) op1 >= bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter >= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter >= (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        String caracterString1 = (String) op1;
                        char caracter1 = caracterString1.charAt(0);
                        String caracterString2 = (String) op2;
                        char caracter2 = caracterString2.charAt(0);
                        return (int) caracter1 >= (int) caracter2;
                    }
                    case BOOLEANO -> {
                        int bool = 10;
                        if (op2.equals("true")) {
                            bool = 1;
                        } else if (op2.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op1;
                        char caracter = caracterString.charAt(0);
                        return (int) caracter >= bool;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool >= (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        return bool >= (double) op2;
                    }
                    case CARACTER -> {
                        int bool = 10;
                        if (op1.equals("true")) {
                            bool = 1;
                        } else if (op1.equals("false")) {
                            bool = 0;
                        }
                        String caracterString = (String) op2;
                        char caracter = caracterString.charAt(0);
                        return bool >= (int) caracter;
                    }
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        int bool1 = 10;
                        int bool2 = 10;
                        if (op1.equals("true")) {
                            bool1 = 1;
                        } else if (op1.equals("false")) {
                            bool1 = 0;
                        }
                        if (op2.equals("true")) {
                            bool2 = 1;
                        } else if (op2.equals("false")) {
                            bool2 = 0;
                        }
                        return bool1 >= bool2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "no se esperaba este tipo de dato", this.linea, this.columna);
            }
        }
    }
}
