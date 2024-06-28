package olc1_vj24_3363565520917.backend.expresiones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class Decremento extends Instruccion {

    private Instruccion variable;

    public Decremento(int linea, int columna, Instruccion variable) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.variable = variable;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        if (!(variable instanceof AccesoVar)) {
            return new Errores("SEMANTICO", "Decremento no valido", this.linea, this.columna);

        }
        var acceso = (AccesoVar) variable;
        var valor = acceso.interpretar(arbol, tabla);

        if (valor instanceof Errores) {
            return valor;
        }
        // validaciones
        if (acceso.tipo.getTipo() != tipoDato.ENTERO && acceso.tipo.getTipo() != tipoDato.DECIMAL) {
            return new Errores("SEMANTICO", "Solo se puede decrementar variables de tipo int o double", this.linea,
                    this.columna);
        }

        if (!tabla.getVariable(acceso.id).isMutabilidad()) {
            return new Errores("SEMANTICO", "Esta variable (CONST) no se puede decrementar", this.linea, this.columna);
        }

        if (acceso.tipo.getTipo() == tipoDato.ENTERO) {
            int valorNuevo = (int) valor - 1;
            tabla.getVariable(acceso.id).setValor(valorNuevo);

            return valorNuevo;
        } else {
            double valorNuevo = (double) valor - 1.0;
            tabla.getVariable(acceso.id).setValor(valorNuevo);

            return valorNuevo;
        }
    }
}