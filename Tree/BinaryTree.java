package Tree;

public class BinaryTree<T> implements BinaryTreeADT<T> {

    public Node<T> root;

    public BinaryTree(T rootVal) {
        root = new Node<T>(rootVal);
    }

    @Override
    /*
     * In order traversal:
     * The left subtree is traversed first
     * Then the root node for that subtree is traversed
     * Finally, the right subtree is traversed
     */
    public void traverseInOrder(Node<T> root) {
        if (root == null)
            return;

        traverseInOrder(root.left);

        System.out.println(root.data);

        traverseInOrder(root.right);
    }

    public void traversePreOrder(Node<T> root) {
        if (root == null)
            return;

        System.out.println(root.data);

        traversePreOrder(root.left);

        traversePreOrder(root.right);
    }

    public void traversePostOrder(Node<T> root) {
        if (root == null)
            return;

        traversePostOrder(root.left);

        traversePostOrder(root.right);

        System.out.println(root.data);
    }

    @Override
    public Node<T> successor(Node<T> node) { // next node in the node's in order traversal
        if (node.right != null)
            return node.right;
        Node<T> parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    @Override
    public Node<T> predecessor(Node<T> node) { // what comes before (in order traversal)
        if (node.left != null)
            return node.left;

        Node<T> parent = node.parent;
        while (parent != null && node == parent.left) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    @Override
    public Node<T> subtree_first(Node<T> node) { // what comes first in the traversal order within the subtree
        while (node.left != null) // find leftmost node
            node = node.left;
        return node;
    }

    @Override
    public void subtree_insert_after(Node<T> node, Node<T> newNode) { // insert node after (in order traversal)
        if (node.right == null) {
            node.right = newNode;
        } else {
            successor(node).left = newNode;
        } // abstraction -> see successor
    }

    @Override
    public void subtree_insert_before(Node<T> node, Node<T> newNode) { // insert node before (in order traversal)
        if (node.left == null) {
            node.left = newNode;
        } else {
            predecessor(node).right = newNode;
        } // abstraction -> see predecessor
    }

    @Override
    public void subtree_delete(Node<T> node) { // delete node and re-do (in order traversal)
        if (node.right == null && node.left == null && node.parent != null) {
            // if node is leaf, detach
            node.parent = null;
        } else {
            if (node.left != null) {
                Node<T> predecessor = predecessor(node);
                T temp = node.data;
                node.data = predecessor.data;
                predecessor.data = temp;
                subtree_delete(predecessor);
            } else {
                Node<T> successor = successor(node);
                T temp = node.data;
                node.data = successor.data;
                successor.data = temp;
                subtree_delete(successor);
            }
        }
    }

    @Override
    public boolean checkBST(Node<T> root, int min, int max) {
        try {
            if (root == null) {
                return true;
            }

            if ((Integer) root.data < min || (Integer) root.data > max) {
                return false;
            }

            return (checkBST(root.left, min, (Integer) root.data - 1)
                    && checkBST(root.right, (Integer) root.data + 1, max)); // no equal values allowed

        } catch (Exception e) // In case of root.data not being an integer
        {
            System.out.println("Data type not supported");
            return false;
        }
    }

    @Override
    public boolean checkBSTWrapper(Node<T> root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); // Assuming Integers
    }

}
