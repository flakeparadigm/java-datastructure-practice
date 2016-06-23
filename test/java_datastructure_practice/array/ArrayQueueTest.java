package java_datastructure_practice.array;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/21/16
 */
public class ArrayQueueTest {

    private int initSize = 10;
    private ArrayQueue<Integer> q1;

    @Before
    public void setup() {
        q1 = new ArrayQueue<>(initSize);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(q1.isEmpty());
    }

    @Test
    public void testEnqueue() {
        /* test single enqueue */
        q1.enqueue(0);
        assertFalse(q1.isEmpty());
        assertEquals(q1.size(), 1);

        /* test multiple enqueues */
        for (int i = 1; i < initSize; i++)
            q1.enqueue(i);

        assertFalse(q1.isEmpty());
        assertEquals(q1.size(), initSize);
    }

    @Test
    public void testDequeue() {
        /* test single dequeue */
        q1.enqueue(0);
        assertEquals((int) q1.dequeue(), 0);
        assertTrue(q1.isEmpty());
        assertEquals(q1.size(), 0);

        /* test multiple dequeues */
        for (int i = 0; i < initSize-1; i++)
            q1.enqueue(i);

        assertEquals((int) q1.dequeue(), 0);
        assertEquals(q1.size(), initSize-2);

        assertEquals((int) q1.dequeue(), 1);
        assertEquals(q1.size(), initSize-3);

        /* test dequeueing all */
        for (int i = 2; i < initSize-1; i++)
            assertEquals((int) q1.dequeue(), i);

        assertTrue(q1.isEmpty());
    }

    @Test
    public void testWrapAround() {

        enqueueDequeueHalf();

        /* en/dequeue whole capacity */
        for (int i = 0; i < initSize; i++)
            q1.enqueue(i);

        assertEquals(q1.size(), initSize);

        for (int i = 0; i < initSize; i++) {
            assertEquals(q1.size(), initSize-i);
            assertEquals((int) q1.dequeue(), i);
        }

        assertEquals(q1.size(), 0);
    }

    @Test
    public void testEnqueueArrayBounds1() {
        /* overfill to end of array */
        try {
            for (int i = 0; i < initSize + 1; i++)
                q1.enqueue(i);

            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing. We expect this
        }

        /* overfill when head > tail */
        q1 = new ArrayQueue<>(initSize);
        enqueueDequeueHalf();

        try {
            for (int i = 0; i < initSize + 1; i++)
                q1.enqueue(i);

            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing. We expect this
        }
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testDequeueArrayBounds() {
        /* dequeue more than we enqueued */
        for (int i = 0; i < initSize/2; i++)
            q1.enqueue(i);

        for (int i = 0; i < (initSize/2)+1; i++)
            q1.dequeue();
    }

    private void enqueueDequeueHalf() {
        /* en/dequeue half of the size */
        for (int i = 0; i < initSize/2; i++) {
            q1.enqueue(i);
            q1.dequeue();
        }
        assertEquals(q1.size(), 0);
    }
}