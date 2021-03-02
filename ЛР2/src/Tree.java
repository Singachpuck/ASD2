public class Tree<T extends Integer> {
    private Node<T> root = new Node<>(null);
    private int size = 0;

    void add(T value)
    {

        size++;
    }

    void remove(T value)
    {

        size--;
    }

    boolean contains(Object o)
    {

        return true;
    }

    int sum()
    {

        return 0;
    }

    public int getSize() {
        return size;
    }
}
