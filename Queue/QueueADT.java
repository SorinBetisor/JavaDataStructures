package Queue;

public interface QueueADT<T> 
{
    public void enqueue(T element);
    public T dequeue();
    public T front();
    public T back();
    public int size();
    public boolean isEmpty();
}