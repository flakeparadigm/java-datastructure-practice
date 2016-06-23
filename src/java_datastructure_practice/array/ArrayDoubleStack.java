package java_datastructure_practice.array;

import java.lang.reflect.Array;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/22/16
 *
 * CLRS: Intro to Algos
 * Exercise 10.1-2
 */
public class ArrayDoubleStack<T> {

    private int top = 0;
    private int btm;
    private T[] array;

    @SuppressWarnings("unchecked")
    public ArrayDoubleStack(Class<T> c, int capacity) {
        array = (T[]) Array.newInstance(c, capacity);
        btm = capacity-1;
    }

    public boolean isEmpty() {
        return isEmpty1() && isEmpty2();
    }
    public boolean isEmpty1() {
        return top == 0;
    }
    public boolean isEmpty2() {
        return btm == array.length-1;
    }

    public int size() {
        return size1() + size2();
    }
    public int size1() {
        return top;
    }
    public int size2() {
        return array.length - btm - 1;
    }

    public void push1(T element) throws IndexOutOfBoundsException {
        if (top > btm) {
            throw new IndexOutOfBoundsException();
        }

        array[top] = element;
        top++;
    }
    public void push2(T element) throws IndexOutOfBoundsException {
        if (btm < top)
            throw new IndexOutOfBoundsException();

        array[btm] = element;
        btm--;
    }

    public T pop1() throws IndexOutOfBoundsException {
        top--;
        return array[top];
    }
    public T pop2() throws IndexOutOfBoundsException {
        btm++;
        return array[btm];
    }
}
