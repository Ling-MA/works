package fil.coo.action;

import org.junit.Test;
import fil.coo.action.Action.Status;
import junit.framework.TestCase;

public class S_schedulerTest extends SchedulerTest {
	private Scheduler s = new S_scheduler();
	private String fd = "FINISHED";
	private Status statusf;

	@Test
	public void testFdoStep() {

		s.addAction(new Foreseeable("dd", "laugh", 9));
		s.addAction(new Foreseeable("ttt", "smile", 5));
		String fd1;
		while (statusf != Status.FINISHED) {
			statusf = s.doStep();
		}
		fd1 = statusf.name().toString();
		assertEquals(fd, fd1);
	}

}
