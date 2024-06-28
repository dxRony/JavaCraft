package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.HashMap;
import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class DeclaracionStruct extends Instruccion {

    public String id;
    public LinkedList<HashMap> atributos;

    public DeclaracionStruct(Tipo tipo, int linea, int columna, String id, LinkedList<HashMap> atributos) {
        super(tipo, linea, columna);
        this.id = id;
        this.atributos = atributos;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        return null;
    }
}