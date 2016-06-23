package java_datastructure_practice.tree;

import java.util.Comparator;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/23/16
 */
public class Tree<K, V> {

    Node<K, V> root;
    Comparator<K> comparator;
    int size;

    /**
     * Create a tree that will rely on the keys to be Comparable
     */
    public Tree() {
        root = null;
        comparator = null;
        size = 0;
    }

    /**
     * Create a tree that will compare keys with the supplied Comparator
     *
     * @param c
     *            The comparator to use when comparing keys
     */
    public Tree(Comparator<K> c) {
        this();
        comparator = c;
    }

    /**
     * Find the value stored at the given key
     *
     * @param key
     * @return The value at the given key
     */
    public V find(K key) {
        return findHelper(key, root).value;
    }

    /**
     * Returns the node containing the specified Key
     *
     * @param key
     *            The identifier of the node to find
     * @param node
     *            The node to check in this iteration of the recursive search
     * @return The node identified by the supplied key
     */
    private Node<K, V> findHelper(K key, Node<K, V> node) {
        if (node == null)
            return null;

        if (compare(key, node.key) < 0)
            return findHelper(key, node.left);
        else if (compare(key, node.key) > 0)
            return findHelper(key, node.right);

        return node;
    }

    /**
     * Inserts a new node with the given key and value into the tree
     *
     * @param key
     *            The key that identifies the new node
     * @param value
     *            The value to store with that key
     */
    public void insert(K key, V value) {
        root = insertHelper(key, value, root);
    }

    private Node<K, V> insertHelper(K key, V value, Node<K, V> node) {
        if (node == null)
            return new Node<K, V>(key, value);
        else if (compare(key, node.key) < 0)
            node.left = insertHelper(key, value, node.left);
        else
            node.right = insertHelper(key, value, node.right);

        return node;
    }

    /**
     * Delete the value identified by the given Key from the tree, and return
     * that value
     *
     * @param key
     *            The key identifying the value to delete from the tree
     * @return The value deleted from the tree
     */
    public V delete(K key) {
        V tmp = findHelper(key, root).value;
        root = deleteHelper1(key, root);

        return tmp;
    }

    /**
     * Returns the root of the subtree rooted at @param node with the node
     * identified by @param key removed from it.
     *
     * @param key
     *            The key identifying the node to remove
     * @param node
     *            The root of the tree to remove the node from
     * @return The root node of the new tree
     */
    private Node<K, V> deleteHelper1(K key, Node<K, V> node) {
        if (node == null)
            return null;

        if (compare(key, node.key) < 0) {
            node.left = deleteHelper1(key, node.left);
            return node;
        } else if (compare(key, node.key) > 0) {
            node.right = deleteHelper1(key, node.right);
            return node;
        } else if (node.left == null) {
            Node<K, V> tmp = node.right;
            node.destroy();
            return tmp;
        } else if (node.right == null) {
            Node<K, V> tmp = node.left;
            node.destroy();
            return tmp;
        } else {
            node.right = deleteHelper2(node, node.right);
            return node;
        }
    }

    /**
     * Returns subtree that will be rooted at @param root's right, with root's
     * contents replaced with the minimum element in that subtree
     *
     * @param root
     *            The root of the subtree whose values will be replaced by the
     *            minimum
     * @param node
     *            The next node to process
     * @return The node that will be to the right of @param right
     */
    private Node<K, V> deleteHelper2(Node<K, V> root, Node<K, V> node) {
        if (node.left != null) {
            node.left = deleteHelper2(root, node.left);
            return root;
        } else {
            root.key = node.key;
            root.value = node.value;
            Node<K, V> tmp = node.right;

            node.destroy();
            return tmp;
        }
    }

    /**
     * Compares k1 and k2 using the appropriate comparison method
     *
     * @param k1
     *            Object to be compared to
     * @param k2
     *            Object to compare to k1
     * @return negative, zero, or positive if object k1 is less than, equal to,
     *         or greater than k2 (respectively)
     */
    @SuppressWarnings("unchecked")
    private int compare(Object k1, Object k2) {
        if (comparator == null)
            return ((Comparable<K>) k1).compareTo((K) k2);
        else
            return comparator.compare((K) k1, (K) k2);
    }

    public void traverse(Node<K, V> node) {
        if (node.left != null)
            traverse(node.left);

        System.out.print(" " + node + ",");

        if (node.right != null)
            traverse(node.right);
    }
    public String toString() {
        return toString(root);
    }
    public String toString(Node<K, V> node) {
        String res = "";
        if (node.left != null)
            res = toString(node.left);

        res += node + ",";

        if (node.right != null)
            res += toString(node.right);

        return res;
    }
}
