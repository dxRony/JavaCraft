package olc1_vj24_3363565520917.backend.expresiones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AccesoList extends Instruccion {

    private String identificador;
    private Instruccion indice;

    public AccesoList(int linea, int columna, String identificador, Instruccion indice) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.identificador = identificador;
        this.indice = indice;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Simbolo listaExistente = tabla.getVariable(identificador);

        if (listaExistente == null) {
            return new Errores("SEMANTICO", "La lista: " + this.identificador + ", no existe", this.linea,
                    this.columna);
        }
        if (listaExistente.getTipo2().equalsIgnoreCase("Lista")) {

            var lista = (LinkedList<Object>) listaExistente.getValor();

            var indiceObtener = indice.interpretar(arbol, tabla);
            if (indiceObtener instanceof Errores) {
                return indiceObtener;
            }
            this.tipo.setTipo(listaExistente.getTipo().getTipo());
            return lista.get((int) indiceObtener);
        } else {
            return new Errores("SEMANTICO", "El id no pertenece a una lista", this.linea, this.columna);
        }
    }
}