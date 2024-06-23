package olc1_vj24_3363565520917.backend.expresiones;

import java.util.LinkedList;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AccesoVector extends Instruccion {

    private String identificador;
    private LinkedList<Instruccion> indicesVector;

    public AccesoVector(int linea, int columna, String identificador, LinkedList<Instruccion> indicesVector) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.identificador = identificador;
        this.indicesVector = indicesVector;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Simbolo vectorExistente = tabla.getVariable(identificador);
        if (vectorExistente == null) {
            return new Errores("SEMANTICO", "El vector: " + this.identificador + ", no existe", this.linea,
                    this.columna);
        }
        if (vectorExistente.getTipo2().equalsIgnoreCase("Vector")) {
            if (indicesVector.size() == 1) {
                var indiceLista = indicesVector.get(0).interpretar(arbol, tabla);
                if ( indiceLista instanceof Errores) {
                    return indiceLista;
                }

                Object[] vector1D = (Object[]) vectorExistente.getValor();
                this.tipo.setTipo(vectorExistente.getTipo().getTipo());
                return vector1D[(int)indiceLista];
                
            } else if (indicesVector.size() == 2) {
                var indiceLista1 = indicesVector.get(0).interpretar(arbol, tabla);
                if (indiceLista1 instanceof Errores) {
                    return indiceLista1;
                }
                var indiceLista2 = indicesVector.get(1).interpretar(arbol, tabla);
                if (indiceLista2 instanceof Errores) {
                    return indiceLista2;
                }

                Object[][] vector2D = (Object[][]) vectorExistente.getValor();
                this.tipo.setTipo(vectorExistente.getTipo().getTipo());
                return vector2D[(int) indiceLista1][(int) indiceLista2];
            }
        }
        return null;
    }

}
