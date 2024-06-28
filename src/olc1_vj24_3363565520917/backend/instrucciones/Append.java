package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Append extends Instruccion {

    private String identificador;
    private Instruccion valor;

    public Append(int linea, int columna, String identificador, Instruccion valor) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.identificador = identificador;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Simbolo listaExistente = tabla.getVariable(identificador);

        if (listaExistente == null) {
            return new Errores("SEMANTICO", "La lista: " + this.identificador + " no existe", linea, columna);
        }

        if (listaExistente.getTipo2().equalsIgnoreCase("Lista")) {
            var lista = (LinkedList<Object>) listaExistente.getValor();

            var valor = this.valor.interpretar(arbol, tabla);
            if (valor instanceof Errores) {
                return valor;
            }
            if (listaExistente.getTipo().getTipo() != this.valor.tipo.getTipo()) {
                return new Errores("SEMANTICO", "Tipos no coincidentes para añadir", this.linea, this.columna);
            }
            lista.add(valor);
        } else {
            return new Errores("SEMANTICO", "El id no pertenece a una lista", this.linea, this.columna);
        }
        return null;
    }
}