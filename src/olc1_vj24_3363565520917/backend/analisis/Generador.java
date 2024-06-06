/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olc1_vj24_3363565520917.backend.analisis;

/**
 *
 * @author romar
 */
public class Generador {

    public static void main(String[] args) {
        generarCompilador();
    }

    public static void generarCompilador() {
        try {
            String ruta = "src/olc1_vj24_3363565520917/backend/analisis/";
            /*
             * PARAMETROS
             * 1) ruta: ruta del archivo.jflex
             * 2) -d: donde se generaran la salida
             * 3) ruta:
             */

            String Flex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(Flex);


            /*
             * PARAMETROS
             * 1) -destdir: ruta donde se generara la salida
             * 2) ruta: ruta de la salida
             * 3) -parser: indica el nombre del archivo
             * 4) ruta: ruta del archivo.cup
             */
            String Cup[] = {"-destdir", ruta, "-parser", "parser", ruta + "sintactico.cup"};
            java_cup.Main.main(Cup);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
