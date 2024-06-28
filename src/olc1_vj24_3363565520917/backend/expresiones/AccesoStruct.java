package olc1_vj24_3363565520917.backend.expresiones;

import java.util.HashMap;
import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AccesoStruct extends Instruccion {

    private String id;
    private String campo;

    public AccesoStruct(int linea, int columna, String id, String campo) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.campo = campo;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // buscando struct
        Simbolo structExistente = tabla.getVariable(id);
        if (structExistente == null) {
            return new Errores("SEMANTICO", "El struct no existe", this.linea, this.columna);
        }
        boolean campoEncontrado = false;
        // validando que el simbolo es struct
        if (structExistente.getTipo2().equals("Struct")) {
            // obteniendo la listaValores
            var valoresStruct = (LinkedList<HashMap>) structExistente.getValor();
            // recorriendo la lista de valores en busca del campo
            for (int i = 0; i < valoresStruct.size(); i++) {
                // si el campo es encontrado
                if (valoresStruct.get(i).get("id").equals(campo)) {
                    campoEncontrado = true;
                    var valorBuscado = (Instruccion) valoresStruct.get(i).get("valor");
                    var resValorBuscado = valorBuscado.interpretar(arbol, tabla);
                    if (resValorBuscado instanceof Errores) {
                        return resValorBuscado;
                    }
                    var tipoValorBuscado = (Instruccion) valoresStruct.get(i).get("valor");
                    this.tipo.setTipo(tipoValorBuscado.tipo.getTipo());
                    return resValorBuscado;
                }
            }
            if (!campoEncontrado) {
                return new Errores("SEMANTICO", "El campo no existe en este struct", this.linea, this.columna);
            }
        }
        return null;
    }
}
