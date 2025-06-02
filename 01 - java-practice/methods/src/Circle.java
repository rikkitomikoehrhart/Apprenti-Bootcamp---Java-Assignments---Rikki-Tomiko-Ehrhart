public class Circle {
    public static double pi = 3.1415;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.radius * this.radius * Circle.pi;
    }
}
