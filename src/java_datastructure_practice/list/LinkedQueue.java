package java_datastructure_practice.list;

import java.util.NoSuchElementException;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/23/16
 *
 * CLRS: Intro to Algos
 * Exercise 10.2-3
 *
 * Queue implementation based on singly-linked list where EN/DEQUEUE take
 * O(1) time
 */
public class LinkedQueue<E> {

    private int size = 0;
    private Node<E> head, tail, nil;

    public LinkedQueue() {
        nil = new Node<>(null, null);
        head = tail = nil;
    }

    public boolean hasNext() {
        return head != nil;
    }

    public int size() {
        return size;
    }

    public void enqueue(E element) {
        Node<E> n = new Node<>(element, nil);

        if (tail == nil) {
            /* set head & tail */
            head = tail = n;
        } else {
            /* append to end */
            tail.next = n;
            tail = n;
        }

        size++;
    }

    public E dequeue() throws NoSuchElementException {
        if (head == nil)
            throw new NoSuchElementException();

        /* get info we need */
        Node<E> n = head;
        E element = n.element;

        if (head == tail) {
            /* list empty */
            head = tail = nil;
        } else {
            /* remove from head */
            head = n.next;
        }

        n.destroy();
        size--;

        return element;
    }
}
