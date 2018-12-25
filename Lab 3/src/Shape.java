import java.awt.*;

public class Shape {
    private int x, y;
    private Color color;

    /*
    invariants: x and y should never be null
                Color should never be null
                x and y must be positive integers
                must return a value for Shape's area
     */

    public Shape() {
    }

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape(Shape other) {
        x = other.x;
        y = other.y;
        color = other.color;
    }

    public String toString() {
        return "(" + x + ", " + y + ") and color: " + color + " and area: " + getArea();
    }

    public int getArea() {
        return -1;
    }

    public void draw(Graphics g) {

    }
}
