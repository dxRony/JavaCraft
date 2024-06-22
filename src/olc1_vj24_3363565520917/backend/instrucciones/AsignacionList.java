package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AsignacionList extends Instruccion {

    private String identificador; // identificador de la lista
    private Instruccion indice; // indice del valor a asignar
    private Instruccion valor; // valor a asignar

    public AsignacionList(int linea, int columna, String identificador, Instruccion indice,
            Instruccion valor) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.identificador = identificador;
        this.indice = indice;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Simbolo listaExistente = tabla.getVariable(identificador);// viendo que la lista exista
        if (listaExistente == null) {
            return new Errores("SEMANTICO", "La lista no existe", this.linea, this.columna);
        }

        if (listaExistente.getTipo2().equalsIgnoreCase("Lista")) {// validando que sea una lista
            // interpretando y validando el nuevo valor
            var lista = (LinkedList<Object>) listaExistente.getValor();// guardando lista

            var indiceAsignar = this.indice.interpretar(arbol, tabla);
            if (indiceAsignar instanceof Errores) {
                return indiceAsignar;
            }

            var newValor = this.valor.interpretar(arbol, tabla);
            if (newValor instanceof Errores) {
                return newValor;
            }
            if (listaExistente.getTipo().getTipo() != this.valor.tipo.getTipo()) {
                return new Errores("SEMANTICO", "Tipos no coincidentes para la asignacion", this.linea, this.columna);
            }

            lista.set((int) indiceAsignar, newValor);// modificando el valor en el indice recibido

        } else {// sino es de tipo lista se toma como error
            return new Errores("SEMANTICO", "El id no pertenece a una lista", this.linea, this.columna);
        }
        return null;
    }
}
