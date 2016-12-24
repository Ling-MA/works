package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import org.junit.Test;

public class YesNoAnswerTest {

	YesNoAnswer ans=new YesNoAnswer("yes");
	   String k;
	   String a="YesNoAnswer";
		@Test
		public void testYesNoAnswerTest() {
	        k=ans.getType();
	        k.toString();
	        assertEquals(k,a);
	        
		}

}
