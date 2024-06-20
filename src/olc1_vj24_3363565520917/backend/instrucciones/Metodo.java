package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class Metodo extends Instruccion {

    public String id;// identificador del metodo/funcion
    // los parametros de los metodos quedan pendientes, tiene que ser lista de
    // parametros
    public LinkedList<Instruccion> instrucciones;// instrucciones del metodo

    //lo que diferencia una funcion de un metodo es el tipo: VOID, INT, STRING
    public Metodo(Tipo tipo, int linea, int columna, String id, LinkedList<Instruccion> instrucciones) {
        super(tipo, linea, columna);
        this.id = id;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        for (var i : this.instrucciones) {
            var resultado = i.interpretar(arbol, tabla);// interpretando cada instruccion de la lista
            if (resultado instanceof Errores) {
                return new Errores("SEMANTICO", "Las instrucciones dentro de este metodo no son validas", this.linea, this.columna);
            }
            //validar que no haya break o continue
            // retornar en caso sea funcion
        }
        return null;
    }
    // NOTA: la tabla padre de cada metodo es la tabla global
}
