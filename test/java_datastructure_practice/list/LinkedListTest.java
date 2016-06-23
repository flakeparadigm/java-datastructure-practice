package java_datastructure_practice.list;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * java-datastructure-practice
 * Tyler Nienhouse (tyler)
 * 6/21/16
 */
public class LinkedListTest {

    private LinkedList<String> ll;
    private String str1, str2, str3;

    @Before
    public void setup() {
        ll = new LinkedList<String>();

        str1 = "Who";
        str2 = "What";
        str3 = "Where";
    }

    @Test
    public void testAdd() {
        ll.add(str1);
        ll.add(str2);

        assertTrue(ll.contains(str1));
        assertEquals(0, ll.indexOf(str1));

        assertTrue(ll.contains(str2));
        assertEquals(1, ll.indexOf(str2));

        assertFalse(ll.contains(str3));
        assertEquals(-1, ll.indexOf(str3));

        assertEquals(2, ll.size());
    }

    @Test
    public void testAddIndex() {
        ll.add(str1);
        ll.add(str2);

        ll.add(1, str3);

        assertTrue(ll.contains(str3));

        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(str3));
        assertEquals(2, ll.indexOf(str2));

        assertEquals(3, ll.size());
    }

    @Test
    public void testAddIndexBounds() {
        ll.add(str1);

        try {
            ll.add(-1, str2);
            Assert.fail(); // should not allow
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
            assertFalse(ll.contains(str2));
        }

        try {
            ll.add(2, str3);
            Assert.fail(); // should not allow
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
            assertFalse(ll.contains(str3));
        }

        try {
            ll.add(1, str3);
            assertTrue(ll.contains(str3));
        } catch (Exception e) {
            Assert.fail();
        }

        // will contain str1 and str3
        assertEquals(2, ll.size());
    }

    @Test
    public void testAddNull() {
        ll.add(str1);
        ll.add(null);
        ll.add(str2);

        assertTrue(ll.contains(null));

        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(null));
        assertEquals(2, ll.indexOf(str2));

        assertEquals(3, ll.size());
    }

    @Test
    public void testAddIndexNull() {
        ll.add(str1);
        ll.add(str2);
        ll.add(1, null);

        assertTrue(ll.contains(null));

        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(null));
        assertEquals(2, ll.indexOf(str2));

        assertEquals(3, ll.size());
    }

    @Test
    public void testRemove() {
        ll.add(str1);
        ll.add(str2);
        ll.add(str3);
        assertTrue(ll.contains(str2));

        ll.remove(str2);
        assertFalse(ll.contains(str2));

        assertEquals(2, ll.size());
        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(str3));
    }

    @Test
    public void testRemoveEnds() {
        ll.add(str1);
        ll.add(str2);
        ll.add(str3);
        assertEquals(3, ll.size());

        ll.remove(str3);
        assertFalse(ll.contains(str3));
        assertEquals(2, ll.size());

        ll.remove(str1);
        assertFalse(ll.contains(str1));
        assertEquals(1, ll.size());
    }

    @Test
    public void testRemoveNoexist() {
        ll.add(str1);
        ll.add(str2);
        assertEquals(2, ll.size());

        ll.remove(str3);
        assertEquals(2, ll.size());
        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(str2));

        ll.remove(null);
        assertEquals(2, ll.size());
        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(str2));
    }

    @Test
    public void testRemoveNull() {
        ll.add(str1);
        ll.add(str2);
        ll.add(null);
        ll.add(str3);
        assertTrue(ll.contains(null));

        ll.remove(null);
        assertFalse(ll.contains(null));

        assertEquals(3, ll.size());
        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(str2));
        assertEquals(2, ll.indexOf(str3));
    }

    @Test
    public void testRemoveIndex() {
        ll.add(str1);
        ll.add(str2);
        ll.add(str3);
        assertTrue(ll.contains(str2));

        String res = ll.remove(1);
        assertEquals(str2, res);
        assertFalse(ll.contains(str2));

        assertEquals(2, ll.size());
        assertEquals(0, ll.indexOf(str1));
        assertEquals(1, ll.indexOf(str3));
    }

    @Test
    public void testRemoveIndexBounds() {
        ll.add(str1);
        ll.add(str2);
        ll.add(str3);

        try {
            ll.remove(-1);
            Assert.fail(); // should not allow
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
            assertEquals(3, ll.size());
        }

        try {
            ll.remove(3);
            Assert.fail(); // should not allow
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
            assertEquals(3, ll.size());
        }
    }

    @Test
    public void testClear() {
        ll.add(str1);
        ll.add(str2);
        ll.add(str3);
        assertEquals(3, ll.size());

        ll.clear();

        assertEquals(0, ll.size());
        assertFalse(ll.contains(str1));
        assertFalse(ll.contains(str2));
        assertFalse(ll.contains(str3));
    }

    @Test
    public void testGet() {
        ll.add(str1);
        ll.add(str2);

        String res = ll.get(1);
        assertEquals(str2, res);
    }

    @Test
    public void testGetBounds() {
        ll.add(str1);
        ll.add(str2);

        try {
            ll.get(-1);
            Assert.fail(); // should not allow
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        try {
            ll.get(2);
            Assert.fail(); // should not allow
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    public void testArray() {
        ll.add(str1);
        ll.add(str2);
        ll.add(str3);
        assertEquals(3, ll.size());

        Object[] res = ll.toArray();
        assertEquals(3, res.length);

        assertEquals(res[0], str1);
        assertEquals(res[1], str2);
        assertEquals(res[2], str3);
    }
}