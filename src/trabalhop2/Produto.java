
package trabalhop2;

public class Produto {
    private int id;
    private String descricao;
    private float preco;
    private int quant;

    public Produto(String descricao, float preco, int quant) {
        this.descricao = descricao;
        this.preco = preco;
        this.quant = quant;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
