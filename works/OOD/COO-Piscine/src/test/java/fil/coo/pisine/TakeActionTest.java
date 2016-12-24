package fil.coo.pisine;

import org.junit.Test;
import fil.coo.action.F_scheduler;
import fil.coo.action.Scheduler;
import fil.coo.action.SchedulerTest;
import fil.coo.action.Action.Status;
import fil.coo.piscine.Basket;
import fil.coo.piscine.BasketPool;
import fil.coo.piscine.ResourceAction;
import fil.coo.piscine.ResourcePool;
import fil.coo.piscine.ResourceUser;
import fil.coo.piscine.TakeResourceAction;
import junit.framework.TestCase;

public class TakeActionTest extends ResourceActionTest {
	ResourceUser<Basket> ru1 = new ResourceUser<Basket>();
	ResourcePool rp = new BasketPool(1);
	ResourceAction ba = new TakeResourceAction("minmin", ru1, rp);
	ResourceAction bb = new TakeResourceAction("mimi", ru1, rp);
	Scheduler f = new F_scheduler();
	String mmm = "IN_PROGRESS";

	@Test
	public void testTakeResourceAction() {
		f.addAction(ba);
		f.addAction(bb);

		f.doStep();
		f.doStep();
		f.doStep();
		Status status = f.doStep();
		String sss = status.name().toString();
		assertEquals(sss, mmm);

	}
}
