package fil.coo.pisine;
import org.junit.Test;
import fil.coo.piscine.Cubicle;
import fil.coo.piscine.Resource;
import junit.framework.TestCase;

public class CubicleTest extends ResourceTest {
	Resource c = new Cubicle();

	@Test
	public void testCubicle() {
		assertNotNull(c);
	}
}
