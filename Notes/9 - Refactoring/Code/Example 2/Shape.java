package pt.up.fe.ldts.example2;

// Smell --> Temporary field
// https://refactoring.guru/smells/temporary-field

public class Shape {

    private Object object;

    public Shape(double x, double y, double width, double height) {
        this.object = new Rectangle(x, y, width, height);
    }

    public Shape(double x, double y, double radius) {
        this.object = new Circle(x, y, radius);
    }

    public double getArea() {
        return object.getArea();
    }

    public double getPerimeter() {
        return object.getPerimeter();
    }

    public void draw(GraphicFramework graphics) {
        object.draw(graphics);
    }
}