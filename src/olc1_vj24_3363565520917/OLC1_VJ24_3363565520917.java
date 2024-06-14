/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package olc1_vj24_3363565520917;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.analisis.parser;
import olc1_vj24_3363565520917.backend.analisis.scanner;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.frontend.Interfaz;

/**
 *
 * @author romar
 */
public class OLC1_VJ24_3363565520917 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // el breakpoint va en declaracion ast
            // ojo con el moduloooooooooooo
            String texto = "";
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new tablaSimbolos();
            tabla.setNombre("GLOBAL");
            ast.setConsola("");

            LinkedList<Errores> lista = new LinkedList<>();
            lista.addAll(s.listaErrores);
            lista.addAll(p.listaErrores);

            for (var a : ast.getInstrucciones()) {
                if (a == null) {
                    continue;
                }
                var res = a.interpretar(ast, tabla);
                if (res instanceof Errores) {
                    lista.add((Errores) res);
                }
            }
            System.out.println(ast.getConsola());

            for (var i : lista) {
                System.out.println(i);
            }
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            System.out.println(ex);
        }
        // Interfaz javaCraft = new Interfaz();
        // javaCraft.setVisible(true);
    }
}
