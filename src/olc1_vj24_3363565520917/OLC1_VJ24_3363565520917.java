/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package olc1_vj24_3363565520917;

import java.io.BufferedReader;
import java.io.StringReader;
import olc1_vj24_3363565520917.backend.analisis.parser;
import olc1_vj24_3363565520917.backend.analisis.scanner;
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
            String texto = "println(1+2+3+4+5-20/2.0);println(\"Cadena a Imprimir\");";
            parser p = new parser(new scanner(new BufferedReader(new StringReader(texto))));
            var resultado = p.parse();
            System.out.println(resultado.value);
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
        }
        Interfaz javaCraft = new Interfaz();
        javaCraft.setVisible(true);
    }

}
