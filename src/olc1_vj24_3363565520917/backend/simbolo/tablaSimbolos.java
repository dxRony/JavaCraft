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

}