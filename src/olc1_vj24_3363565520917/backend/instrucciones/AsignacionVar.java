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

    public AsignacionVar(String id, Instruccion exp, int linea, int columna) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.exp = exp;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var variable = tabla.getVariable(id);// verificar que variable exista

        if (variable == null) {
            return new Errores("SEMANTICO", "La variable no existe", this.linea, this.columna);
        }
        // tambien verificar la mutabilidad
        
          if (!variable.isMutabilidad()) {
          return new Errores("SEMANTICO", "La variable CONST no se puede alterar", this.linea, this.columna);
         }
         
        var newValor = this.exp.interpretar(arbol, tabla);// interpretar el nuevo valor a asignar

        if (newValor instanceof Errores) {
            return newValor;
        }
        
        if (variable.getTipo().getTipo() != this.exp.tipo.getTipo()) {// validar que los tipos coincidan
            return new Errores("SEMANTICO", "Tipos erroneos de asignacion", this.linea, this.columna);
        }
        variable.setValor(newValor);//actualizando el nuevo valor de la var
        return null;
    }
}
