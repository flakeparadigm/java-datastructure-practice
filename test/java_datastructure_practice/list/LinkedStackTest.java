package java_datastructure_practice.list;

import org.junit.*;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/23/16
 */
public class LinkedStackTest {

    private int initSize = 10;
    private LinkedStack<Integer> s1;

    @Before
    public void setup() {
        s1 = new LinkedStack<>();
    }

    @Test
    public void testEmptyHasNext() {
        assertFalse(s1.hasNext());
    }

    @Test
    public void testPush() {
        /* test single push1 */
        s1.push(0);
        assertTrue(s1.hasNext());
        assertEquals(s1.size(), 1);

        /* test multiple pushes */
        for (int i = 1; i < initSize; i++)
            s1.push(i);

        assertTrue(s1.hasNext());
        assertEquals(s1.size(), initSize);
    }

    @Test
    public void testPop() {
        /* test single pop1 */
        s1.push(0);
        assertEquals((int) s1.pop(), 0);
        assertFalse(s1.hasNext());
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

        assertFalse(s1.hasNext());
    }

    @Test(expected=EmptyStackException.class)
    public void testPopUnderflow() {
        for (int i = 0; i < initSize; i++)
            s1.push(i);

        for (int i = 0; i < initSize+1; i++)
            s1.pop();
    }

}