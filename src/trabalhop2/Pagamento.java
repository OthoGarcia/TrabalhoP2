
package trabalhop2;


public class Pagamento {
    private String data;
    private float valor;

    public Pagamento(String data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
