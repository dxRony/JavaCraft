package olc1_vj24_3363565520917.backend.simbolo;

public class Simbolo {
    private Tipo tipo;
    private String id;
    private Object valor;

    public Simbolo(Tipo tipo, String id) {
        this.tipo = tipo;
        this.id = id;
    }

    public Simbolo(Tipo tipo, String id, Object valor) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
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

    
}
