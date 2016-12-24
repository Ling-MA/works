package fil.coo.pisine;

import org.junit.Test;
import fil.coo.piscine.Basket;
import fil.coo.piscine.Resource;
import junit.framework.TestCase;

public class ResourceTest extends TestCase {
	Resource r = new Basket();

	@Test
	public void testResource() {
		assertNotNull(r);
	}
}
