package olc1_vj24_3363565520917.backend.expresiones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Find extends Instruccion {

    private String id;
    private Instruccion expresion;

    public Find(int linea, int columna, String id, Instruccion expresion) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Simbolo simboloExistente = tabla.getVariable(id);
        if (simboloExistente == null) {
            return new Errores("SEMANTICO", "La lista o vector no existe", this.linea, this.columna);
        }

        var res = expresion.interpretar(arbol, tabla);
        if (res instanceof Errores) {
            return res;
        }

        if (simboloExistente.getTipo2().equalsIgnoreCase("Lista")) {
            var valoresLista = (LinkedList<Object>) simboloExistente.getValor();

            boolean encontrado = buscarLista(valoresLista, res);
            this.tipo.setTipo(tipoDato.BOOLEANO);
            return encontrado;

        } else if (simboloExistente.getTipo2().equalsIgnoreCase("Vector1D")) {
            var valoresVector = (Object[]) simboloExistente.getValor();
            boolean encontrado = buscarVector1D(valoresVector, res);
            this.tipo.setTipo(tipoDato.BOOLEANO);
            return encontrado;
        } else if (simboloExistente.getTipo2().equalsIgnoreCase("Vector2D")) {
            var valoresVector = (Object[][]) simboloExistente.getValor();
            boolean encontrado = buscarVector2D(valoresVector, res);
            this.tipo.setTipo(tipoDato.BOOLEANO);
            return encontrado;
        } else {
            return new Errores("SEMANTICO", "No se puede buscar en este tipo de dato", this.linea, this.columna);
        }
    }

    private boolean buscarLista(LinkedList<Object> lista, Object valor) {
        for (Object object : lista) {
            if (object.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    private boolean buscarVector1D(Object[] vector, Object valor) {

        for (Object object : vector) {
            if (object.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    private boolean buscarVector2D(Object[][] vector, Object valor) {
        for (Object[] fila : vector) {
            for (Object columna : fila) {
                if (columna.equals(valor)) {
                    return true;
                }
            }
        }
        return false;
    }
}