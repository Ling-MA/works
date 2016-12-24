package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnswerTest {
   
	
	Answer ans=new StringAnswer("sss");
	   String k;
	   String a="StringAnswer";
		@Test
		public void testAnswerisStringAnswer() {
	        k=ans.getType();
	        k.toString();
	        assertEquals(k,a);
	        
		}

}
