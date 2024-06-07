package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class Nativo extends Instruccion { //el tipo puede ser un numero, decimal, boolean, char, etc / valores

    private Object valor;

    public Nativo(Tipo tipo, int linea, int columna, Object valor) {
        super(tipo, linea, columna);
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        return this.valor;//retorna el valor del nativo
    }

    
    
    
    

}
