import java.awt.*;

public class Triforce extends Shape{
    private int side;

    public Triforce(int x, int y, int side) {
        super(x,y);
        this.side = side;
    }

    public double getArea() {
        int smallSide = side/2;
        double bigArea = (Math.sqrt(3)/4) * side * side;
        double smallArea = (Math.sqrt(3)/4) * smallSide * smallSide;
        return bigArea - smallArea;
    }

    public void draw(Graphics g) {
        int x1 = getX();
        int y1 = getY();

        int x3 = side + x1;
        int y3 = y1;

        int x2 = findMidpointX(x1, x3);
        int y2 = side + y1;

        int x4 = findMidpointX(x1, x2);
        int y4 = findMidpointY(y1, y2);

        int x5 = findMidpointX(x2, x3);
        int y5 = findMidpointY(y2, y3);

        int x6 = x2;
        int y6 = y1;

        g.setColor(Color.BLACK);

        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);

        g.drawLine(x4, y4, x5, y5);
        g.drawLine(x5, y5, x6, y6);
        g.drawLine(x6, y6, x4, y4);

        int[] fillX = {x4, x5, x6};
        int[] fillY = {y4, y5, y6};
        g.fillPolygon(fillX, fillY, 3);

        g.setColor(Color.YELLOW);

        int[] leftX = {x1, x6, x4};
        int[] leftY = {y1, y6, y4};

        int[] rightX = {x6, x5, x3};
        int[] rightY = {y6, y5, y3};

        int[] topX = {x4, x5, x2};
        int[] topY = {y4, y5, y2};

        g.fillPolygon(leftX, leftY, 3);
        g.fillPolygon(rightX, rightY, 3);
        g.fillPolygon(topX, topY, 3);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    private int findMidpointX(int x1, int x2) {
        return (x1 + x2)/2;
    }

    private int findMidpointY(int y1, int y2) {
        return (y1 + y2)/2;
    }
}
