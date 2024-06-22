package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class StartWith extends Instruccion {// cuando se llama a este metodo se declaran los parametros

    private String id;
    private LinkedList<Instruccion> parametros;

    public StartWith(int linea, int columna, String id, LinkedList<Instruccion> parametros) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.parametros = parametros;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var busqueda = arbol.getFuncion(id);
        if (busqueda == null) {
            return new Errores("SEMANTICO", "La funcion no existe", this.linea, this.columna);
        }
        if (busqueda instanceof Metodo metodo) {// creando el entorno de la llamada y mandando como tabla anterior la
                                                // global
            var newTabla = new tablaSimbolos(arbol.getTablaGlobal());
            newTabla.setNombre("START_WITH");

            if (metodo.parametros.size() != this.parametros.size()) {// viendo que la cantidad de parametros de la
                                                                     // llamada y del metodo coincidan
                return new Errores("SEMANTICO", "Los tipos de parametros no coinciden", this.linea, this.columna);
            }
            // for para recorrer ambas listas del hasmap e instrucciones y declarar los
            // parametros
            for (int i = 0; i < this.parametros.size(); i++) {
                // obteniendo el id en el indice indicado del hashmap
                var identificador = (String) metodo.parametros.get(i).get("id");
                // obteniendo el valor del indice indicado en la lista de parametros
                var valor = this.parametros.get(i);
                // obteniendo el tipo de dato de la variable del hashmap en el indice indicado
                var tipoParametro = (Tipo) metodo.parametros.get(i).get("tipo");
                // creando instancia de declaracion
                var declaracionParametro = new Declaracion(tipoParametro, this.linea, this.columna, identificador, valor, "const");
                // declarandoolo el parametro
                var resultadoDeclaracion = declaracionParametro.interpretar(arbol, newTabla);
                if (resultadoDeclaracion instanceof Errores) {
                    return resultadoDeclaracion;
                }
            }
            var resultadoFuncion = metodo.interpretar(arbol, newTabla);
            if (resultadoFuncion instanceof Errores) {
                return resultadoFuncion;
            }
            arbol.agregarSimbolos(newTabla.obtenerSimbolos());
        }

        return null;
    }

}
