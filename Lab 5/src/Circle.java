import java.awt.*;

public class Circle extends Shape{
    private double radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void draw(Graphics g) { ;
        int x = getX();
        int y = getY();
        int diameter = (int) radius*2;

        g.drawOval(x,y, diameter, diameter);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
