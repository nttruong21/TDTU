public class TestHeap {
    // Heap Sort ascending
    public static void heapSort(int[] arr) {
        MaxHeap newHeap = new MaxHeap(arr.length);
        int temp[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            newHeap.insert(arr[i]);
        }
        for(int j = arr.length-1; j >= 0; j--) {
            temp[j] = newHeap.extractMax(1);
        }
        System.out.print("Heap sort ascending: ");
        for(int i = 0; i < temp.length; i++) {
            System.out.print(" " + temp[i]);
        }
        System.out.println();
    }

    // Heap Sort descending
    public static void heapSort_Descending(int[] arr) {
        MinHeap newHeap = new MinHeap(arr.length);
        int temp[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            newHeap.insert(arr[i]);
        }
        for(int i = arr.length-1; i >= 0; i--) {
            temp[i] = newHeap.extractMin(1);
        }
        System.out.print("Heap sort descending: ");
        for(int i = 0; i < temp.length; i++) {
            System.out.print(" " + temp[i]);
        }
        System.out.println();
    }

    public static MaxHeap createMaxHeap(int[] arr) {
        MaxHeap newHeap = new MaxHeap(arr.length);
        for(int i = 0; i < arr.length; i++) {
            newHeap.insert(arr[i]);
        }
        return newHeap;
    }

    public static MinHeap createMinHeap(int[] arr) {
        MinHeap newHeap = new MinHeap(arr.length);
        for(int i = 0; i < arr.length; i++) {
            newHeap.insert(arr[i]);
        }
        return newHeap;
    }

    public static void printHeap(MaxHeap newHeap) {
        for(int i = 1; i < newHeap.heap.length; i++) {
            System.out.print(" " + newHeap.heap[i]);
        }
        System.out.println();
    }

    public static void printHeap(MinHeap newHeap) {
        for(int i = 1; i < newHeap.heap.length; i++) {
            System.out.print(" " + newHeap.heap[i]);
        }
        System.out.println();
    }
    // Main
    public static void main(String[] args) {
        int[] arr = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
        MaxHeap newHeap1 = createMaxHeap(arr);
        System.out.print("Max heap: ");
        printHeap(newHeap1);
        heapSort(arr);
        MinHeap newHeap2 = createMinHeap(arr);
        System.out.print("Min heap: ");
        printHeap(newHeap2);
        heapSort_Descending(arr);
    }
}