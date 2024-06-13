package olc1_vj24_3363565520917.backend.instrucciones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AsignacionVar extends Instruccion {

    private String id;
    private Instruccion exp;

    public AsignacionVar(String id, Instruccion exp, int linea, int columna){
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.exp = exp;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // verificar que variable exista
        var variable = tabla.getVariable(id);
        if (variable == null) {
            return new Errores("SEMANTICO", "La variable no existe", this.linea, this.columna);
        }
        // interpretar el nuevo valor a asignar
        var newValor = this.exp.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }
        // validar tipos
        if (variable.getTipo().getTipo() != this.exp.tipo.getTipo()) {
            return new Errores("SEMANTICO", "Tipos erroneos de asignacion", this.linea, this.columna);
        }
        variable.setValor(newValor);
        return null;
    }
}
