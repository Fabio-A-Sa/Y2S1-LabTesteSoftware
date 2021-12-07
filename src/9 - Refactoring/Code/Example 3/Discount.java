package pt.up.fe.ldts.example3;

public class Discount {

    private GenericDiscount discount = null;

    public Discount(int fixed) {
        discount = new FixedDiscount(fixed);
    }

    public Discount(double percentage) {
        discount = new PercentageDiscount(percentage);
    }

    public double applyDiscount(double price) {
        return discount != null ? discount.applyDiscount(price) : price;
    }
}
