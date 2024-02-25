package Stack;
public class StackArrayBased<T> implements StackADT<T> {

    private T[] elements;
    private int size;
    private int top_index;
    private int array_size;

    public StackArrayBased(int arraySize)
    {
        this.size = 0;
        this.top_index = -1;
        this.array_size = arraySize;
        this.elements = (T[]) new Object[arraySize];
    }
    @Override
    public void push(T element) {
        if(size == array_size)
        {
            System.out.println("The stack is full");
            return;
        }
        this.top_index++;
        this.size++;
        this.elements[this.top_index] = element;

    }
    @Override
    public T pop() {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return null;
        }
        T topElement = elements[top_index];
        elements[top_index] = null;
        top_index--;
        size--;
        return topElement;
    }
    @Override
    public T top() {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return null;
        }
        return elements[top_index];
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return (size==0);
    }
    
}
