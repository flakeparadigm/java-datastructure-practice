package java_datastructure_practice.list;

import java.util.EmptyStackException;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/23/16
 *
 * CLRS: Intro to Algos
 * Exercise 10.2-2
 *
 * Stack implementation based on singly-linked list where PUSH/POP take O(1) time
 */
public class LinkedStack<E> extends LinkedList {

    private int size = 0;
    private Node<E> head;

    public LinkedStack() {
        head = null;
    }

    public int size() {
        return size;
    }

    public boolean hasNext() {
        return head != null;
    }

    public void push(E element) {
        Node<E> n = new Node<>(element, head);
        head = n;

        size++;
    }

    public E pop() throws EmptyStackException {
        if (head == null)
            throw new EmptyStackException();

        Node<E> n = head;

        /* get the info we need */
        E element = n.element;
        head = n.next;

        n.destroy();
        size--;

        return element;
    }

}
