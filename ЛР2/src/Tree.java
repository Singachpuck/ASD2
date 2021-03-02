import java.util.Iterator;

public class Tree<T extends Integer> implements Iterable<T> {
    private Node<T> root = new Node<>(null);
    private int size = 0;

    void add(T value)
    {
        if (size == 0)
        {
            root.setValue(value);
        }
        else
        {
            Node<T> current = root;
            Node<T> newNode = new Node<>(value);

            while (true)
            {
                Integer nodeValue = current.getValue();

                if ((Integer) value < nodeValue)
                {
                    if (current.left == null)
                    {
                        current.left = newNode;
                        newNode.parent = current;
                        break;
                    }
                    else
                        current = current.left;
                }
                else if ((Integer) value > nodeValue)
                {
                    if (current.right == null)
                    {
                        current.right = newNode;
                        newNode.parent = current;
                        break;
                    }
                    else
                        current = current.right;
                }
                else
                {
                    return;
                }
            }
        }

        size++;
    }

    void remove(T value)
    {
        if (size == 0) throw new IndexOutOfBoundsException("Can't remove from an empty tree");

        if (size == 1)
        {
            if (value.equals(root.getValue())) root.setValue(null);
            else return;
        }
        else
        {
            Node<T> current = root;

            while (true)
            {
                Integer nodeValue = current.getValue();

                if (value.equals(nodeValue))
                {
                    if (current.parent == null)
                    {
                        Node<T> addRightTo;

                        if (current.left != null)
                        {
                            addRightTo = current.left;

                            while (addRightTo.right != null)
                            {
                                addRightTo = addRightTo.right;
                            }

                            addRightTo.right = current.right;
                            if (current.right != null) current.right.parent = addRightTo;
                            current.left.parent = null;
                            root = current.left;
                        }
                        else
                        {
                            if (current.right != null)
                            {
                                current.right.parent = null;
                                root = current.right;
                            }
                            else root.setValue(null);
                        }

                        break;
                    }

                    if ((Integer) current.parent.getValue() < nodeValue)
                    {
                        Node<T> addLeftTo;

                        if (current.right != null)
                        {
                            addLeftTo = current.right;

                            while (addLeftTo.left != null)
                            {
                                addLeftTo = addLeftTo.left;
                            }

                            addLeftTo.left = current.left;
                            if (current.left != null) current.left.parent = addLeftTo;
                            current.parent.right = current.right;
                            current.right.parent = current.parent;
                        }
                        else
                        {
                            current.parent.right = current.left;

                            if (current.left != null) current.left.parent = current.parent;
                        }
                    }
                    else
                    {
                        Node<T> addRightTo;

                        if (current.left != null)
                        {
                            addRightTo = current.left;

                            while (addRightTo.right != null)
                            {
                                addRightTo = addRightTo.right;
                            }

                            addRightTo.right = current.right;
                            if (current.right != null) current.right.parent = addRightTo;
                            current.parent.left = current.left;
                            current.left.parent = current.parent;
                        }
                        else
                        {
                            current.parent.left = current.right;

                            if (current.right != null) current.right.parent = current.parent;
                        }
                    }

                    break;
                }
                else if ((Integer) value < nodeValue)
                {
                    if (current.left == null)
                        return;
                    else
                        current = current.left;
                }
                else if ((Integer) value > nodeValue)
                {
                    if (current.right == null)
                        return;
                    else
                        current = current.right;
                }
            }
        }

        size--;
    }

    boolean contains(Object o)
    {
        if (size == 0 || !(o instanceof Integer)) return false;

        Node<T> current = root;

        while (true)
        {
            Integer iValue = current.getValue();

            if (iValue.equals(o))
                return true;
            else if (iValue < (Integer) o)
            {
                if (current.right == null)
                    break;
                else
                    current = current.right;
            }
            else if (iValue > (Integer) o)
            {
                if (current.left == null)
                    break;
                else
                    current = current.left;
            }
        }

        return false;
    }

    long sum()
    {
        return getSum(root);
    }

    private long getSum(Node<T> currentNode)
    {
        if (currentNode == null) return 0;

        return getSum(currentNode.left) + (Integer) currentNode.getValue() + getSum(currentNode.right);
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = root;
            private int processed = 0;

            private boolean hn;

            {
                hn = size != 0;
            }

            @Override
            public boolean hasNext() {
                return hn;
            }

            @Override
            public T next() {
                return getItem().getValue();
            }

            public Node<T> getItem()
            {
                if (current.left != null && !current.left.processed)
                {
                    current = current.left;

                    return getItem();
                }
                else
                {
                    Node<T> toReturn = current;

                    if (current.right != null && !current.right.processed)
                    {
                        current = current.right;
                    }
                    else if (current.parent != null)
                    {
                        if (current.left != null) current.left.processed = false;
                        if (current.right != null) current.right.processed = false;
                        current = current.parent;

                        if (toReturn.processed)
                        {
                            return getItem();
                        }
                    }
                    else
                    {
                        if (current.left != null) current.left.processed = false;
                        if (current.right != null) current.right.processed = false;

                        current.processed = false;
                    }


                    toReturn.processed = true;

                    if (++processed == size)
                    {
                        do
                        {
                            if (current.left != null) current.left.processed = false;
                            if (current.right != null) current.right.processed = false;
                            current = current.parent;
                        } while (current != null);

                        root.processed = false;

                        hn = false;
                    }

                    return toReturn;
                }
            }
        };
    }

    public String toString()
    {
        if (size == 0) return "[]";

        StringBuilder saso = new StringBuilder("[ ");

        for (Integer i : this)
        {
            saso.append(i).append(", ");
        }

        saso.replace(saso.length() - 2, saso.length(), " ]");
        return saso.toString();
    }
}
