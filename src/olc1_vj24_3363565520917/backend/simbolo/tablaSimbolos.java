package olc1_vj24_3363565520917.backend.simbolo;

import java.util.HashMap;
import java.util.LinkedList;

public class tablaSimbolos {

    private tablaSimbolos tablaAnterior;
    private HashMap<String, Simbolo> tablaActual;
    private String nombre;

    public tablaSimbolos() {
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public tablaSimbolos(tablaSimbolos tablaAnterior) {// para crear tabla que tenga una tabla anterior que recibe
        this.tablaAnterior = tablaAnterior;
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public tablaSimbolos getTablaAnterior() {
        return this.tablaAnterior;
    }

    public void setTablaAnterior(tablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
    }

    public HashMap<String, Simbolo> getTablaActual() {
        return tablaActual;
    }

    public void setTablaActual(HashMap<String, Simbolo> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean setVaribale(Simbolo simbolo) {// setear simbolo a la tabla de simbolos
        Simbolo busqueda = (Simbolo) this.tablaActual.get(simbolo.getId().toLowerCase());// viendo que el simbolo no
                                                                                         // exista

        if (busqueda == null) {// si no existe se inserta en la tabla de simbolos
            this.tablaActual.put(simbolo.getId().toLowerCase(), simbolo);
            return true;
        }
        return false;
    }

    public Simbolo getVariable(String id) {// obtener el simbolo de la tabla (variable)
        for (tablaSimbolos i = this; i != null; i = i.getTablaAnterior()) {// buscando variables en tablas anteriores, i
                                                                           // es donde nos encontramos
            Simbolo busqueda = (Simbolo) i.tablaActual.get(id.toLowerCase());// buscando la var en la tabla actual

            if (busqueda != null) {// si la var existe se retorna, sino se sigue buscando en la anterior
                return busqueda;
            }
        }
        return null;
    }

    public LinkedList<Simbolo> obtenerSimbolos() {
        LinkedList<Simbolo> listaSimbolos = new LinkedList<>();
        for (Simbolo simbolo : tablaActual.values()) {
            listaSimbolos.add(simbolo);
        }
        return listaSimbolos;
    }
}
