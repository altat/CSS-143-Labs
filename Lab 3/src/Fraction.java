public class Fraction {
    public final int numerator;
    public final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator" +
                " can't be zero.");
        int gcd = findGCD(numerator, denominator);
        this.numerator = (numerator / gcd);
        this.denominator = (denominator / gcd);
    }

    public Fraction(Fraction other) {
        numerator = other.numerator;
        denominator = other.denominator;
    }

    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction add(Fraction that) {
        int newDenominator = denominator * that.denominator;
        int n1 = newDenominator / numerator;
        int n2 = newDenominator / that.numerator;
        int newNumerator = n1 + n2;

        return new Fraction(newNumerator, newDenominator);
    }

    public boolean equals(Object other) {
        if(other != null && !(other instanceof Fraction)) return false;
        //what does this code do? it says the fractions are not equal if
        // other is not an instance of the Fraction Class
        Fraction that = (Fraction) other;
            //and this code? This code typecasts 'other' into a Fraction Object
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    private int findGCD(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        } else {
            return findGCD(denominator, numerator % denominator);
        }
    }
}
