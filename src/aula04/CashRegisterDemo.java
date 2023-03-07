package aula04;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class CashRegister {

    float valorTotal = 0;
    Product[] carrinho = new Product[5];
    int qntProdutos = 0;

    public float addProduct(Product novoProduto) {
        valorTotal += novoProduto.getPrice() * novoProduto.getQuantity();

        carrinho[qntProdutos] = novoProduto;
        qntProdutos++;

        return valorTotal;
    }

    public String toString() {
        String imprimir = "";
        for (int i = 0; i < carrinho.length; i++) {
            imprimir += "Nome: " + carrinho[i].getName() + " Preço: " + carrinho[i].getPrice() + " Quantidade: "
                    + carrinho[i].getQuantity() + " valor total: " + valorTotal;
        }
        return imprimir;
    }

}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));

        // TODO: Listar o conteúdo e valor total
        System.out.println(cr);

    }
}