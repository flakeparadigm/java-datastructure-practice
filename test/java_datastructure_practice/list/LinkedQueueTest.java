package java_datastructure_practice.list;

import org.junit.*;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/23/16
 */
public class LinkedQueueTest {

    private int initSize = 10;
    private LinkedQueue<Integer> q1;

    @Before
    public void setup() {
        q1 = new LinkedQueue<>();
    }

    @Test
    public void testIsEmpty() {
        assertFalse(q1.hasNext());
    }

    @Test
    public void testEnqueue() {
        /* test single enqueueBack */
        q1.enqueue(0);
        assertTrue(q1.hasNext());
        assertEquals(q1.size(), 1);

        /* test multiple enqueues */
        for (int i = 1; i < initSize; i++)
            q1.enqueue(i);

        assertTrue(q1.hasNext());
        assertEquals(q1.size(), initSize);
    }

    @Test
    public void testDequeue() {
        /* test single dequeueFront */
        q1.enqueue(0);
        assertEquals((int) q1.dequeue(), 0);
        assertFalse(q1.hasNext());
        assertEquals(q1.size(), 0);

        /* test multiple dequeues */
        for (int i = 0; i < initSize; i++)
            q1.enqueue(i);

        assertEquals((int) q1.dequeue(), 0);
        assertEquals(q1.size(), initSize-1);

        assertEquals((int) q1.dequeue(), 1);
        assertEquals(q1.size(), initSize-2);

        /* test dequeueing all */
        for (int i = 2; i < initSize; i++)
            assertEquals((int) q1.dequeue(), i);

        assertFalse(q1.hasNext());
    }


    @Test(expected=NoSuchElementException.class)
    public void testDequeueUnderflow() {
        /* dequeueFront more than we enqueued */
        for (int i = 0; i < initSize/2; i++)
            q1.enqueue(i);

        for (int i = 0; i < (initSize/2)+1; i++)
            q1.dequeue();
    }

}