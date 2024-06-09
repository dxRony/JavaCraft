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
        // TODO code application logic here
        try {
            String texto = "println(-1.5);" + "println(\"a\");";
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new tablaSimbolos();
            tabla.setNombre("GLOBAL");
            ast.setConsola("");
            for (var a : ast.getInstrucciones()) {
                var res = a.interpretar(ast, tabla);
            }
            System.out.println(ast.getConsola());

        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            System.out.println(ex);
        }
        // Interfaz javaCraft = new Interfaz();
        // javaCraft.setVisible(true);
    }

}
