public class Circle {
    private int x, y;
    private double radius;
    private String shape = "O";

    public Circle() {
    }

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        System.out.println(shape);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        double r = this.radius;
        return 3.14 * r * r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() { //sample : “[]”
        return shape;
    }

    public boolean equals(Circle that) {
        boolean isEqual = false;
        if (this.x == that.x && this.y == that.y && this.radius == that.radius) {
            isEqual = true;
        }
        return isEqual;
    }
}
