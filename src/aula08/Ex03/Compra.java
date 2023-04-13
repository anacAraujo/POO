package aula08.Ex03;

public interface Compra {
    void adicionarProduto(Produto produto, int quantidade);

    void listarProdutos();

    void calcularTotal();
}