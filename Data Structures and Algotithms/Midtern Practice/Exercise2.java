

public class Exercise2 {
    public double exA_Rec(int n) {
        if(n == 1)
            return 2;
        return Math.pow(2, n) + exA_Rec(n-1);
    }
    
    public double exA_Ite(int n) {
        double result = 0.0;
        for(int i = 1; i <= n; i++) 
            result += Math.pow(2, i);
        return result;
    }

    public double exB_Rec(int n) {
        if(n == 0)
            return 0.5;
        return (double)(n+1)/2 + exB_Rec(n-1);
    }

    public double exB_Ite(int n) {
        double result = 0.0;
        for(int i = 0; i <= n; i++)
            result += 1.0*(i+1)/2;
        return result;
    }

    public int exC_Rec(int n) {
        if(n == 1)
            return 1;
        return n + exC_Rec(n-1);
    }

    public int exC_Ite(int n) {
        int result = 0;
        for(int i = 1; i <= n; i++)
            result += i;
        return result;
    }

    public int exD_Rec(int n) {
        if(n == 1)
            return 0;
        return n*(n-1) + exD_Rec(n-1);
    }

    public int exD_Ite(int n) {
        int result = 0;
        for(int i = 1; i <= n; i++)
            result += i*(i-1);
        return result; 
    }

    public int exE_Rec(int n) {
        if(n == 1)
            return 1;
        return n * exE_Rec(n-1);
    }

    public int exE_Ite(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++)
            result *= i;
        return result;
    }
    
}
