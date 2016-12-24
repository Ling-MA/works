package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringAnswerTest {

	StringAnswer ans=new StringAnswer("sss");
	   String k;
	   String a="StringAnswer";
		@Test
		public void testNumerique() {
	        k=ans.getType();
	        k.toString();
	        assertEquals(k,a);
	        
		}

}
