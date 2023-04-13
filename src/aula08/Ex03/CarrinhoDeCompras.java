package aula08.Ex03;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras implements Compra {
    private Map<Produto, Integer> produtos;
    private double total;

    public CarrinhoDeCompras() {
        produtos = new HashMap<>();
        this.total = 0;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, quantidade);
    }

    public void listarProdutos() {

    }

    public void calcularTotal() {

    }

}
