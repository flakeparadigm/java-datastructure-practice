package java_datastructure_practice.array;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/21/16
 */
public class ArrayStack<T> {

    private int top = 0;
    private T[] array;

    public ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public void push(T element) throws IndexOutOfBoundsException {
        array[top] = element;
        top++;
    }

    public T pop() throws IndexOutOfBoundsException {
        top--;
        return array[top];
    }
}
