public class Sorting {
    
    public static void selectionSort(int[] arr) {
        int min, temp;
        for(int i = 0; i < arr.length-1; i++) {
            min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min])
                    min = j;
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            print(arr);
        }
    }

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

    public static void insertionSort(int[] arr) {
        int j, temp;
        for(int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for(j = i-1; j >=0 && arr[j] > temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
            print(arr);
        }
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            System.out.print(" " + arr[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 6, 4, 3};
        insertionSort(arr);
    }
}
