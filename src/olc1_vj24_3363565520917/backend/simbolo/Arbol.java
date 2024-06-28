package olc1_vj24_3363565520917.backend.simbolo;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.instrucciones.DeclaracionStruct;
import olc1_vj24_3363565520917.backend.instrucciones.Metodo;

public class Arbol {

    private LinkedList<Instruccion> instrucciones;
    private String consola;
    private tablaSimbolos tablaGlobal;
    public LinkedList<Errores> errores;
    public LinkedList<Simbolo> simbolos;
    public LinkedList<Instruccion> funciones;
    public LinkedList<Instruccion> structs;

    public Arbol(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
        this.consola = "";
        this.tablaGlobal = new tablaSimbolos();
        this.errores = new LinkedList<>();
        this.simbolos = new LinkedList<>();
        this.funciones = new LinkedList<>();
        this.structs = new LinkedList<>();
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public tablaSimbolos getTablaGlobal() {
        return tablaGlobal;
    }

    public void setTablaGlobal(tablaSimbolos tablaGlobal) {
        this.tablaGlobal = tablaGlobal;
    }

    public LinkedList<Errores> getErrores() {
        return errores;
    }

    public void setErrores(LinkedList<Errores> errores) {
        this.errores = errores;
    }

    public void Print(String valor) {// print es una instruccion
        this.consola += valor + "\n";
    }

    public LinkedList<Simbolo> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(LinkedList<Simbolo> simbolos) {
        this.simbolos = simbolos;
    }

    public void agregarSimbolos(LinkedList<Simbolo> nuevoSimbolo) {
        this.simbolos.addAll(nuevoSimbolo);
    }

    public LinkedList<Instruccion> getFunciones() {
        return funciones;
    }

    public void setFunciones(LinkedList<Instruccion> funciones) {
        this.funciones = funciones;
    }

    public void addFunciones(Instruccion funcion) {
        // llamar a getFuncion y si es null agregar funcion, sino no agregar
        // opcional
        this.funciones.add(funcion);
    }

    public Instruccion getFuncion(String id) {
        for (var i : this.funciones) {
            if (i instanceof Metodo) {
                if (((Metodo) i).id.equalsIgnoreCase(id)) {
                    return i;
                }
            }
        }
        return null;
    }

    public LinkedList<Instruccion> getStructs() {
        return structs;
    }

    public void setStructs(LinkedList<Instruccion> structs) {
        this.structs = structs;
    }

    public void addStruct(Instruccion struct) {
        this.structs.add(struct);
    }

    public Instruccion getStruct(String id) {
        for (var i : this.structs) {
            if (i instanceof DeclaracionStruct) {
                if (((DeclaracionStruct) i).id.equalsIgnoreCase(id)) {
                    return i;
                }
            }
        }
        return null;
    }
    // crear metodo getStruct
}