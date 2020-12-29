public class TestStudent {
	
	// Insertion sort
	public static void selectionSort(Student[] arr, StudentComparator sc) {
		int min_index;
		Student temp;
		for(int i = 0; i < arr.length - 1; i++) {
			min_index = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(sc.compare(arr[j], arr[min_index]) < 0) {
					min_index = j;
				}
			}
			temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}
	
	// Bubble sort 
	public static void bubbleSort(Student[] arr, StudentComparator sc) {
		Student temp;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = arr.length - 1; j > i; j--) {
				if(sc.compare(arr[j], arr[j-1]) < 0) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	// Insertion sort
	public static void insertionSort(Student[] arr, StudentComparator sc) {
		int j;
		Student temp;
		for(int i = 1; i < arr.length; i++) {
			temp = arr[i];
			for(j = i - 1; j >= 0 && sc.compare(arr[j], temp) > 0; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}

	// Merge sort 
	public static void merge(Student[] arr, int l, int m, int r, StudentComparator sc) {
		int n1 = m - l + 1;
		int n2 = r - m;
		Student[] L = new Student[n1];
		Student[] R = new Student[n2];
		for(int i = 0; i < n1; i++) {
			L[i] = arr[i];
		}
		for(int i = 0; i < n2; i++) {
			R[i] = arr[i+m+1];
		}
		int i = 0, j = 0, k = l;
		while(i < n1 && j < n2) {
			if(sc.compare(L[i], R[j]) <= 0) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(Student[] arr, int l, int r) {
		int m;
		if(l < r) {
			m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r, new StudentComparator());
		}
	}

	// Quick sort
	public static int partition(Student[] arr, int low, int high, StudentComparator sc) {
		Student temp;
		Student pivot = arr[low];
		int i = high + 1;
		for(int j = high; j > low; j--) {
			if(sc.compare(arr[j], pivot) >= 0) {
				i--;
				// swap arr[i] & arr[j]
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// swap arr[i-1] & arr[low]
		temp = arr[i-1];
		arr[i-1] = arr[low];
		arr[low] = temp;
		return i-1;
	}

	public static void quickSort(Student[] arr, int low, int high) {
		int pi;
		if(low < high) {
			pi = partition(arr, low, high, new StudentComparator());
			quickSort(arr, pi+1, high);
			quickSort(arr, low, pi-1);
		}
	}

	// Print array
	public static void printArr(Student[] arr) {
		System.out.println("----- Student Array ------\n");
		for(int i = 0; i < arr.length; i++) {
			System.out.println("--- Student " + (i+1) + " ---\n" + arr[i] + "\n");
		}
	}

	// Main
	public static void main(String[] args) {
		Student[] arr = new Student[3];
		arr[0] = new Student("Truong", 8, 7, 9);
		arr[1] = new Student("Nhan", 4, 7, 3);
		arr[2] = new Student("Quan", 10, 4, 9);
		printArr(arr);
		
		/*
		selectionSort(arr, new StudentComparator());
		printArr(arr);
		*/
		
		
		/*
		bubbleSort(arr, new StudentComparator());
		printArr(arr);
		*/
		
		/*
		insertionSort(arr, new StudentComparator());
		printArr(arr);
		*/

		/*
		mergeSort(arr, 0, arr.length-1);
		printArr(arr);
		*/

		quickSort(arr, 0, arr.length-1);
		printArr(arr);
	}
}