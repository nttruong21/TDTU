package Recursion;

/**
 * @author Nguyen The Truong
 */
public class Exercise2 {
    
    // Exercise a
    public static double exerciseA(int n) {
        if(n == 1)
            return 2;
        return Math.pow(2, n) + exerciseA(n-1);
    }

    // Exercise b
    public static double exerciseB(int n) {
        if(n == 0)
            return 0.5;
        return (n+1)/2 + exerciseB(n-1);
    }

    // Exercise c
    public static double exerciseC(int n) {
        if(n == 1) 
            return 1;
        double num = 1.0, den = 1.0;
        int i;
        for(i = 2; i < n; i++) {
            num *= i;
            den *= i;
        }
        num *= i;
        return num/den + exerciseC(n-1);
    }

    // Exercise d
    public static int exerciseD(int n) {
        if(n == 1) 
            return 0;
        return n * (n-1) + exerciseD(n-1);
    }

    // Exercise e
    public static int exerciseE(int n) {
        if(n == 1)
            return 1;
        return n * exerciseE(n-1);
    }
    public static void main(String[] args) {
        // Test exercise a
        System.out.println("Exercise a: " + exerciseA(21));

        // Test exercise b
        System.out.println("Exercise b: " + exerciseB(21));

        // Test exercise c
        System.out.println("Exercise c: " + exerciseC(5));

        // Test exercise d
        System.out.println("Exercise d: " + exerciseD(21));

        // Test exercise e
        System.out.println("Exercise e: " + exerciseE(5));
    }
}
