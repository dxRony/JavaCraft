package olc1_vj24_3363565520917.backend.instrucciones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Print extends Instruccion {

    private Instruccion expresion;// es de tipo instruccion porque puede venir cualquier cosa (cadenas, etc)

    public Print(int linea, int columna, Instruccion expresion) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        var resultado = this.expresion.interpretar(arbol, tabla);
        if (resultado instanceof Errores) {
            return resultado; // si es un error se captura
        }
        arbol.Print(resultado.toString());
        return null;
    }

}
