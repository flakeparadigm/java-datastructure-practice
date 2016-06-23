package java_datastructure_practice.array;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/22/16
 */
public class ArrayDequeTest {

    private int initSize = 10;
    private ArrayDeque<Integer> q1;

    @Before
    public void setup() {
        q1 = new ArrayDeque<>(Integer.class, initSize);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(q1.isEmpty());
    }

    @Test
    public void testEnqueueBack() {
        /* test single enqueueBack */
        q1.enqueueBack(0);
        assertFalse(q1.isEmpty());
        assertEquals(q1.size(), 1);

        /* test multiple enqueueBacks */
        for (int i = 1; i < initSize; i++)
            q1.enqueueBack(i);

        assertFalse(q1.isEmpty());
        assertEquals(q1.size(), initSize);
    }

    @Test
    public void testEnqueueFront() {
        /* test single enqueueBack */
        q1.enqueueFront(0);
        assertFalse(q1.isEmpty());
        assertEquals(q1.size(), 1);

        /* test multiple enqueueBacks */
        for (int i = 1; i < initSize; i++)
            q1.enqueueFront(i);

        assertFalse(q1.isEmpty());
        assertEquals(q1.size(), initSize);
    }

    @Test
    public void testDequeueFront() {
        /* test single dequeueFront */
        q1.enqueueBack(0);
        assertEquals((int) q1.dequeueFront(), 0);
        assertTrue(q1.isEmpty());
        assertEquals(q1.size(), 0);

        /* test multiple dequeueFronts */
        for (int i = 0; i < initSize-1; i++)
            q1.enqueueBack(i);

        assertEquals((int) q1.dequeueFront(), 0);
        assertEquals(q1.size(), initSize-2);

        assertEquals((int) q1.dequeueFront(), 1);
        assertEquals(q1.size(), initSize-3);

        /* test dequeueFronting all */
        for (int i = 2; i < initSize-1; i++)
            assertEquals((int) q1.dequeueFront(), i);

        assertTrue(q1.isEmpty());
    }

    @Test
    public void testDequeueBack() {
        /* test single dequeueFront */
        q1.enqueueFront(0);
        assertEquals((int) q1.dequeueBack(), 0);
        assertTrue(q1.isEmpty());
        assertEquals(q1.size(), 0);

        /* test multiple dequeueFronts */
        for (int i = 0; i < initSize-1; i++)
            q1.enqueueFront(i);

        assertEquals((int) q1.dequeueBack(), 0);
        assertEquals(q1.size(), initSize-2);

        assertEquals((int) q1.dequeueBack(), 1);
        assertEquals(q1.size(), initSize-3);

        /* test dequeueFronting all */
        for (int i = 2; i < initSize-1; i++)
            assertEquals((int) q1.dequeueBack(), i);

        assertTrue(q1.isEmpty());
    }

    @Test
    public void testWrapAroundNormal() {

        enqueueDequeueHalf();

        /* en/dequeueFront whole capacity */
        for (int i = 0; i < initSize; i++)
            q1.enqueueBack(i);

        assertEquals(q1.size(), initSize);

        for (int i = 0; i < initSize; i++) {
            assertEquals(q1.size(), initSize-i);
            assertEquals((int) q1.dequeueFront(), i);
        }

        assertEquals(q1.size(), 0);
    }

    @Test
    public void testWrapAroundBackwards() {

        enqueueDequeueHalf();

        /* en/dequeueFront whole capacity */
        for (int i = 0; i < initSize; i++)
            q1.enqueueFront(i);

        assertEquals(q1.size(), initSize);

        for (int i = 0; i < initSize; i++) {
            assertEquals(q1.size(), initSize-i);
            assertEquals((int) q1.dequeueBack(), i);
        }

        assertEquals(q1.size(), 0);
    }

    @Test
    public void testEnqueueBackArrayBounds() {
        /* overfill to end of array */
        try {
            for (int i = 0; i < initSize + 1; i++)
                q1.enqueueBack(i);

            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing. We expect this
        }

        /* overfill when tail passes head */
        q1 = new ArrayDeque<>(Integer.class, initSize);
        enqueueDequeueHalf();

        try {
            for (int i = 0; i < initSize + 1; i++)
                q1.enqueueBack(i);

            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing. We expect this
        }
    }
    @Test
    public void testEnqueueFrontArrayBounds() {
        /* overfill to end of array */
        try {
            for (int i = 0; i < initSize + 1; i++)
                q1.enqueueFront(i);

            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing. We expect this
        }

        /* overfill when head passes tail */
        q1 = new ArrayDeque<>(Integer.class, initSize);
        enqueueDequeueHalf();

        try {
            for (int i = 0; i < initSize + 1; i++)
                q1.enqueueFront(i);

            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing. We expect this
        }
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testDequeueFrontArrayBounds() {
        /* dequeueFront more than we enqueued */
        for (int i = 0; i < initSize/2; i++)
            q1.enqueueBack(i);

        for (int i = 0; i < (initSize/2)+1; i++)
            q1.dequeueFront();
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testDequeueBackArrayBounds() {
        /* dequeueBack more than we enqueued */
        for (int i = 0; i < initSize/2; i++)
            q1.enqueueFront(i);

        for (int i = 0; i < (initSize/2)+1; i++)
            q1.dequeueBack();
    }

    private void enqueueDequeueHalf() {
        /* en/dequeueFront half of the size1 */
        for (int i = 0; i < initSize/2; i++) {
            q1.enqueueBack(i);
            q1.dequeueFront();
        }
        assertEquals(q1.size(), 0);
    }
}
