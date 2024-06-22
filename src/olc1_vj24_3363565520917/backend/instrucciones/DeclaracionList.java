package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class DeclaracionList extends Instruccion {

    private String identificador;

    public DeclaracionList(Tipo tipo, int linea, int columna, String identificador) {
        super(tipo, linea, columna);
        this.identificador = identificador;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // creando simbolo
        Simbolo s = new Simbolo(this.identificador, this.tipo, "Lista", tabla.getNombre(), new LinkedList<>(),
                this.linea, this.columna);
        boolean creacion = tabla.setVariable(s);// mandando el simbolo a la tabla

        if (!creacion) {// viendo si se creo el simbolo
            return new Errores("SEMANTICO", "La lista ya existe", this.linea, this.columna);
        }
        return null;
    }
}