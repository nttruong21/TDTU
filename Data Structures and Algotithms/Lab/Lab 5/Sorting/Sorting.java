package Sorting;

/**
 *
 * @author Nguyen The Truong
 */
public class Sorting {

    // Selection sort
    public static void selectionSort(int[] arr) {
        int min_index, temp;
        for(int i = 0; i < arr.length-1; i++) {
            min_index = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
            print(arr);
        }
    }
    
    // Bubble sort
    public static void bubbleSort(int[] arr) {
        int temp;
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            print(arr);
        }
    }
    
    // Insertion sort
    public static void insertionSort(int[] arr) {
        int temp, j;
        for(int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for(j = i-1; j >= 0 && arr[j] > temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
            print(arr);
        }
    }
    
    // Print array
    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++)
           System.out.print(" " + arr[i]);
        System.out.println();
    }
    public static void main(String[] args) {
       
        int[] arr1 = {3, 1, 4, 6, 2, 5};
        System.out.println("\nSelection sort");
        selectionSort(arr1);
        int[] arr2 = {5, 3, 4, 2, 6, 1};
        System.out.println("\nBubble sort");
        bubbleSort(arr2);
        int[] arr3 = {5, 1, 2, 6, 4, 3};
        System.out.println("\nInsertion sort");
        insertionSort(arr3);
             
    }
    
}
