public class DoublyLinkedList<T> implements List<T>{
    private Node<T> current = new Node<>(null);
    private int current_index = -1;
    private Node<T> first = current;
    private Node<T> last = current;
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
        current_index++;
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
        if (size == 0 || index >= size || index < 0) throw new IndexOutOfBoundsException();

        if (index == 0)
        {
            addFirst(e);
        }
        else
        {
            final int f = index;
            final int l = size - index - 1;
            final int m = current_index - index;

            int min_len = Math.min(Math.min(f, l), Math.abs(m));

            Node<T> change;
            Node<T> newNode = new Node<>(e);

            if (min_len == f)
            {
                change = first;

                for (int i = 0; i < f - 1; i++)
                {
                    change = change.next;
                }

                newNode.next = change.next;
                change.next = newNode;
                newNode.prev = change;
            }
            else if (min_len == l)
            {
                change = last;

                for (int i = 0; i < l; i++)
                {
                    change = change.prev;
                }

                change.prev.next = newNode;
                newNode.prev = change.prev;
                newNode.next = change;
            }
            else if (m < 0)
            {
                change = current;

                for (int i = 0; i < min_len - 1; i++)
                {
                    change = change.next;
                }

                newNode.next = change.next;
                change.next = newNode;
                newNode.prev = change;
            }
            else
            {
                change = current;

                for (int i = 0; i < min_len; i++)
                {
                    change = change.prev;
                }

                change.prev.next = newNode;
                newNode.prev = change.prev;
                newNode.next = change;
            }

            current = newNode;
            current_index = index;
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
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

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
            final int f = index;
            final int l = size - index - 1;
            final int m = current_index - index;

            int min_len = Math.min(Math.min(f, l), Math.abs(m));

            Node<T> change;

            if (min_len == f)
            {
                change = first;

                for (int i = 0; i < f - 1; i++)
                {
                    change = change.next;
                }

                change.next = change.next.next;
                change.next.prev = change;
                current = change.next;
            }
            else if (min_len == l)
            {
                change = last;

                for (int i = 0; i < l - 1; i++)
                {
                    change = change.prev;
                }

                change.prev = change.prev.prev;
                change.prev.next = change;
                current = change;
            }
            else if (m < 0)
            {
                change = current;

                for (int i = 0; i < min_len - 1; i++)
                {
                    change = change.next;
                }

                change.next = change.next.next;
                change.next.prev = change;
                current = change.next;
            }
            else
            {
                change = current;

                for (int i = 0; i < min_len - 1; i++)
                {
                    change = change.prev;
                }

                change.prev = change.prev.prev;
                change.prev.next = change;
                current = change;
            }

            current_index = index;
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
        if (size == 0 || index >= size || index < 0) throw new IndexOutOfBoundsException();

        final int f = index;
        final int l = size - index - 1;
        final int m = current_index - index;

        int min_len = Math.min(Math.min(f, l), Math.abs(m));

        Node<T> change;

        if (min_len == f)
        {
            change = first;

            for (int i = 0; i < min_len; i++)
            {
                change = change.next;
            }

            change.setValue(e);
        }
        else if (min_len == l)
        {
            change = last;

            for (int i = 0; i < min_len; i++)
            {
                change = change.prev;
            }

            change.setValue(e);
        }
        else if (m < 0)
        {
            change = current;

            for (int i = 0; i < min_len; i++)
            {
                change = change.next;
            }

            change.setValue(e);
        }
        else
        {
            change = current;

            for (int i = 0; i < min_len; i++)
            {
                change = change.prev;
            }

            change.setValue(e);
        }

        current = change;
        current_index = index;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int sum() {
        if (size == 0) throw new NumberFormatException("Size is 0");

        int s = 0;
        Node<T> target = first;

        while ( target != null )
        {
            T v = target.getValue();

            if (!(v instanceof Integer))
            {
                throw new NumberFormatException("Can't add non integer value");
            }

            Integer i = (Integer) v;

            s += i;

            target = target.next;
        }

        return s;
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
