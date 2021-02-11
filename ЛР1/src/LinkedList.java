public class LinkedList<T> implements List<T>{
    private Node first;
    private Node last;
    private int size = 0;


    private static class Node<T>
    {
        T element;
        Node next;

        public Node(T element)
        {
            this.element = element;
        }
    }

    @Override
    public void addFirst(T element)
    {
        if(first == null) {
            addLast(element);
        }
        else
        {
            Node node = new Node(element);
            node.next = first;
            first = node;
            size++;
        }
    }
    @Override
    public void add(int index, T element)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if(index == 0) {
            addFirst(element);
        }else if(index == this.size)
        {
            addLast(element);
        }else
        {
            Node prevNode = this.first;
            Node node = new Node(element);
            Node nextNode = prevNode.next;
            for(int i = 0;i < index-1 ; i++)
            {
                nextNode = nextNode.next;
                prevNode = prevNode.next;
            }
            prevNode.next = node;
            node.next = nextNode;
            size++;
        }
    }

    public void add(T element)
    {
        addLast(element);
    }

    @Override
    public void addLast(T element)
    {
        Node node = new Node(element);
        if(first == null)
        {
            node.next = null;
            first = node;
            last = node;
        } else
        {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public void removeFirst()
    {
        first = first.next;
        size--;
    }

    @Override
    public void removeLast()
    {
        Node node = first;
        for(int i = 0 ;i < size-1;i ++)
        {
            node = node.next;
        }
        node.next = null;
        size--;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index == 0) {
            removeFirst();
        }else if(index == this.size)
        {
            removeLast();
        }else
        {
            Node node = first;
            for (int i = 0; i < index - 1; i++)
            {
                node = node.next;
            }
            node.next = node.next.next;
            size--;
        }

    }
    public void remove()
    {
        removeLast();
    }

    @Override
    public void replaceFirst(T element)
    {
        Node node = new Node(element);
        node.next = first.next;
        first = node;
    }

    @Override
    public void replaceLast(T element)
    {
        Node prevNode = first;
        Node node = new Node(element);
        for(int i = 0 ;i < size-2;i ++){
            prevNode = prevNode.next;
        }
        prevNode.next = node;
    }

    @Override
    public void replace(int index, T element)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index == 0) {
            replaceFirst(element);
        }else if(index == this.size)
        {
            replaceLast(element);
        }else
        {
            Node prevNode = first;
            Node node = new Node(element);
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }
            node.next = prevNode.next.next;
            prevNode.next = node;
        }
    }

    public int indexOf(T element)
    {
        int index = 0;
        Node node = first;
        while(node != null)
        {
            if(node.element.equals(element))
            {
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    public int getSize()
    {
        return size;
    }

    public double sum()
    {
        if(size == 0) throw new IllegalStateException("Empty list");
        double sum = 0;
        Node node = first;
        while(node !=null)
        {
            boolean isNumber = (node.element instanceof Number);
            if(!isNumber) throw new IllegalStateException("Not a number list");
            double value = ((Number)node.element).doubleValue();
            sum += value;
            node = node.next;
        }
        return sum;
    }
    @Override
    public String toString()
    {
        String str = "{ ";
        Node node = this.first;
        while(node != null)
        {
            str += node.element.toString() + " ";
            node = node.next;
        }
        str += "}";
        return str;
    }
}
