public class LineSegment {
    private Point2D start, end;

    public LineSegment() {
        Point2D origin = new Point2D(0,0);
        start = origin;
        end = origin;
    }

    public LineSegment(Point2D start, Point2D end) {
        if (start == null) throw new NullPointerException("start must not be " +
                "null");
        this.start = start;
        if (end == null) throw new NullPointerException("end must not be null");
        this.end = end;
    }

    public LineSegment(LineSegment other) {
        start = other.start;
        end = other.end;
    }

    public Point2D getStartPoint() {
        return start;
    }

    public void setStartPoint(Point2D start) {
        this.start = start;
    }

    public Point2D getEndPoint() {
        return end;
    }

    public void setEndPoint(Point2D end) {
        this.end = end;
    }

    public double distance() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();

        dx *= dx;
        dy *= dy;

        return Math.sqrt(dx + dy);
    }

    public String toString() {
        return "Line start" + start.toString() + " and end" + end.toString();
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof LineSegment)) return false;
        LineSegment that = (LineSegment) other;
        return this.start.equals(that.start) && this.end.equals(that.end);
    }
}

/*
What is a privacy leak? It's a situation when a private instance variable can be
changed outside of its class
Do your getters or setters have privacy leaks? My getters and setters do have
 privacy leaks
Where else could a privacy leak occur? Privacy leaks could occur in other
methods that deal with private instance variables. It could happen with
Point2D's getters, setters, resetToOrigin, and translate
 */