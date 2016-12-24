package fil.coo.pisine;

import org.junit.Test;
import java.util.LinkedList;

import fil.coo.piscine.Basket;
import fil.coo.piscine.BasketPool;
import fil.coo.piscine.CubiclePool;
import fil.coo.piscine.ResourcePool;
import fil.coo.piscine.ResourceUser;
import junit.framework.TestCase;

public class RessourcePoolTest extends TestCase {
	BasketPool baskets = new BasketPool(1);
	private String name = "Basket";
	ResourceUser<Basket> ur = new ResourceUser<Basket>();

	@Test
	public void testProvideResource() {
		Basket m = baskets.provideResource();
		String pname = m.getClass().getSimpleName();
		assertEquals(pname, name);
	}

	@Test
	public void testGetBackResource() {
		Basket m = baskets.provideResource();
		ur.setResource(m);
		ur.getResource();
		baskets.getBackResource(m);
		assertNotNull(baskets);
	}
}
