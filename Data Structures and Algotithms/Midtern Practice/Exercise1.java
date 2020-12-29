

public class Exercise1 {
    public double prod_recur(int a, int b) {
        if(b == 0)
            return 0;
        if(b < 0)
            return (-1)*a + prod_recur(a, b+1);
        return a + prod_recur(a, b-1);
    }

    public int bin2dec(int n, int exp) {
        if(n == 0)
            return 0;
        return (int) ((n%10) * Math.pow(2, exp)) + bin2dec(n/10, exp+1);
    }

    public int maxDigit(int n) {
        if(n < 10) 
            return n;
        return Math.max(n%10, maxDigit(n/10));
    }

    public int maxElement(int a[], int n) {
        if(n == 1)
            return a[0];
        return Math.max(a[n-1], maxElement(a, n-1));
    }

    public int search(int a[], int n, int key) {
        if(n == 0)
            return -1;
        if(a[n-1] == key) 
            return n-1;
        return search(a, n-1, key);
    }
}