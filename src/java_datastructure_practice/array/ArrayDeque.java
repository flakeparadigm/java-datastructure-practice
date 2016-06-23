package java_datastructure_practice.array;

import java.lang.reflect.Array;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/22/16
 *
 * CLRS: Intro to Algos
 * Exercise 10.1-5
 */
public class ArrayDeque<T> {

    private int head = 0, tail = 0;
    private T[] array;

    @SuppressWarnings("unchecked")
    public ArrayDeque(Class<T> c, int capacity) {
        array = (T[]) Array.newInstance(c, capacity+1);
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        if (tail >= head) {
            return tail - head;
        } else {
            return array.length - (head-tail);
        }
    }

    /**
     * Adds an element to the back of the line
     * (equal to the queue "enqueue" method)
     */
    public void enqueueBack(T element) throws IndexOutOfBoundsException {
        if (size() == array.length-1)
            throw new IndexOutOfBoundsException();

        array[tail] = element;
        if (tail == array.length-1) {
            tail = 0;
        } else {
            tail++;
        }
    }

    /**
     * Adds an element to the FRONT of the line
     */
    public void enqueueFront(T element) throws IndexOutOfBoundsException {
        if (size() == array.length-1)
            throw new IndexOutOfBoundsException();

        if (head == 0) {
            head = array.length-1;
        } else {
            head--;
        }

        array[head] = element;
    }

    /**
     * Takes the element at the front of the line
     * (equal to the queue "dequeue" method)
     */
    public T dequeueFront() throws IndexOutOfBoundsException {
        if (head == tail)
            throw new IndexOutOfBoundsException();

        T element = array[head];

        if (head == array.length-1) {
            head = 0;
        } else {
            head++;
        }

        return element;
    }

    /**
     * Takes the element from the BACK of the line
     */
    public T dequeueBack() throws IndexOutOfBoundsException {
        if (head == tail)
            throw new IndexOutOfBoundsException();

        if (tail == 0) {
            tail = array.length-1;
        } else {
            tail--;
        }

        return array[tail];
    }
}
