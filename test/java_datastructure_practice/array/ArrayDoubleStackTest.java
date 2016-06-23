package java_datastructure_practice.array;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/22/16
 */
public class ArrayDoubleStackTest {

    private int initSize = 20;
    private ArrayDoubleStack<Integer> s1;

    @Before
    public void setup() {
        s1 = new ArrayDoubleStack<>(Integer.class, initSize);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(s1.isEmpty());
    }

    @Test
    public void testPush1() {
        /* test single pushes */
        s1.push1(0);
        assertFalse(s1.isEmpty1());
        assertEquals(s1.size1(), 1);

        assertFalse(s1.isEmpty());
        assertEquals(s1.size(), 1);

        /* test multiple 1 pushes */
        for (int i = 1; i < initSize; i++)
            s1.push1(i);

        assertFalse(s1.isEmpty1());
        assertEquals(s1.size1(), initSize);

        assertFalse(s1.isEmpty());
        assertEquals(s1.size(), initSize);
    }

    @Test
    public void testPush2() {
        /* test single pushes */
        s1.push2(0);
        assertFalse(s1.isEmpty2());
        assertEquals(s1.size2(), 1);

        assertFalse(s1.isEmpty());
        assertEquals(s1.size(), 1);

        /* test multiple 2 pushes */
        for (int i = 1; i < initSize; i++)
            s1.push2(i);

        assertFalse(s1.isEmpty2());
        assertEquals(s1.size2(), initSize);

        assertFalse(s1.isEmpty());
        assertEquals(s1.size(), initSize);
    }

    @Test
    public void testPushCombos() {

    }

    @Test
    public void testPop1() {
        /* test single pop */
        s1.push1(0);
        assertEquals((int) s1.pop1(), 0);
        assertTrue(s1.isEmpty1());
        assertEquals(s1.size1(), 0);

        assertTrue(s1.isEmpty());
        assertEquals(s1.size(), 0);

        /* test multiple pops */
        for (int i = 0; i < initSize; i++)
            s1.push1(i);

        assertEquals((int) s1.pop1(), initSize-1);
        assertEquals(s1.size1(), initSize-1);

        assertEquals((int) s1.pop1(), initSize-2);
        assertEquals(s1.size1(), initSize-2);

        /* test popping all */
        for (int i = initSize-2; i > 0; i--)
            assertEquals((int) s1.pop1(), i-1);

        assertTrue(s1.isEmpty1());
        assertTrue(s1.isEmpty());
    }

    @Test
    public void testPop2() {
        /* test single pop */
        s1.push2(0);
        assertEquals((int) s1.pop2(), 0);
        assertTrue(s1.isEmpty2());
        assertEquals(s1.size2(), 0);

        assertTrue(s1.isEmpty());
        assertEquals(s1.size(), 0);

        /* test multiple pops */
        for (int i = 0; i < initSize; i++)
            s1.push2(i);

        assertEquals((int) s1.pop2(), initSize-1);
        assertEquals(s1.size2(), initSize-1);

        assertEquals((int) s1.pop2(), initSize-2);
        assertEquals(s1.size2(), initSize-2);

        /* test popping all */
        for (int i = initSize-2; i > 0; i--)
            assertEquals((int) s1.pop2(), i-1);

        assertTrue(s1.isEmpty2());
        assertTrue(s1.isEmpty());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testPushArrayBounds1() {
        /* try to overflow stack 1 */
        for (int i = 0; i < initSize + 1; i++)
            s1.push1(i);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testPushArrayBounds2() {
        /* try to overflow stack 2 */
        for (int i = 0; i < initSize + 1; i++)
            s1.push2(i);
    }

    @Test
    public void testPushArrayBoundsCombo() {
        /* try to overflow both in many different ways */
        for (int i = 1; i < initSize-1; i++) {
            /* overflow 2 over 1 */
            s1 = new ArrayDoubleStack<>(Integer.class, initSize);
            try {
                for (int j = 0; j < i; i++) {
                    s1.push1(j);
                }
                for (int j = initSize; j > i; j--) {
                    s1.push2(j);
                }

                Assert.fail();
            } catch (IndexOutOfBoundsException e) {
                // do nothing. We expect this
            }

            /* overflow 1 over 2 */
            s1 = new ArrayDoubleStack<>(Integer.class, initSize);
            try {
                for (int j = 0; j < i; i++) {
                    s1.push2(j);
                }
                for (int j = initSize; j > i; j--) {
                    s1.push1(j);
                }

                Assert.fail();
            } catch (IndexOutOfBoundsException e) {
                // do nothing. We expect this
            }
        }
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testPopArrayBounds1() {
        for (int i = 0; i < initSize; i++)
            s1.push1(i);

        for (int i = 0; i < initSize+1; i++)
            s1.pop1();
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testPopArrayBounds2() {
        for (int i = 0; i < initSize; i++)
            s1.push1(i);

        for (int i = 0; i < initSize+1; i++)
            s1.pop1();
    }
}
