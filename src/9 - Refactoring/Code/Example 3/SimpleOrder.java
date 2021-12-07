package pt.up.fe.ldts.example3;

public class SimpleOrder {

    private Discount discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount == null ? price : discount.applyDiscount(price);
    }
}
