package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class Casteo extends Instruccion {

    private Tipo tipoDestino;
    private Instruccion expr;

    public Casteo(Tipo tipoDestino, int linea, int columna, Instruccion expr) {
        super(tipoDestino, linea, columna);
        this.tipoDestino = tipoDestino;
        this.expr = expr;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object valor = expr.interpretar(arbol, tabla);

        if (valor instanceof Errores) {
            return valor;
        }

        switch (tipoDestino.getTipo()) {
            case ENTERO -> {
                return castearAEntero(valor);
            }
            case DECIMAL -> {
                return castearADecimal(valor);
            }
            case CARACTER -> {
                return castearACaracter(valor);
            }
            default -> {
                return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object castearAEntero(Object valor) {
        System.out.println("casteando a entero");
        System.out.println("valor = " + valor.getClass());
        
        if (valor instanceof Integer) {
            return valor;

        } else if (valor instanceof Double) {
            return ((Double) valor).intValue();

        } else if (valor instanceof String) {
            String valorString = (String) valor;
             int valorEntero = Integer.parseInt(valorString);
            return (int) (valorEntero);  
            
        } else {
            return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
        }
    }

    public Object castearADecimal(Object valor) {
        System.out.println("casteando a decimal");
        System.out.println("valor = " + valor.getClass());

        if (valor instanceof Integer) {
            return ((Integer) valor).doubleValue();
        } else if (valor instanceof Double) {
            return valor;
        } else if (valor instanceof String) {
            String valorString = (String) valor;
             char caracter = (valorString).charAt(0);
             int valorEntero = (int) caracter;
             double valorDouble = (double) valorEntero;
            return (double) (valorDouble);  
        }
        else {
            return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
        }
    }

    public Object castearACaracter(Object valor) {
        System.out.println("casteando a  caracter");
        System.out.println("valor = " + valor);
        if (valor instanceof Integer) {
            int valorEntero = (int) valor;
            System.out.println("valorEntero = " + valorEntero);
            char caracterFinal = (char) valorEntero;
            System.out.println("caracterFinal = " + caracterFinal);
            String stringCaracter = ""+ caracterFinal;
            return stringCaracter;
            
        } else if (valor instanceof Double) {
            
            return (char) ((double) valor);
        } else if (valor instanceof Character) {
            return valor;
        } else {
            return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
        }
    }

}
