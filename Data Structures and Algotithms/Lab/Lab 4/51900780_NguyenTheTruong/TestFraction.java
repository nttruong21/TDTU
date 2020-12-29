public class TestFraction {
	
	// Selection sort
	public static void selectionSort(Fraction[] arr, FractionComparator fc) {
		int min_index;
		Fraction temp;
		for(int i = 0; i < arr.length - 1; i++) {
			min_index = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(fc.compare(arr[j], arr[min_index]) < 0) {
					min_index = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
		}
	}
	
	// Bubble sort 
	public static void bubbleSort(Fraction[] arr, FractionComparator fc) {
		Fraction temp;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = arr.length - 1; j > i; j--) {
				if(fc.compare(arr[j], arr[j-1]) < 0) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	// Insertion sort 
	public static void insertionSort(Fraction[] arr, FractionComparator fc) {
		Fraction temp;
		int j;
		for(int i = 1; i < arr.length; i++) {
			temp = arr[i];
			for(j = i - 1; j >= 0 && fc.compare(arr[j], temp) > 0; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}

	// Merge sort
	public static void merge(Fraction[] arr, int l, int m, int r, FractionComparator fc) {
		int n1 = m - l + 1;
		int n2 = r - m;
		Fraction[] L = new Fraction[n1];
		Fraction[] R = new Fraction[n2];
		for(int i = 0; i < n1; i++) {
			L[i] = arr[l+i];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = arr[m+j+1];
		}
		int i = 0, j = 0, k = l;
		while(i < n1 && j < n2) {
			if(fc.compare(L[i], R[j]) <= 0) {
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
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(Fraction[] arr, int first, int last) {
		int mid;
		if(first < last) {
			mid = (first + last) / 2;
			mergeSort(arr, first, mid);
			mergeSort(arr, mid+1, last);
			merge(arr, first, mid, last, new FractionComparator()); 
		}
	}

	// Quick sort 
	public static int partition(Fraction[] arr, int low, int high, FractionComparator fc) {
		Fraction pivot = arr[low];
		int i = high + 1;
		Fraction temp;
		for(int j = low+1; j < i; j++) {
			if(fc.compare(arr[j], pivot) >= 0) {
				i--;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[i-1];
		arr[i-1] = arr[low];
		arr[low] = temp;
		return i-1;
	}

	public static void quickSort(Fraction[] arr, int low, int high) {
		int pi;
		if(low < high) {
			pi = partition(arr, low, high, new FractionComparator());
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}

	// Print array
	public static void printArr(Fraction[] arr) {
		System.out.print("My fraction list:");
		for(Fraction f: arr) {
			System.out.print("\t" + f);
		}
		System.out.println();
	}

	// Main
	public static void main(String[] args) {
		Fraction[] arr = new Fraction[3];
		arr[0] = new Fraction(1, 2);
		arr[1] = new Fraction(-2, 3);
		arr[2] = new Fraction(5, 9);
		printArr(arr);
		
		/*
		selectionSort(arr, new FractionComparator());
		printArr(arr);
		*/
		
		/*
		bubbleSort(arr, new FractionComparator());
		printArr(arr);
		*/
		
		/*
		insertionSort(arr, new FractionComparator());
		printArr(arr);
		*/

		/*
		mergeSort(arr, 0, arr.length - 1);
		printArr(arr);
		*/

		quickSort(arr, 0, arr.length-1);
		printArr(arr);
	}
}