package Set;

public interface SetADT<T> {
    public void add(T element);
    public void remove(T element);
    public boolean contains(T element);
    public int size();
    public boolean isEmpty();
    public void print();
    public T find(T element);
    public void sort();
}
