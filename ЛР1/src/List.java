public interface List<T> {
    void addFirst(T e);
    void add(int index, T e);
    void addLast(T e);
    void removeFirst();
    void removeLast();
    void remove(int index);
    void replaceFirst(T e);
    void replaceLast(T e);
    void replace(int index, T e);

    int indexOf(T e);
    int sum();
    int getSize();
}
