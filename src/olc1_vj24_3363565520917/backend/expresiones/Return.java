package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Return extends Instruccion {

    public Instruccion valor;// valor a retornar

    // constructor para cuando haya valor a retornar
    public Return(int linea, int columna, Instruccion valor) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // interpretando el valor
        if (valor != null) {// si hay valor de retorno, se interpreta y se retorna
            var resultado = valor.interpretar(arbol, tabla);
            if (resultado instanceof Errores) {
                return resultado;
            }            
            this.tipo.setTipo(valor.tipo.getTipo());
            return resultado;
        } else {// si no hay valor se retorna null
            return null;
        }
    }
}