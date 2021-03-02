public class DoublyLinkedList<T> implements List<T>{
    private Node<T> first = new Node<>(null);
    private Node<T> last = first;
    private int size = 0;

    @Override
    public void addFirst(T e)
    {
        if (size == 0)
        {
            first.setValue(e);
        }
        else
        {
            Node<T> newFirst = new Node<>(e);

            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }

        size++;
    }

    @Override
    public void addLast(T e)
    {
        if (size == 0)
        {
            first.setValue(e);
        }
        else
        {
            Node<T> newLast = new Node<>(e);

            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        }

        size++;
    }

    @Override
    public void add(int index, T e)
    {
        if (index == 0)
        {
            addFirst(e);
        }
        else
        {
            Node<T> newNode = new Node<>(e);

            Node<T> n = getByIndex(index);

            newNode.next = n;
            newNode.prev = n.prev;
            n.prev.next = newNode;
            n.prev = newNode;

            size++;
        }
    }

    @Override
    public void removeFirst()
    {
        if (size == 0) return;

        if (size == 1)
        {
            first.setValue(null);
        }
        else
        {
            first = first.next;
            first.prev = null;
        }

        size--;
    }

    @Override
    public void removeLast()
    {
        if (size == 0) return;

        if (size == 1)
        {
            first.setValue(null);
        }
        else
        {
            last = last.prev;
            last.next = null;
        }

        size--;
    }

    @Override
    public void remove(int index)
    {
        if (size == 0) return;

        if (index == 0)
        {
            removeFirst();
        }
        else if (index == size - 1)
        {
            removeLast();
        }
        else
        {
            Node<T> n = getByIndex(index - 1);

            n.next = n.next.next;
            n.next.prev = n;

            size--;
        }
    }

    @Override
    public void replaceFirst(T e)
    {
        if (size == 0) throw new IndexOutOfBoundsException();

        first.setValue(e);
    }

    @Override
    public void replaceLast(T e)
    {
        if (size == 0) throw  new IndexOutOfBoundsException();

        last.setValue(e);
    }

    @Override
    public void replace(int index, T e)
    {
        Node<T> n = getByIndex(index);

        n.setValue(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public double sum()
    {
        if(size == 0) throw new IllegalStateException("Empty list");

        double sum = 0;

        Node<T> node = first;

        while(node !=null)
        {
            boolean isNumber = (node.getValue() instanceof Number);
            if(!isNumber) throw new IllegalStateException("Not a number list");
            double value = ((Number) node.getValue()).doubleValue();
            sum += value;
            node = node.next;
        }
        return sum;
    }

    @Override
    public int indexOf(T e) {
        if (size == 1)
            if (e.equals(first.getValue()))
                return 0;
            else
                throw new IllegalArgumentException();

        int i = 0;
        Node<T> change = first;

        while (change.next != null)
        {
            if (e.equals(change.getValue()))
            {
                return i;
            }

            change = change.next;
            i++;
        }

        throw new IllegalArgumentException();
    }

    private Node<T> getByIndex(int index)
    {
        if (size == 0 || index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node<T> change;

        if (size / 2 <= index)
        {
            change = last;
            for (int i = 0; i < size - index - 1; i++)
            {
                change = change.prev;
            }
        }
        else
        {
            change = first;
            for (int i = 0; i < index; i++)
            {
                change = change.next;
            }
        }

        return change;
    }


    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("{ ");
        Node<T> node = this.first;
        while(node != null)
        {
            str.append(node.getValue().toString()).append(" ");
            node = node.next;
        }
        str.append("}");
        return str.toString();
    }
}
