package olc1_vj24_3363565520917.backend.instrucciones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Match extends Instruccion {

    private Instruccion expresion;// la que se compara para el caso
    private LinkedList<Caso> casos;// lista de casos, para comparar
    private Caso casoDefault;// si no coincide algun caso, se ejecuta este

    public Match(int linea, int columna, Instruccion expresion, LinkedList<Caso> casos, Caso casoDefault) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.expresion = expresion;
        this.casos = casos;
        this.casoDefault = casoDefault;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var valor = this.expresion.interpretar(arbol, tabla);

        if (valor instanceof Errores) {
            return valor;
        }
        for (var caso : casos) {
            var valorCaso = caso.interpretar(arbol, tabla);// interpretando cada caso

            if (valorCaso instanceof Errores) {
                return valorCaso;
            }
            if (valor.equals(valorCaso)) {// si los casos coinciden (hacen match)
                caso.ejecutarCaso(arbol, tabla);// ejecutando el caso -> las instrucciones que tiene adentro
                return null;
            }
        }
        if (casoDefault != null) {// si hay un caso default, se ejecuta
            casoDefault.ejecutarCaso(arbol, tabla);
        }
        return null;
    }
}