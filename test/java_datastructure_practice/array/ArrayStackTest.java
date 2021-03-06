package java_datastructure_practice.array;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/21/16
 */
public class ArrayStackTest {

    private int initSize = 10;
    private ArrayStack<Integer> s1;

    @Before
    public void setup() {
        s1 = new ArrayStack<>(Integer.class, initSize);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(s1.isEmpty());
    }

    @Test
    public void testPush() {
        /* test single push1 */
        s1.push(0);
        assertFalse(s1.isEmpty());
        assertEquals(s1.size(), 1);

        /* test multiple pushes */
        for (int i = 1; i < initSize; i++)
            s1.push(i);

        assertFalse(s1.isEmpty());
        assertEquals(s1.size(), initSize);
    }

    @Test
    public void testPop() {
        /* test single pop1 */
        s1.push(0);
        assertEquals((int) s1.pop(), 0);
        assertTrue(s1.isEmpty());
        assertEquals(s1.size(), 0);

        /* test multiple pops */
        for (int i = 0; i < initSize; i++)
            s1.push(i);

        assertEquals((int) s1.pop(), initSize-1);
        assertEquals(s1.size(), initSize-1);

        assertEquals((int) s1.pop(), initSize-2);
        assertEquals(s1.size(), initSize-2);

        /* test popping all */
        for (int i = initSize-2; i > 0; i--)
            assertEquals((int) s1.pop(), i-1);

        assertTrue(s1.isEmpty());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testPushArrayBounds() {
        for (int i = 0; i < initSize+1; i++)
            s1.push(i);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testPopArrayBounds() {
        for (int i = 0; i < initSize; i++)
            s1.push(i);

        for (int i = 0; i < initSize+1; i++)
            s1.pop();
    }

}