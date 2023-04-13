package aula08.Ex03;

public class ProdutoGenerico implements Produto {
    private String nome;
    private int qntStock;
    private double preco;

    public ProdutoGenerico(String nome, int qntStock, double preco) {
        this.nome = nome;
        this.qntStock = qntStock;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.qntStock;
    }

    public void adicionarQuantidade(int quantidade) {
        this.qntStock += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.qntStock -= quantidade;
    }
}
