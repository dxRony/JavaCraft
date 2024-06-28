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

public class InstanciaStruct extends Instruccion {

    private String mutabilidad;
    private String id;
    private String idStruct;
    private LinkedList<HashMap> valoresStruct;

    public InstanciaStruct(int linea, int columna, String mutabilidad, String id, String idStruct,
            LinkedList<HashMap> valoresStruct) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.mutabilidad = mutabilidad;
        this.id = id;
        this.idStruct = idStruct;
        this.valoresStruct = valoresStruct;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // obteniendo el struct existente
        var structExistente = arbol.getStruct(idStruct);
        if (structExistente == null) {
            return new Errores("SEMANTICO", "La variable no existe", this.linea, this.columna);
        }
        // obteniendo los atributos del struct
        if (structExistente instanceof DeclaracionStruct declaracion) {
            // obteniendo los parametros del struct
            LinkedList<HashMap> atributosStruct = declaracion.atributos;
            if (atributosStruct.size() != this.valoresStruct.size()) {
                return new Errores("SEMANTICO", "Los valores del struct no estan correctos", this.linea,
                        this.columna);
            }
            // recorriendo cada hashMap para validar los valores con los atributos
            for (int i = 0; i < this.valoresStruct.size(); i++) {
                // guardando el id y tipo del atributo
                var idAtributo = (String) atributosStruct.get(i).get("id");
                var tipoAtributo = (Tipo) atributosStruct.get(i).get("tipo");
                // guardando el id y el valor del struct
                var idValor = (String) this.valoresStruct.get(i).get("id");
                var valor = (Instruccion) this.valoresStruct.get(i).get("valor");
                // si el id de los atributos y valores coinciden
                if (idAtributo.equalsIgnoreCase(idValor)) {
                    var resValor = valor.interpretar(arbol, tabla);
                    if (resValor instanceof Errores) {
                        return resValor;
                    }
                    // si el tipo del valor y atributo no coinciden
                    if (valor.tipo.getTipo() != tipoAtributo.getTipo()) {
                        return new Errores("SEMANTICO", "El tipo de dato no coincide", this.linea,
                                this.columna);
                    }
                } else {
                    return new Errores("SEMANTICO", "El id no coincide", this.linea,
                            this.columna);
                }
            } // si el for se completa, los valores coinciden con los atributos del struct
              // manejando la mutabilidad
            boolean mutabilidadBool = false;
            if (mutabilidad.equals("var")) {// si es var, es mutable
                mutabilidadBool = true;
            } else if (mutabilidad.equals("const")) {
                mutabilidadBool = false;
            }
            // creando simbolo (variable tipo struct)
            Simbolo s = new Simbolo(id, new Tipo(tipoDato.STRUCT), "Struct", tabla.getNombre(), valoresStruct,
                    mutabilidadBool, this.linea, this.columna);

            boolean creacion = tabla.setVariable(s);
            if (!creacion) {
                return new Errores("SEMANTICO", "La variable ya existe", this.linea, this.columna);
            }
        }
        return null;
    }
}