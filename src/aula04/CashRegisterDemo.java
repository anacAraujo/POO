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

    public String toString() {
        return String.format("%10s %10.2f %10d %10.2f\n",
                this.name,
                this.price,
                this.quantity,
                this.price * this.quantity);
    }
}

class CashRegister {

    private Product[] carrinho;
    private int qntProdutos;

    public CashRegister() {
        this.carrinho = new Product[5];
        this.qntProdutos = 0;
    }

    public void addProduct(Product novoProduto) {
        carrinho[qntProdutos] = novoProduto;
        qntProdutos++;
    }

    public String toString() {
        String imprimir = String.format("%10s %10s %10s %10s \n", "Product", "Price", "Quantity", "Total");
        float totalValue = 0;

        for (int i = 0; i < carrinho.length; i++) {
            imprimir += carrinho[i].toString();
            totalValue += carrinho[i].getPrice() * carrinho[i].getQuantity();
        }
        imprimir += String.format("\n%9s %7.2f", "Total value: ", totalValue);
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