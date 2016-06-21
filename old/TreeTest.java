import static org.junit.Assert.*;

import java.util.Random;

import org.junit.*;

public class TreeTest {

	private Tree<Integer, String> tree;
	private Random rand;
	
	@Before
	public void setup() {
		tree = new Tree<Integer, String>();
		rand = new Random();
	}
	
	@Test
	public void testSorting() {
		for (int i = 0; i < 1000; i++) {
			tree.insert(rand.nextInt(10000), "test");
		}

		String order = tree.toString();
		String items[] = order.split(",");

		for (int i = 1; i < items.length; i++) {
			if (Integer.parseInt(items[i-1]) > Integer.parseInt(items[i]))
				fail();
		}
	}

}
