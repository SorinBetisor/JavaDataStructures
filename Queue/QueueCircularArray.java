package Queue;

public class QueueCircularArray<T> implements QueueADT<T> {

    private T[] elements;
    private int arraySize;
    private int size;
    private int front_index;  // this leaves first
    private int rear_index;
    public QueueCircularArray(int array_size)
    {
        this.elements = (T[]) new Object[array_size];
        this.size = 0;
        this.arraySize = array_size;
        this.front_index = 0;
        this.rear_index = 0;
    }

    @Override
    public void enqueue(T element) {
        if(this.size == this.arraySize)
        {
            System.out.println("The queue is full");
            return;
        }
        elements[rear_index] = element;
        rear_index = (rear_index+1)%arraySize;
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }else{
            T front_element = elements[front_index];
            elements[front_index] = null;
            front_index = (front_index + 1) % this.arraySize;
            this.size--;
            return front_element;
        }
        }
    
    @Override
    public T front() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        return elements[front_index];
    }
    
    @Override
    public T back() {
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }
        int currentRearIndex = rear_index;
        while(elements[currentRearIndex] == null){
            currentRearIndex = (currentRearIndex - 1 + arraySize) % arraySize;
        }
        return elements[currentRearIndex];
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
