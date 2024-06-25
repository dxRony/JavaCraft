package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Llamada extends Instruccion {

    private String identificador;
    private LinkedList<Instruccion> parametros;

    /*
     * "juego de entornos" para las llamadas:
     * se crea un nuevo entorno cuando se llama a un metodo,
     * la tabla anterior de ese entorno es la tabla global,
     * los parametros de la llamada del metodo van a interpretarse del
     * entorno de donde se llamo al metodo
     */
    public Llamada(int linea, int columna, String identificador, LinkedList<Instruccion> parametros) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.identificador = identificador;
        this.parametros = parametros;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        var busqueda = arbol.getFuncion(identificador);
        if (busqueda == null) {
            return new Errores("SEMANTICO", "La funcion no existe", this.linea, this.columna);
        }
        if (busqueda instanceof Metodo metodo) {
            // creando entorno del metodo y mandandole como anterior el global
            var newTabla = new tablaSimbolos(arbol.getTablaGlobal());
            newTabla.setNombre("Llamada metodo:" + this.identificador);

            if (metodo.parametros.size() != this.parametros.size()) {// validando parametros
                return new Errores("SEMANTICO", "Los parametros de la llamada no estan correctos", this.linea,
                        this.columna);
            }
            for (int i = 0; i < this.parametros.size(); i++) {
                var valor = this.parametros.get(i);
                var tipo2 = (Tipo) metodo.parametros.get(i).get("tipo");
                // declarando el parametro dentro del entorno del metodo, con valor default
                var declaracionParametro = new Declaracion(tipo2, this.linea, this.columna, identificador, "var");
                // declarando el parametro en la tabla del metodo que se llama
                var resultadoDeclaracion = declaracionParametro.interpretar(arbol, newTabla);
                if (resultadoDeclaracion instanceof Errores) {
                    return resultadoDeclaracion;
                }
                // interpretando el valor del parametro de la tabla donde se llamo al metodo
                var valorInterpretado = valor.interpretar(arbol, tabla);
                if (valorInterpretado instanceof Errores) {
                    return valorInterpretado;
                }
                // obteniendo la variable que tiene el valor default
                var variable = newTabla.getVariable(identificador);
                if (variable == null) {
                    return new Errores("SEMANTICO", "Declaracion de parametro fallida", this.linea,
                            this.columna);
                }
                // validando que tengan el mismo tipo
                if (variable.getTipo().getTipo() != valor.tipo.getTipo()) {
                    return new Errores("SEMANTICO", "Tipos de parametros incorrectos", this.linea,
                            this.columna);
                }
                // mandandole el valor de la variable donde se llamo el metodo a la variable que
                // se envia como parametro del metodo
                variable.setValor(valorInterpretado);
            }
            // interpretando las instrucciones del metodo
            var resultadoFuncion = metodo.interpretar(arbol, newTabla);
            if (resultadoFuncion instanceof Errores) {
                return resultadoFuncion;
            }
        }
        return null;
    }
}
