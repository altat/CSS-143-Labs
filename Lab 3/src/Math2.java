public class Math2 {
    public static final double PI = 3.14159;
    public static final double E = 2.71828;

    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    public static double max(double a, double b) {
        return (a >= b) ? a : b;
    }

    public static int pow(int base, int exp) {
        int ans = 1;
        if (exp == 0) {
            return 1;
        } else if (exp > 0) {
            for (int i = 0; i < exp; i++) {
                ans *= base;
            }
            return ans;
        } else {
            for (int i = 1; i < exp * -1; i++) {
                ans *= base;
            }
            return 1/ans;
        }
    }
}
