package Set;

import java.util.Arrays;

//TODO:Implement with sort()
public class SetArrayBased<T> implements SetADT<T> {
    private T[] set;
    private int size;
    @SuppressWarnings("unused")
    private int capacity;
    private int nextFreeIndex;

    public SetArrayBased(int setCapacity) {
        this.set = (T[]) new Object[setCapacity];
        this.size = 0;
        this.nextFreeIndex = 0;
    }

    @Override
    public void add(T element) {
        if(contains(element)) return; //if element already exists in the set, return (no duplicates allowed)
        if (nextFreeIndex == set.length) {
            set = Arrays.copyOf(set, set.length * 2);
        }
        set[nextFreeIndex] = element;
        nextFreeIndex++;
        size++;
    }

    @Override
    public void remove(T element) {
        int indexToRemove = -1;
        for (int i = 0; i < size; i++) {
            if (set[i].equals(element)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) { //shift elements to the left to cover gap
            for (int i = indexToRemove; i < size - 1; i++) {
                set[i] = set[i + 1];
            }
            set[size - 1] = null;
            size--;
            nextFreeIndex--;
        } else {
            System.out.println("Element not found");
        }
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (set[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(set[i]);
        }
    }

    @Override
    public T find(T element) {
        return null;
    }

    @Override
    public void sort() {
    }

}
