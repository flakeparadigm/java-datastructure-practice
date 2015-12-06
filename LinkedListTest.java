import static org.junit.Assert.*;

import org.junit.*;

public class LinkedListTest {

	private LinkedList<String> ll1;
	private String str1, str2, str3;

	@Before
	public void setup() {
		ll1 = new LinkedList<String>();

		str1 = "Who";
		str2 = "What";
		str3 = "Where";
	}

	@Test
	public void testAdd() {
		ll1.add(str1);
		ll1.add(str2);

		assertTrue(ll1.contains(str1));
		assertEquals(ll1.indexOf(str1), 0);

		assertTrue(ll1.contains(str2));
		assertEquals(ll1.indexOf(str2), 1);

		assertFalse(ll1.contains(str3));
		assertEquals(ll1.indexOf(str3), -1);

		assertEquals(ll1.size(), 2);
	}

	@Test
	public void testAddIndex() {
		ll1.add(str1);
		ll1.add(str2);

		ll1.add(1, str3);

		assertTrue(ll1.contains(str3));

		assertEquals(ll1.indexOf(str1), 0);
		assertEquals(ll1.indexOf(str3), 1);
		assertEquals(ll1.indexOf(str2), 2);

		assertEquals(ll1.size(), 3);
	}

	@Test
	public void testAddIndexBounds() {
		ll1.add(str1);

		try {
			ll1.add(-1, str2);
			fail(); // should not allow
		} catch (Exception e) {
			assertEquals(e.getClass(), IndexOutOfBoundsException.class);
			assertFalse(ll1.contains(str2));
		}

		try {
			ll1.add(2, str3);
			fail(); // should not allow
		} catch (Exception e) {
			assertEquals(e.getClass(), IndexOutOfBoundsException.class);
			assertFalse(ll1.contains(str3));
		}

		try {
			ll1.add(1, str3);
			assertTrue(ll1.contains(str3));
		} catch (Exception e) {
			fail();
		}

		// will contain str1 and str3
		assertEquals(ll1.size(), 2);
	}

	@Test
	public void testAddNull() {
		ll1.add(str1);
		ll1.add(null);
		ll1.add(str2);

		assertTrue(ll1.contains(null));

		assertEquals(ll1.indexOf(str1), 0);
		assertEquals(ll1.indexOf(null), 1);
		assertEquals(ll1.indexOf(str2), 2);

		assertEquals(ll1.size(), 3);
	}

	@Test
	public void testAddIndexNull() {
		ll1.add(str1);
		ll1.add(str2);
		ll1.add(1, null);

		assertTrue(ll1.contains(null));

		assertEquals(ll1.indexOf(str1), 0);
		assertEquals(ll1.indexOf(null), 1);
		assertEquals(ll1.indexOf(str2), 2);

		assertEquals(ll1.size(), 3);
	}

}
