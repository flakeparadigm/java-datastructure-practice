package java_datastructure_practice.tree;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/23/16
 */
class Node<X, Y> {
    public Node<X, Y> left, right;

    public X key;
    public Y value;

    public Node(X key, Y value, Node<X, Y> left, Node<X, Y> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(X key, Y value) {
        this(key, value, null, null);
    }

    public void destroy() {
        left = right = null;
        key = null;
        value = null;
    }

    public String toString() {
        //return key + "(" + value + ")";
        return key + "";
    }
}
