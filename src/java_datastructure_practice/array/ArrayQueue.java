package java_datastructure_practice.array;

import java.lang.reflect.Array;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/21/16
 */
public class ArrayQueue<T> {

    private int head = 0, tail = 0;
    private T[] array;

    @SuppressWarnings("unchecked")
    public ArrayQueue(Class<T> c, int capacity) {
        array = (T[]) Array.newInstance(c, capacity);
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

    public void enqueue(T element) throws IndexOutOfBoundsException {
        if (size() == array.length-1)
            throw new IndexOutOfBoundsException();

        array[tail] = element;
        if (tail == array.length-1) {
            tail = 0;
        } else {
            tail++;
        }
    }

    public T dequeue() throws IndexOutOfBoundsException {
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
}
