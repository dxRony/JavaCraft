package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.HashMap;
import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.expresiones.Return;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

public class Metodo extends Instruccion {

    public String id;// identificador del metodo/funcion
    public LinkedList<HashMap> parametros;// lista de parametros, puede estar vacia
    public LinkedList<Instruccion> instrucciones;// instrucciones del metodo

    // lo que diferencia una funcion de un metodo es el tipo: VOID, INT, STRING, etc
    public Metodo(Tipo tipo, int linea, int columna, String id, LinkedList<HashMap> parametros,
            LinkedList<Instruccion> instrucciones) {
        super(tipo, linea, columna);
        this.id = id;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        for (var i : this.instrucciones) {
            var resultado = i.interpretar(arbol, tabla);// interpretando cada instruccion de la lista
            if (resultado instanceof Errores) {
                return new Errores("SEMANTICO", "Las instrucciones dentro de este metodo no son validas", this.linea,
                        this.columna);
            }
            if (resultado instanceof Return) {// cuando la instruccion sea retorno se finaliza la ejecucion del metodo
                return resultado;
            }
        }
        return null;
    }
    // NOTA: la tabla padre de cada metodo es la tabla global
}