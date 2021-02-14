import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class CircledList<T> implements List<T> {
    private Node first;
    private Node last;
    private int size;

    CircledList() {
    }

    CircledList(T... values) {
        addAll(values);
    }

    CircledList(Collection<? extends T> list) {
        addAll(list);
    }

    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(T value) {
        addLast(value);
        return true;
    }

    @SuppressWarnings("unchecked")
    private CircledList<T> superClone() {
        try {
            return (CircledList<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    protected CircledList<T> clone() {
        CircledList<T> clone = superClone();
        clone.clear();
        Node node = this.first;
        for (int index = 0; index < this.size; index++) {
            clone.add(node.value);
            node = node.next;
        }
        return clone;
    }

    @Override
    public void addFirst(T value) {
        if (value != null) {
            if (this.first == null) {
                this.first = new Node(value);
                this.first.prev = this.first.next = this.first;
                this.last = this.first;
            } else {
                Node node = new Node(this.first, this.last, value);
                this.last.next = this.first.prev = node;
                this.first = node;
            }
            this.size++;
        }
    }

    @Override
    public void addLast(T value) {
        if (value != null) {
            if (this.first == null) {
                addFirst(value);
            } else {
                Node node = new Node(this.first, this.last, value);
                this.first.prev = this.last.next = node;
                this.last = node;
                this.size++;
            }
        }
    }


    public boolean addAll(Collection<? extends T> list) {
        boolean result;
        if (result = list != null && !list.isEmpty()) {
            for (T value : list) {
                result = result && add(value);
            }
        }
        return result;
    }

    public boolean addAll(T... values) {
        boolean result;
        if (result = values != null) {
            for (T value : values) {
                result = result && add(value);
            }
        }
        return result;
    }

    @SafeVarargs
    public static <T> CircledList<T> of(T... values) {
        return new CircledList<T>(values);
    }

    @Override
    public void add(int index, T value) {
        if (value != null) {
            if (index != 0) {
                checkIndex(index);
            }
            Node node = getNodeByIndex(index);
            if (node == null || node == this.first) {
                addFirst(value);
            } else if (node == this.last) {
                addLast(value);
            } else {
                Node addNode = new Node(node, node.prev, value);
                node.prev = node.prev.next = addNode;
                this.size++;
            }
        }
    }

    @Override
    public int indexOf(T value) {
        int index = -1;
        if (value != null && !isEmpty()) {
            if (this.first.value.equals(value)) {
                index = 0;
            } else {
                int count = 1;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if (node.value.equals(value)) {
                        index = count;
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        if (index == -1) {
            throw new NoSuchElementException("Element not found...");
        }
        return index;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Incorrect index output...");
        }
    }

    private Node getNodeByIndex(int index) {
        Node result = null;
        if (index == 0) {
            result = this.first;
        } else if (index == this.size - 1) {
            result = this.last;
        } else {
            if (this.size / 2 > index) {
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if (--index == 0) {
                        result = node;
                        break;
                    }
                }
            } else {
                index = this.size - index - 1;
                for (Node node = this.last.prev; node != this.last; node = node.prev) {
                    if (--index == 0) {
                        result = node;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int lastIndexOf(T value) {
        int index = -1;
        if (!isEmpty()) {
            if (this.last.value.equals(value)) {
                index = this.size - 1;
            } else {
                int count = this.size - 2;
                for (Node node = this.last.prev; node != this.last; node = node.prev) {
                    if (node.value.equals(value)) {
                        index = count;
                        break;
                    } else {
                        count--;
                    }
                }
            }
        }
        if (index == -1) {
            throw new NoSuchElementException("Element not found...");
        }
        return index;
    }

    public T get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).value;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found...");
        }
        if (this.size == 1) {
            clear();
        } else {
            Node newFirst = this.first.next;
            newFirst.prev = this.last;
            this.last.next = newFirst;
            this.first = newFirst;
            this.size--;
        }
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found...");
        }
        if (this.size == 1) {
            clear();
        } else {
            Node newLast = this.last.prev;
            newLast.next = this.first;
            this.first.prev = newLast;
            this.last = newLast;
            this.size--;
        }
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            removeFirst();
        } else if (index == this.size - 1) {
            removeLast();
        } else {
            Node node = getNodeByIndex(index);
            if (node != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                this.size--;
            }
        }

    }

    @Override
    public void replace(int index, T value) {
        if (value != null) {
            checkIndex(index);
            Node set = getNodeByIndex(index);
            set.value = value;
        }
    }

    @Override
    public void replaceFirst(T value) {
        if (value != null) {
            checkIndex(0);
            Node set = getNodeByIndex(0);
            set.value = value;
        }
    }

    @Override
    public void replaceLast(T value) {
        if (value != null) {
            checkIndex(size - 1);
            Node set = getNodeByIndex(size - 1);
            set.value = value;
        }
    }

    public T getFirst() {
        if (this.first == null) {
            throw new NoSuchElementException("Element not found...");
        }
        return this.first.value;
    }

    public T getLast() {
        if (this.last == null) {
            throw new NoSuchElementException("Element not found...");
        }
        return this.last.value;
    }


    @Override
    public double sum(){
        if (isEmpty()) {
            throw new NoSuchElementException("Elements not found...");
        }

        double result = 0;
        int index = 0;
        Node node = this.first;

        while (index < size){
            if (node.value instanceof Number){
                double v = ((Number)node.value).doubleValue();
                result += v;
            }
            else{
                throw new NumberFormatException("Value is not Integer...");
            }
            index++;
            node = node.next;
        }
        return result;
    }

    @Override
    public int getSize(){
        return this.size;
    }


    private class Node {
        private Node next;
        private Node prev;
        private T value;

        Node(Node next, Node prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node(T value) {
            this(null, null, value);
        }

    }
}

