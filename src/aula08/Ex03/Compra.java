package aula08.Ex03;

public interface Compra {
    void adicionarProduto(Produto produto, int quantidade);

    void listarProdutos();

    // void -----> double: é chamado no programa main disponibilizado à espera que
    // seja retornado um valor.
    double calcularTotal();
}