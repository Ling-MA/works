package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumeriqueAnswerTest {
   Numerique ans=new Numerique(5);
   int a;
	@Test
	public void testNumerique() {
        a=ans.getN();
        assertEquals(5,a);
	}

}
