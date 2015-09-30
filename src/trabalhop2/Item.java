
package trabalhop2;

public class Item {
    private int id;
    private int idProduto;
    private int quant;
    private float preco;

    public Item(int idProduto, int quant, float preco) {
        this.idProduto = idProduto;
        this.quant = quant;
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    
    public float calcSubTotal(){
    return 0;
    }
}
