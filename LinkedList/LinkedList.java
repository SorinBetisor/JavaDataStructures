package LinkedList;

public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedList(T val) {
        this.head = new Node<T>(val);
        this.tail = head;
        this.size = 1;
        tail.next = head;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void push_back(T val) {
        if (head == null) {
            head = new Node<T>(val);
            tail = head;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<T>(val);
        tail = temp.next;
        size++;

    }

    public Node<T> remove(int index) {
        Node<T> removedElement = null;

        if (head == null || index < 0) {
            System.out.println("Empty list / invalid index");
            return null;
        }

        if (index == 0) { //first index
            removedElement = head;
            head = head.next;
            return removedElement;
        }

        int dummyIndex = 0;
        Node<T> previous = head;
        Node<T> temp = head.next;
        while (dummyIndex < index - 1) {
            temp = temp.next;
            previous = previous.next;
            dummyIndex++;
        }

        if(temp.next == null) //last index
        {
            removedElement = temp;
            previous.next = null;
            tail = previous;
            size--;
        }

        removedElement = temp;
        previous.next = temp.next;
        size--;

        return removedElement;
    }

    public void insert(int index, T value) 
    {
        if (index == 0)
        {
            Node<T> oldHead = head;
            head = new Node<T>(value);
            head.next = oldHead;
            return;
        }

        int dummyIndex = 1;
        Node<T> current = head;
        Node<T> nextNode = head.next;
        while(dummyIndex<index)
        {
            current = current.next;
            nextNode = nextNode.next;
            dummyIndex++;
        }

        current.next = new Node<T>(value);
        current.next.next = nextNode;

        if(index == size-1)
        {
            tail = current.next;
        }
        size++;
        return;
    }

    public Node<T> get(int index) {
        if (head == null || index < 0 || index > size) {
            System.out.println("Empty list / invalid index");
            return null;
        }

        if (index == 0) {
            return head;
        }

        int dummyIndex = 0;
        Node<T> temp = head;
        while (dummyIndex < index) {
            temp = temp.next;
            dummyIndex++;
        }

        return temp;
    }

    public Node<T> middleElement() {
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reverseList(Node<T> start) {
        Node<T> prev = null;
        Node<T> curr = start;
        Node<T> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int size() {
        return size;
    }
}