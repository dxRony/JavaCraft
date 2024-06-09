package olc1_vj24_3363565520917.backend.abstracto;

import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public abstract class Instruccion {

    public Tipo tipo;
    public int linea;
    public int columna;

    public Instruccion(Tipo tipo, int linea, int columna) {
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }

    public abstract Object interpretar(Arbol arbol, tablaSimbolos tabla);

    @Override
    public String toString() {
        return "Instruccion [tipo=" + tipo + ", linea=" + linea + ", columna=" + columna + "]";
    }

    
}
