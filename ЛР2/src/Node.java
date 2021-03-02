public class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;
    Node<T> parent;

    Node(T value)
    {
        this.value = value;
    }
}
