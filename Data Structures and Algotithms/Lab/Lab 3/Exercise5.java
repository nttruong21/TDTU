public class Exercise5 {
	
	public static int convertDecToBin(int num) {
		if(num == 1) {
			return 1;
		}
		if(num % 2 == 0) {
			return 10 * convertDecToBin(num / 2);
		}
		return 10 * convertDecToBin(num / 2) + 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Convert Decimal to Binary: 21 -> " + convertDecToBin(21));
	}
}