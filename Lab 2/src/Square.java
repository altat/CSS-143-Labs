public class Square {
    private int x, y;
    private double sideLength;
    private String shape = "[]";

    public Square() {

    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(int x, int y, double sideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
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

    public double getSideLength() {
        return sideLength;
    }

    public double getArea() {
        double side = this.getSideLength();
        return side * side;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public String toString() { //sample : “[]”
        return shape;
    }

    public boolean equals(Square that) {
        boolean isEqual = false;
        if (this.x == that.x && this.y == that.y && this.sideLength == that.sideLength) {
            isEqual = true;
        }
        return isEqual;
    }
}
