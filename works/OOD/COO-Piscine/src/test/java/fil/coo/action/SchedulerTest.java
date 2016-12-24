package fil.coo.action;

import org.junit.Test;
import junit.framework.TestCase;

public class SchedulerTest extends ActionTest {
	Scheduler s = new F_scheduler();

	@Test
	public void testScheduler() {
		assertNotNull(s);
	}
}
