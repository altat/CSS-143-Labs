public class ColorWithAlpha extends SimpleColor{
    private int alpha;

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        if (alpha < 0 || alpha > 255) throw new ColorException();
        this.alpha = alpha;
    }

    public ColorWithAlpha(int alpha) {
        setAlpha(alpha);
    }

    public ColorWithAlpha(int r, int g, int b, int alpha) {
        super(r, g, b);
        setAlpha(alpha);
    }

    public ColorWithAlpha(ColorWithAlpha copy) {
        super(copy); //This line is calling the copy constructor of the super
                    // class which is SimpleColor.
        setAlpha(copy.alpha);
    }

    public String toString() {
        //the following call to super calls the toString() method of the
        // super class SimpleColor
        return super.toString() + ", alpha:"+ alpha;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ColorWithAlpha)) return false;
        ColorWithAlpha that = (ColorWithAlpha) o;
        return super.equals(that) && alpha == that.alpha;
    }
}
