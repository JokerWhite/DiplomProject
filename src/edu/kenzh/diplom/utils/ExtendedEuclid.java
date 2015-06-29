package edu.kenzh.diplom.utils;

public class ExtendedEuclid {

    /**
     * extended Euclid algorithm
     * @param p first int
     * @param q second int
     * @return int[2] where
     * d =int[0]
     * x =int[1]
     * y =int[2]
     */

    public static int[] gcd(int p, int q) {
        if (q == 0)
            return new int[]{p, 1, 0};

        int[] values = gcd(q, p % q);
        int d = values[0];
        int a = values[2];
        int b = values[1] - (p / q) * values[2];
        return new int[]{d, a, b};
    }

    public static int inverse(int p, int q) {
        int[] values = gcd(p, q);
        if (values[0] == 1) {
            return values[2] >= 0 ? values[2] : p + values[2];
        }
        return 0;
    }

    public static void main(String[] args) {
        int p = 18;
        int q = 17;
        int vals[] = gcd(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + vals[0]);
        System.out.println(vals[1] + "(" + p + ") + " + vals[2] + "(" + q + ") = " + vals[0]);
        System.out.println(inverse(p, q));
    }
}
