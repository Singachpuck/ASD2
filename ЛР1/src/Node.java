public class Node<T> {
    public Node<T> prev;
    public Node<T> next;
    private T value;

    Node(T value){
        this.value = value;
        prev = null;
        next = null;
    }

    Node(){
        this.value = null;
        prev = null;
        next = null;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}
