package fil.coo.pisine;
import org.junit.Test;
import fil.coo.piscine.Basket;
import fil.coo.piscine.Resource;
import junit.framework.TestCase;

public class BasketTest extends ResourceTest {

	Basket b=new Basket();
	@Test
public void testBasket(){
	assertNotNull(b);
}
}
