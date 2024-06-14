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
                return castearCaracter(valor);
            }
            default -> {
                return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
            }
        }
    }

    public Object castearAEntero(Object valor) {
        if (valor instanceof Integer) {
            return valor;

        } else if (valor instanceof Double) {
            return ((Double) valor).intValue();

        } else if (valor instanceof Character) {
            System.out.println("casteando char a int");
            return (int) ((char) valor);

        } else {
            return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
        }
    }

    public Object castearADecimal(Object valor) {

        if (valor instanceof Integer) {
            return ((Integer) valor).doubleValue();
        } else if (valor instanceof Double) {
            return valor;
        } else {
            return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
        }
    }

    public Object castearCaracter(Object valor) {

        if (valor instanceof Integer) {
            return (char) ((int) valor);
        } else if (valor instanceof Double) {
            return (char) ((double) valor);
        } else if (valor instanceof Character) {
            return valor;
        } else {
            return new Errores("SEMANTICO", "No se puede castear este tipo de dato", this.linea, this.columna);
        }
    }

}
