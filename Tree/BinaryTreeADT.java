package Tree;

public interface BinaryTreeADT<T>
{
    public boolean checkBST(Node<T> root);
    public void traverseInOrder(Node<T> root);
    public Node<T> successor(Node<T> node);
    public Node<T> predecessor(Node<T> node);
    public Node<T> subtree_first(Node<T> node);
    public void subtree_insert_after(Node<T> node, Node<T> newNode);
    public void subtree_insert_before(Node<T> node, Node<T> newNode);
    public void subtree_delete(Node<T> node);
}