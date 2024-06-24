package olc1_vj24_3363565520917.backend.instrucciones;

import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;

public class AsignacionVector extends Instruccion {

    private String identificador;
    private Instruccion indice1;
    private Instruccion indice2;
    private Instruccion valor;

    public AsignacionVector(int linea, int columna, String identificador, Instruccion indice1,
            Instruccion indice2, Instruccion valor) {
        super(new Tipo(tipoDato.VOID), linea, columna);
        this.identificador = identificador;
        this.indice1 = indice1;
        this.indice2 = indice2;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Simbolo vectorExistente = tabla.getVariable(identificador);
        if (vectorExistente == null) {
            return new Errores("SEMANTICO", "La lista no existe", this.linea, this.columna);
        }

        if (vectorExistente.getTipo2().equalsIgnoreCase("Vector")) {

            if (indice2 == null) {// si solo hay 1 indice -> 1D
                // interpretando el indice
                var indiceVector1 = indice1.interpretar(arbol, tabla);
                if (indiceVector1 instanceof Errores) {
                    return indiceVector1;
                }

                var newValor = this.valor.interpretar(arbol, tabla);
                if (newValor instanceof Errores) {
                    return newValor;
                }
                if (vectorExistente.getTipo().getTipo() != this.valor.tipo.getTipo()) {
                    return new Errores("SEMANTICO", "Tipos no coincidentes para la asignacion", this.linea,
                            this.columna);
                }
                // obteniendo el vector y casteandolo
                Object[] vector1D = (Object[]) vectorExistente.getValor();
                // mandando el nuevo valor al indice indicado
                vector1D[(int) indiceVector1] = newValor;

            } else { // 2 indices -> 2D
                var indiceVector1 = indice1.interpretar(arbol, tabla);
                if (indiceVector1 instanceof Errores) {
                    return indiceVector1;
                }
                var indiceVector2 = indice2.interpretar(arbol, tabla);
                if (indiceVector2 instanceof Errores) {
                    return indiceVector2;
                }
                var newValor = this.valor.interpretar(arbol, tabla);
                if (newValor instanceof Errores) {
                    return newValor;
                }
                if (vectorExistente.getTipo().getTipo() != this.valor.tipo.getTipo()) {
                    return new Errores("SEMANTICO", "Tipos no coincidentes para la asignacion", this.linea,
                            this.columna);
                }
                Object[][] vector2D = (Object[][]) vectorExistente.getValor();
                vector2D[(int) indiceVector1][(int) indiceVector2] = newValor;
            }
        } else {// sino es de tipo lista se toma como error
            return new Errores("SEMANTICO", "El id no pertenece a un vector", this.linea, this.columna);
        }
        return null;
    }

}
