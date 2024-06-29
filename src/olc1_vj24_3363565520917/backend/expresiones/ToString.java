package olc1_vj24_3363565520917.backend.expresiones;

import java.util.HashMap;
import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class ToString extends Instruccion {

    private Instruccion expresion;

    public ToString(int linea, int columna, Instruccion expresion) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        var res = expresion.interpretar(arbol, tabla);
        if (res instanceof Errores) {
            return res;
        }
        if (expresion.tipo.getTipo() == tipoDato.ENTERO || expresion.tipo.getTipo() == tipoDato.DECIMAL
                || expresion.tipo.getTipo() == tipoDato.CARACTER || expresion.tipo.getTipo() == tipoDato.BOOLEANO) {
            this.tipo.setTipo(tipoDato.CADENA);
            return res;
        } else if (expresion.tipo.getTipo() == tipoDato.STRUCT) {
            var valoresStruct = (LinkedList<HashMap>) res;
            String valoresStructString = "{";
            for (int i = 0; i < valoresStruct.size(); i++) {
                var valorInt = (Instruccion) valoresStruct.get(i).get("valor");
                var resValorInt = valorInt.interpretar(arbol, tabla);
                if (resValorInt instanceof Errores) {
                    return resValorInt;
                }
                valoresStructString += valoresStruct.get(i).get("id") + ": \"" + resValorInt
                        + "\", ";
            }
            String resultado = valoresStructString.substring(0, valoresStructString.length()-2);
            resultado += "}";
            this.tipo.setTipo(tipoDato.CADENA);
            return resultado;
        } else {
            return new Errores("SEMANTICO", "No se puede parsear a string", this.linea, this.columna);
        }
    }
}