package Stack;
import LinkedList.Node;
public class StackLinkBased<T> implements StackADT<T>{

    Node<T> top;
    int size;

    public StackLinkBased()
    {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T element)
    {
        if(top==null)
        {
            top = new Node<T>(element);
            size++;
            return;
        }

        Node<T> previousTop = top;
        top = new Node<T>(element);
        top.next = previousTop;
        size++;
    }

    @Override
    public T pop()
    {
        Node<T> topNode = top;
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return null;
        }

        if(size == 1)
        {
            top = null;
            size--;
            return topNode.value;
        }

        top = top.next;
        size--;
        return topNode.value;
    }

    @Override
    public T top(){return top.value;}
    @Override
    public int size(){return size;}

    @Override
    public boolean isEmpty() {
        return (size==0);
    }
}
