public class Exercise1_2_3 {
	// Compute factorial
	
	public static double fac_Iter(int num) {
		double fac = 1;
		for(int i = 2; i <= num; i++) {
			fac *= i;
		}
		return fac;
	}
	
	public static double fac_Rec(int num) {
		if(num == 0 || num == 1) {
			return 1;
		}
		return num * fac_Rec(num - 1);
	}
	
	// Compute x^n
	
	public static double com_Pow_Iter(int x, int n) {
		if(n == 0) {
			return 1;
		}
		else {
			double result = 1;
			for(int i = 1; i <= n; i++) {
				result *= x;
			}
			return result;
		}
	} 
	
	public static double com_Pow_Rec(int x, int n) {
		if(n == 0) {
			return 1;
		}
		return x * com_Pow_Rec(x, n - 1);
	}
	
	// Count number of digits
	
	public static int count_Digits_Iter(int num) {
		if(num == 0) {
			return 0;
		}
		return 1 + count_Digits_Iter(num / 10);
	}
	
	public static int count_Digits_Rec(int num) {
		int count = 0;
		while(num != 0) {
			num = num / 10;
			count ++;
		}
		return count;
	}
	
	// Find Greatest Common Divisor
	
	public static int findGCD_Iter(int a, int b) {
		int temp;
		while(b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static int findGCD_Rec(int a, int b) {
		if(b == 0) {
			return a;
		}
		return findGCD_Rec(b, a%b);
	}
	
	// Check prime number
	
	public static boolean checkPrime_Iter(int num) {
		boolean isPrime = true;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static boolean checkPrime_Rec(int n, int d) {
		if(n < 2) {
			return false;
		}
		if(n == 2) {
			return true;
		}
		if(n % d == 0) {
			return false;
		}
		if(d > Math.sqrt(n)) {
			return true;
		}
		return checkPrime_Rec(n, d + 1);
	}
	public static void main(String[] args) {
		System.out.println("1a/ Factorial of 5 using iteraction: " + fac_Iter(5));
		System.out.println("2a/ Factorial of 5 using recursion: " + fac_Rec(5));
		System.out.println("1b/ Using iteraction: 2 ^ 4 = " + com_Pow_Iter(2, 4));
		System.out.println("2b/ Using recursion: 2 ^ 4 = " + com_Pow_Rec(2, 4));
		System.out.println("1c/ Total number of digis of 1621 using iteraction: " + count_Digits_Iter(1621));
		System.out.println("2c/ Total number of digits of 1621 using recursion: " + count_Digits_Rec(1621));
		System.out.println("1d/ Using iteraction: 2 is a prime number? " + checkPrime_Iter(2));
		System.out.println("3/ Using recursion: 2 is a prime number? " + checkPrime_Rec(2, 2));
		System.out.println("1e/ GCD of 16 and 40 using iteraction: " + findGCD_Iter(16, 40));
		System.out.println("2e/ GCD of 16 and 40 using recursion: " + findGCD_Rec(16, 40));
		
	}
}