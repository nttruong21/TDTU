package Recursion;

/**
 * @author Nguyen The Truong
 */

public class Exercise1 {

    // Exercise a
    public static double prod_recur(int a, int b) {
        if(b == 0)
            return 0;
        if(b > 0) 
            return a + prod_recur(a, b-1);
        return -1 * a + prod_recur(a, b+1);
    }

    // Exercise b
    public static int bin2dec(int n, int exp) {
        if(n == 0) 
            return 0;
        else {
            int temp;
            if(n % 2 == 0)
                temp = 0;
            else {
                temp = (int) (Math.pow(2, exp));
            }   
            exp++;
            return (temp + bin2dec(n / 10, exp));
        }
    }

    // Exercise c
    public static int maxDigit(int n) {
        if(n == 0) 
            return 0;
        return Math.max(n%10, maxDigit(n/10));
    }

    // Exercise d
    public static int maxElement(int[] a, int n) {
        if(n == 0) 
            return a[0];
        return Math.max(a[n], maxElement(a, n-1));
            
    }

    // Exercise e
    public static int search(int[] a, int n, int key) {
        if(n < 0) 
            return -1;
        if(a[n] == key) 
            return n;
        return search(a, n-1, key);
    }
    
    // Main
    public static void main(String[] args) {
        // Test exercise a
        System.out.println("Exercise a: " + prod_recur(3, -10));

        // Test exercise b
        System.out.println("Exercise b: " + bin2dec(10101, 0));

        // Test exercise c
        System.out.println("Exercise c: " + maxDigit(1621));

        // Test exercise d
        int[] a = {-4, 10, 21, 1, 9};
        System.out.println("Exercise d: " + maxElement(a, a.length-1));

        // Test exercise e
        System.out.println("Exercise e: " + search(a, a.length-1, 21));
    }
}