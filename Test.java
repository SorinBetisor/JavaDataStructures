import Tree.BinaryTree;
import Tree.Node;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        tree.root.left = new Node<Integer>(69);
        tree.subtree_insert_after(tree.root, new Node<Integer>(3));
        tree.subtree_insert_before(tree.root.right, new Node<Integer>(7));
        tree.traverseInOrder(tree.root);

    }
}
