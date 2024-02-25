package Stack;

public interface StackADT<T>
{
    public void push(T element);
    public T pop();
    public T top();
    public int size();
    public boolean isEmpty();
}