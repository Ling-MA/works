package fil.coo.pisine;

import org.junit.Test;
import fil.coo.action.Action.Status;
import fil.coo.action.S_schedulerTest;
import fil.coo.piscine.BasketPool;
import fil.coo.piscine.CubiclePool;
import fil.coo.piscine.Swimmer;
import junit.framework.TestCase;

public class SwimmerTest extends S_schedulerTest {

	BasketPool baskets = new BasketPool(6);
	CubiclePool cubicles = new CubiclePool(3);
	String init = "READY";
	Swimmer g = new Swimmer("dd", baskets, cubicles, 6, 2, 4);
	Status status = Status.READY;

	@Test
	public void march() {
		while (g.getStatus() != Status.FINISHED) {
			g.doStep();
		}
		status = g.getStatus();
	}

	@Test
	public void testdostep() {
		String ss = status.name().toString();
		assertEquals(ss, init);
	}
}
