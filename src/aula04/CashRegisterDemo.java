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
        String imprimir = String.format("%10s %10s %10s %10s \n", "Product", "Price", "Quantity", "Total");
        float totalValue = 0;

        for (int i = 0; i < carrinho.length; i++) {
            imprimir += String.format("%10s %10.2f %10d %10.2f\n",
                    carrinho[i].getName(),
                    carrinho[i].getPrice(),
                    carrinho[i].getQuantity(),
                    carrinho[i].getPrice() * carrinho[i].getQuantity());
            totalValue += carrinho[i].getPrice() * carrinho[i].getQuantity();
        }
        imprimir += String.format("%9s %7.2f", "Total value: ", totalValue);
        return imprimir;
    }

}

public class CashRegisterDemo {

    public static void main(String[] args) {

        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));

        System.out.println(cr);

    }
}