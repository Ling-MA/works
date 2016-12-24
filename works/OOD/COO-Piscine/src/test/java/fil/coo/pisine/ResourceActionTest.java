package fil.coo.pisine;

import org.junit.Test;
import fil.coo.action.ActionTest;
import fil.coo.piscine.ResourceAction;
import fil.coo.piscine.TakeResourceAction;
import junit.framework.TestCase;

public class ResourceActionTest extends ActionTest {
	ResourceAction r = new TakeResourceAction("q", null, null);

	@Test
	public void testResourceAction() {
		assertNotNull(r);
	}
}
