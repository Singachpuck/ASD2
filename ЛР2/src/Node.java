public class Node<T> {
    private T value;
    Node<T> left = null;
    Node<T> right = null;
    Node<T> parent = null;
    boolean processed = false;

    Node(T value)
    {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
