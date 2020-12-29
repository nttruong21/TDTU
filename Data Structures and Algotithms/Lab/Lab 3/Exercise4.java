public class Exercise4 {
	// Exercise a
	public static double exerciseA(int n) {
		if(n == 1) {
			return 3;
		}
		return (2*n+1) + exerciseA(n - 1);
	}
	
	// Exercise b
	public static double exerciseB(int n) {
		if(n == 1) {
			return 1;
		}
		double fac = 1;
		for(int i = 2; i <= n; i++) {
			fac *= i;
		}
		return fac + exerciseB(n - 1);
	}
	
	// Exercise c
	public static double exerciseC(int n) {
		if(n == 1) {
			return 1;
		}
		double fac = 1;
		for(int i = 2; i <= n; i++) {
			fac *= i;
		}
		return fac * exerciseC(n - 1);
	}
	
	// Exercise d
	public static double exerciseD(int n, int k) {
		if(n < k || k <= 0) {
			return 1;
		}
		return n * exerciseD(n-1, k-1);
	}
	
	// Exercise e
	public static double exerciseE(int n) {
		if(n == 1) {
			return 3;
		}
		return Math.pow(2, n) + n*n + exerciseE(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println("a/ n = 5: " + exerciseA(5));
		System.out.println("b/ n = 5: " + exerciseB(5));
		System.out.println("c/ n = 5: " + exerciseC(5));
		System.out.println("d/ C(6,3) = " + exerciseD(6, 3));
		System.out.println("e/ P(5) = " + exerciseE(5));
	}
}