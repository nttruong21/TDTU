package Recursion;

/**
 * @author Nguyen The Truong
 */
public class Exercise3 {
    
    // Exercise a

    // Using Recursion
    public static double exerA_Rec(int n) {
        if(n == 0) 
            return 2;
        return 2 - exerA_Rec(n-1)/2;
    }

    // Using Iteration
    public static double exerA_Iter(int n) {
        double temp = 2.0;
        for(int i = 1; i <= n; i++)
            temp = 2 - temp/2;
        return temp;
    }

    // Exercise b

    // Using Recurtion
    public static int exerB_Rec(int n) {
        if(n < 10)
            return 1;
        return 1 + exerB_Rec(n/10);
    }

    // Using Iteration
    public static int exerB_Iter(int n) {
        int temp = 1;
        for(int i = 10; i <= n; i *= 10) 
            temp ++;
        return temp;
    }

    // Exercise b

    // Using Recurtion
    public static int exerC_Rec(int n, int k) {
        if(k == 1)
            return n;
        return n + exerC_Rec(n, k-1);
    }

    // Using Iteration
    public static int exerC_Iter(int n, int k) {
        int temp = n;
        for(int i = 2; i <= k; i++)
            temp += n;
        return temp;
    }

    // Exercise d

    // Using Recursion
    public static int exerD_Rec(int n) {
        if(n == 0) 
            return 0;
        if(n == 1)
            return 1;
        return exerD_Rec(n-1) + exerD_Rec(n-2);
    }

    // Using Iteration
    public static int exerD_Iter(int n) {
        int temp0 = 0;
        int temp1 = 1;
        int tmp;
        for(int i = 2; i <= n; i++) {
            tmp = temp1;
            temp1 += temp0;
            temp0 = tmp;
        }
           return temp1; 
    }

    public static void main(String[] args) {

        // Test exercise a
        System.out.println("Recurtion: " + exerA_Rec(21));
        System.out.println("Iteration: " + exerA_Iter(21));

        // Test exercise b
        System.out.println("Recursion: " + exerB_Rec(1621));
        System.out.println("Iteraction: " + exerB_Iter(1621));

        // Test exercise c
        System.out.println("Recursion: " + exerC_Rec(21, 3));
        System.out.println("Iteration: " + exerC_Iter(21, 3));

        // Test exercise d
        System.out.println("Recursion: " + exerD_Rec(21));
        System.out.println("Iteration: " + exerD_Iter(21));
    }
}
