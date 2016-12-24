package fil.coo.action;

import org.junit.Test;
import fil.coo.action.Action.Status;
import junit.framework.TestCase;

public class F_shedulerTest extends SchedulerTest {
	private Scheduler f = new F_scheduler();
	private String fd = "FINISHED";
	private Status statusf;

	@Test
	public void testFdoStep() {

		f.addAction(new Foreseeable("dd", "laugh", 9));
		f.addAction(new Foreseeable("ttt", "smile", 5));
		String fd1;
		while (statusf != Status.FINISHED) {
			statusf = f.doStep();
		}
		fd1 = statusf.name().toString();
		assertEquals(fd, fd1);
	}

}
