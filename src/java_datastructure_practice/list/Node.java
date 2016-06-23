package java_datastructure_practice.list;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/21/16
 */
class Node<T> {
    public T element;
    public Node<T> next, prev;

    /**
     * Initializes a LinkedListNode with the given information. May be null.
     */
    public Node(T element, Node<T> next) {
        this(element, null, next);
    }
    public Node(T element, Node<T> prev, Node<T> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Clears the references to other objects stored in this node.
     */
    public void destroy() {
        element = null;
        prev = null;
        next = null;
    }
}
