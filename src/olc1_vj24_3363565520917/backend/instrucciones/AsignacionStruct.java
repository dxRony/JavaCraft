package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.HashMap;
import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AsignacionStruct extends Instruccion {

    private String id;
    private String campo;
    private Instruccion valor;

    public AsignacionStruct(int linea, int columna, String id, String campo, Instruccion valor) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.id = id;
        this.campo = campo;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // buscando variable del struct
        Simbolo structExistente = tabla.getVariable(id);
        if (structExistente == null) {
            return new Errores("SEMANTICO", "El struct no existe", this.linea, this.columna);
        }
        // interpretando el valor
        var newValor = valor.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }
        // si la variable es de tipo struct
        if (structExistente.getTipo2().equalsIgnoreCase("Struct")) {
            // obteniendo los valores del struct
            var valoresStruct = (LinkedList<HashMap>) structExistente.getValor();
            // recorriendo el linkedList en busca del campo a asignar
            for (int i = 0; i < valoresStruct.size(); i++) {
                // si el campo y id coinciden
                if (valoresStruct.get(i).get("id").equals(campo)) {
                    // guardando el valor que hay en el campo a asignar
                    var valorActual = (Instruccion) valoresStruct.get(i).get("valor");
                    // si no coinciden los tipos
                    if (valorActual.tipo.getTipo() != valor.tipo.getTipo()) {
                        return new Errores("SEMANTICO", "Los tipos no coinciden", this.linea, this.columna);
                    }
                    // guardando el nuevo valor
                    valoresStruct.get(i).replace("valor", valor);
                }
            }
        }
        return null;
    }
}