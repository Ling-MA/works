package fil.coo.action;

import org.junit.Test;

import fil.coo.action.Action.Status;
import junit.framework.TestCase;

public class ForeseeableTest extends ActionTest {

	private Action a = new Foreseeable("minmin", "marche", 9);
	private String mm = "IN_PROGRESS";
	private String finished = "FINISHED";

	@Test
	public void testdoStep() {
		String ss = a.doStep().toString();
		assertEquals(ss, mm);
	}

	@Test
	public void testforesee() {
		Status s = Status.READY;
		while (a.status != Status.FINISHED) {
			s = a.doStep();
		}
		String l = s.name().toString();
		assertEquals(l, finished);

	}
}
