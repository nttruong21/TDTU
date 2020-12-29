public class Exercise3 {
    public double exA_Rec(int n) {
        if(n == 0)
            return 2;
        return 2 - 1.0*exA_Rec(n-1)/2;
    }

    public double exA_Ite(int n) {
        double result = 2;
        for(int i = 1; i <= n; i++)
            result = 2 - 1.0*result/2;
        return result;
    }

    public double exA_Arr(int n) {
        double a[] = new double[n+1];
        a[0] = 2;
        for(int i = 1; i <= n; i++)
            a[i] = 2 - 1.0*a[i-1]/2;
        return a[n];
    }

    public int exB_Rec(int n) {
        if(n < 10)
            return 1;
        return 1 + exB_Rec(n/10);
    }

    public int exB_Ite(int n) {
        int temp = n;
        int result = 1;
        while(temp >= 10) {
            result ++;
            temp /= 10;
        }
        return result;
    }

    public int exB_Arr(int n) {
        int[] a = new int[5];
        a[0] = 1;
        int i = 0;
        while(n >= 10) {
            i++;
            a[i] = a[i-1] + 1;
            n /= 10;
        }
        return a[i];
    }

    public int exC_Rec(int n, int k) {
        if(k == 1)
            return n;
        return n + exC_Rec(n, k-1);
    }

    public int exC_Ite(int n, int k) {
        int result = n;
        while(k > 1) {
            result += n;
            k--;
        }
        return result;
    }

    public int exC_Arr(int n, int k) {
        int[] a = new int[k];
        a[0] = n;
        for(int i = 1; i < k; i++)
            a[i] = a[i-1] + n;
        return a[k-1];
    }

    public int exD_Rec(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return exD_Rec(n-1) + exD_Rec(n-2);
    }

    public int exD_Ite(int n) {
        int temp1 = 0;
        int temp2 = 1;
        int tmp;
        for(int i = 2; i <= n; i++) {
            tmp = temp2;
            temp2 += temp1;
            temp1 = tmp;
        }
         return temp2;   
    }

    public int exD_Arr(int n) {
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2; i <= n; i++)
            a[i] = a[i-1] + a[i-2];
        return a[n];
    }
}