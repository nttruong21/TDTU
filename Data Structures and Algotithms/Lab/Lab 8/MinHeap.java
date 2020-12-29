import java.util.NoSuchElementException;

public class MinHeap {
    int[] heap;
    int heapSize;
    int maxSize;

    public MinHeap(int capity) {
        this.heapSize = 0;
        this.maxSize = capity + 1;
        this.heap = new int[this.maxSize];
        this.heap[0] = -1;
    }

    // Get parent
    private int parent(int i) {
        return i/2;
    }
    public int getParent(int i) {
        return parent(i);
    }

    // Get left children 
    private int left(int i) {
        return 2*i;
    }
    public int getLeft(int i) {
        return left(i);
    }

    // Get right children
    private int right(int i) {
        return 2*i + 1;
    }
    public int getRight(int i) {
        return right(i);
    }

    // Swap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void doSwap(int i, int j) {
        swap(i, j);
    }

    // Insert
    public void insert(int key) throws NoSuchElementException {
        if(heapSize == maxSize) {
            throw new NoSuchElementException("Overflow Exception");
        }
        else {
            heapSize ++;
            heap[heapSize] = key;
            shiftUp(heapSize);
        }
    }

    // Shift up
    public void shiftUp(int i) {
        while(i > 1 && heap[parent(i)] > heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    // Extract Max
    public int extractMin(int i) throws NoSuchElementException {
        if(heapSize == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        else {
            int min = heap[1];
            heap[1] = heap[heapSize];
            heapSize --;
            shiftDown(1);
            return min;
        }
    }

    // Shift Down
    public void shiftDown(int i) {
        int min, min_id;
        while(i <= heapSize) {
            min = heap[i];
            min_id = i;
            if(left(i) <= heapSize && min > heap[left(i)]) {
                min = heap[left(i)];
                min_id = left(i);
            }
            if(right(i) <= heapSize && min > heap[right(i)]) {
                min = heap[right(i)];
                min_id = right(i);
            }
            if(min_id != i) {
                swap(i, min_id);
                i = min_id;
            }
            else {
                break;
            }
        }
    }

}