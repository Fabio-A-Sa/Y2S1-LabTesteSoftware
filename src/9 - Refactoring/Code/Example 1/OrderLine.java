package pt.up.fe.ldts.example1;

public class OrderLine {

    public Product product;
    public int quantity;
    public int total;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}