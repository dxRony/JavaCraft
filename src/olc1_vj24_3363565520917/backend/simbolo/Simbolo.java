package olc1_vj24_3363565520917.backend.simbolo;

public class Simbolo {
    private String id;
    private Tipo tipo;
    private String tipo2;
    private String entorno;
    private Object valor;
    private boolean mutabilidad;// var -> true, const -> false
    private int linea;
    private int columna;

    public Simbolo(Tipo tipo, String id) {
        this.tipo = tipo;
        this.id = id;
    }

    // constructor para variables, vectores e instancias struct
    public Simbolo(String id, Tipo tipo, String tipo2, String entorno, Object valor, boolean mutabilidad,
            int linea, int columna) {
        this.id = id;
        this.tipo = tipo;
        this.tipo2 = tipo2;
        this.entorno = entorno;
        this.valor = valor;
        this.mutabilidad = mutabilidad;
        this.linea = linea;
        this.columna = columna;
    }

    // constructor para listas
    public Simbolo(String id, Tipo tipo, String tipo2, String entorno, Object valor, int linea, int columna) {
        this.id = id;
        this.tipo = tipo;
        this.tipo2 = tipo2;
        this.entorno = entorno;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public boolean isMutabilidad() {
        return mutabilidad;
    }

    public void setMutabilidad(boolean mutabilidad) {
        this.mutabilidad = mutabilidad;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getEntorno() {
        return entorno;
    }

    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Simbolo [id=" + id + ", tipo=" + tipo + ", tipo2=" + tipo2 + ", entorno=" + entorno + ", valor=" + valor
                + ", mutabilidad=" + mutabilidad + ", linea=" + linea + ", columna=" + columna + "]";
    }
}
