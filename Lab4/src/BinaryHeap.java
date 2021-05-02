import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinaryHeap<T extends Comparable<T>> {
    //arraylist is much better than an array. There is no need to carry about a capacity.
    private ArrayList<T> items;
    private ArrayList<T> copyHeap;
    private int heapSize = 0;
    private int copySize = 0;

    //construct
    public BinaryHeap() {
        items = new ArrayList<T>();
    }

    //using shiftUp for insert.
    private void shiftUp () {
        int k = items.size() - 1;
        while (k > 0){
            int curr = (k-1)/2;
            T Item = items.get(k);
            T Parent = items.get(curr);
            if (Item.compareTo(Parent) > 0){
                items.set(k, Parent);
                items.set(curr, Item);
                k = curr;
            }
            else break;
        }
    }

    //using shiftDown fo delete
    private void shiftDown() {
        int curr = 0;
        int leftChild = 2*curr+1;
        while (leftChild < items.size()) {
            int max = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < items.size()) {
                if (items.get(rightChild).compareTo(items.get(1)) > 0) {
                    ++max;
                }
            }
            if (items.get(curr).compareTo(items.get(max)) < 0) {
                T tmp = items.get(curr);
                items.set(curr, items.get(max));
                items.set(max, tmp);
                curr = max;
                leftChild = 2*curr+1;
            }
            else break;
        }
    }

    public void insert(T item) {
        items.add(item);
        heapSize++;
        shiftUp();
    }

    public int findIndexByValue(T item) {
        if (isEmpty() ) {
            return -1;
        }
        for (int i = 0; i < heapSize; i++) {
            if (item == items.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public int findPosition(T item){
        int ind = findIndexByValue(item);
        if (ind == -1){
            throw new NoSuchElementException("There is no such element in heap!");
        }
        return ind;
    }

    public void delete(T item) throws NoSuchElementException {
        int ind = findIndexByValue(item);
        if (isEmpty() ) {
            throw new NoSuchElementException("Heap is empty!");
        }
        if (ind != -1) {
            items.set(ind, items.get(heapSize - 1));
            heapSize--;
            items.remove(heapSize);
            shiftDown();
        }
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String toString() {
        return items.toString();
    }

    public void print() {
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).toString() + " ");
        }
        System.out.println();
    }

    void outHeap() {
        int i = 0;
        int k = 1;
        while(i < heapSize) {
            while((i < k) && (i < heapSize)) {
                System.out.print(items.get(i) + " ");
                i++;
            }
            System.out.println();
            k = k * 2 + 1;
        }
    }

    void heapify(int i) {
        int left, right;
        T temp;
        left = 2*i+1;
        right = 2*i+2;
        if(left < copySize) {
            if( copyHeap.get(i).compareTo(copyHeap.get(left)) < 0){
                temp = copyHeap.get(i);
                copyHeap.set(i, copyHeap.get(left));
                copyHeap.set(left, temp);
                heapify(left);
            }
        }
        if(right < copySize) {
            if(copyHeap.get(i).compareTo(copyHeap.get(right)) < 0) {
                temp = copyHeap.get(i);
                copyHeap.set(i, copyHeap.get(right));
                copyHeap.set(right, temp);
                heapify(right);
            }
        }
    }

    public T getmax() {
        T x;
        x = copyHeap.get(0);
        copyHeap.set(0, copyHeap.get(copySize - 1));
        copySize--;
        copyHeap.remove(copySize);
        heapify(0);
        return(x);
    }

    void sort(){
        copyHeap = (ArrayList<T>) items.clone();
        copySize = heapSize;
        for (int i = 0;i<heapSize;i++){
            System.out.print(getmax() + " ");
        }
        System.out.println();
    }
}
