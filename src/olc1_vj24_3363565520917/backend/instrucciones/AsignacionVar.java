package olc1_vj24_3363565520917.backend.instrucciones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AsignacionVar extends Instruccion {// la instruccion tiene tipo VOID

    private String id;// id de la var a modificar
    private Instruccion exp;//
    private String incremento;

    public AsignacionVar(String id, Instruccion exp, int linea, int columna) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.exp = exp;
    }

    public AsignacionVar(int linea, int columna, String id, Instruccion exp, String incremento) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.exp = exp;
        this.incremento = incremento;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var variable = tabla.getVariable(id);// verificar que variable exista

        if (variable == null) {
            return new Errores("SEMANTICO", "La variable no existe", this.linea, this.columna);
        }

        if (!variable.isMutabilidad()) {// verificando la mutabilidad
            return new Errores("SEMANTICO", "La variable CONST no se puede alterar", this.linea, this.columna);
        }

        var newValor = this.exp.interpretar(arbol, tabla);// interpretar el nuevo valor a asignar

        if (newValor instanceof Errores) {
            return newValor;
        }

        if (variable.getTipo().getTipo() != this.exp.tipo.getTipo()) {// validar que los tipos coincidan
            return new Errores("SEMANTICO", "Tipos erroneos de asignacion", this.linea, this.columna);
        }

        if (incremento != null) {//manejando el incremento y el decremento
            var tipo = variable.getTipo().getTipo();

            if (incremento.equals("++")) {
                switch (tipo) {
                    case ENTERO -> {
                        newValor = (Integer) newValor + 1;
                    }
                    case DECIMAL -> {
                        newValor = (Double) newValor + 1;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se puede incrementar este tipo de dato", this.linea, this.columna);
                    }
                }

            } else if (incremento.equals("--")) {
                switch (tipo) {
                    case ENTERO -> {
                        newValor = (Integer) newValor - 1;
                    }
                    case DECIMAL -> {
                        newValor = (Double) newValor - 1;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "No se puede decrementar este tipo de dato", this.linea, this.columna);
                    }
                }
            }

        }
        variable.setValor(newValor);// actualizando el nuevo valor de la var
        return null;
    }
}
