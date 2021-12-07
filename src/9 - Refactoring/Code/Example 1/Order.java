package pt.up.fe.ldts.example1;
import java.util.ArrayList;
import java.util.List;

// Smell --> Data Clumbs
// https://refactoring.guru/smells/data-clumps

public class Order {

    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (OrderLine line : lines) {
            total += line.product.getPrice() * line.quantity;
        }
        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        return getTotal() > 100;
    }

    public String printOrder() {

        StringBuffer printBuffer = new StringBuffer();
        for (OrderLine line : lines)
            printBuffer.append(line.product.getName() + "(x" + line.quantity + "): " + (line.product.getPrice() * line.quantity) + "\n");

        printBuffer.append("Total: " + getTotal());
        return printBuffer.toString();
    }
}