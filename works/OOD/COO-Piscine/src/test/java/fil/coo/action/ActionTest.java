package fil.coo.action;
import org.junit.Test;
import junit.framework.TestCase;

public class ActionTest extends TestCase {

	private Action a = new Foreseeable("", "", 7);

	@Test
	public void testaction() {
		assertNotNull(a);
	}
}
