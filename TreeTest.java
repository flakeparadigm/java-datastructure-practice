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
		for (int i = 0; i < 200; i++) {
			tree.insert(rand.nextInt(1000), "test");
		}

		String order = tree.toString();
		String items[] = order.split(",", -1);

		for (int i = 1; i < items.length; i++) {
			if (Integer.parseInt(items[i - 1]) > Integer.parseInt(items[i - 1]))
				fail();
		}
	}

}
