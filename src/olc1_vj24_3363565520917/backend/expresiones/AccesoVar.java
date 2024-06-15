package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AccesoVar extends Instruccion {

    public String id;// nombre de la var a buscar

    public AccesoVar(int linea, int columna, String id) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var valor = tabla.getVariable(this.id);// obteniendo la variable

        if (valor == null) {
            return new Errores("SEMANTICO", "La variable: " + this.id + ", no existe", this.linea, this.columna);
        }

        this.tipo.setTipo(valor.getTipo().getTipo());// actualizando el tipo de la var accedida, en caso de sumas etc
        return valor.getValor();// retornando el valor de la var
    }
}
