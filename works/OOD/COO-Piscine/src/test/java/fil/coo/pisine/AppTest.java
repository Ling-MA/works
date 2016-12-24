package fil.coo.pisine;

import fil.coo.action.F_scheduler;
import fil.coo.action.Action.Status;
import fil.coo.piscine.App;
import fil.coo.piscine.BasketPool;
import fil.coo.piscine.CubiclePool;
import fil.coo.piscine.Swimmer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	BasketPool baskets = new BasketPool(6);
	CubiclePool cubicles = new CubiclePool(3);
	F_scheduler f = new F_scheduler();
	public void testAPP(){
	f.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
	f.addAction(new Swimmer("Lois",baskets, cubicles, 2, 10, 4));
	f.addAction(new Swimmer("Maé",baskets, cubicles, 10, 18, 10));
	f.addAction(new Swimmer("Angé",baskets, cubicles, 3, 7, 5));
	f.addAction(new Swimmer("Louison",baskets, cubicles, 18, 3, 3));
	f.addAction(new Swimmer("Charlie",baskets, cubicles, 3, 6, 10));
	f.addAction(new Swimmer("Alexis",baskets, cubicles, 6, 5, 7));
	int nbs = 0;

	while (f.doStep() != Status.FINISHED) {
		nbs++;
	}
    nbs=nbs+1;//il manque status finished;
	System.out.println("Finished in " + nbs + "steps");
	}
	
	
//   
//	/**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
	

   
    public void testfini()
    {
        assertTrue( true );
        
    }
}
