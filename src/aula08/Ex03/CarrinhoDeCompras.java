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
        String result = "";
        for (Map.Entry<Produto, Integer> produto : produtos.entrySet()) {
            result += produto.toString() + "Quantidade: " + produto.getValue() + "\n";
        }
        System.out.println(result);
    }

    public double calcularTotal() {
        for (Map.Entry<Produto, Integer> produto : produtos.entrySet()) {
            this.total += produto.getKey().getPreco() * produto.getValue();
        }
        return this.total;
    }

}
