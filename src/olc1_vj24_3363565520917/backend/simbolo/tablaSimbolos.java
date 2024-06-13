package olc1_vj24_3363565520917.backend.simbolo;

import java.util.HashMap;

public class tablaSimbolos {

    private tablaSimbolos tablaAnterior;
    private HashMap<String, Object> tablaActual;
    private String nombre;

    public tablaSimbolos() {
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public tablaSimbolos(tablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public tablaSimbolos getTablaAnterior() {
        return tablaAnterior;
    }

    public void setTablaAnterior(tablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
    }

    public HashMap<String, Object> getTablaActual() {
        return tablaActual;
    }

    public void setTablaActual(HashMap<String, Object> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean setVaribale(Simbolo simbolo) {//setear simbolo a la tabla de simbolos
        Simbolo busqueda = (Simbolo) this.tablaActual.get(simbolo.getId().toLowerCase());//viendo que el simbolo no exista aun

        if (busqueda == null) {//si no existe se inserta en la tabla de simbolos
            this.tablaActual.put(simbolo.getId().toLowerCase(), simbolo);
            return true;
        }
        return false;
    }

    public Simbolo getVariable(String id) {//obtener el simbolo de la tabla (variable)
        Simbolo busqueda = (Simbolo) this.tablaActual.get(id.toLowerCase());//buscando la var en la tabla

        if (busqueda != null) {//si la var existe
            return busqueda;
        }
        return null;
    }
}
