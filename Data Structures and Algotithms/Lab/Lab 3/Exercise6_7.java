public class Exercise6_7 {
	
	//Find min element
	
	public static int getMin_Iter(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int getMin_Rec(int[] arr, int length) {
		if(length == 1) {
			return arr[0];
		}
		int temp;
		if(arr[length - 1] < arr[length - 2]) {
			temp = arr[length - 1];
			arr[length - 1] = arr[length - 2];
			arr[length - 2] = temp;
		}
		return getMin_Rec(arr, length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, -10, 21};
		System.out.println("6a/ Min element in the array using iteraction: " + getMin_Iter(arr));
		System.out.println("7a/ Min element in the array using recursion: " + getMin_Rec(arr, arr.length));
	}
}