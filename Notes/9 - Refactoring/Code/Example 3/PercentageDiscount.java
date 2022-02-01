package pt.up.fe.ldts.example3;

public class PercentageDiscount implements GenericDiscount {

    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double price) {
        return price * (1 - percentage);
    }
}
