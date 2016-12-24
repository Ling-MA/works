package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionTest {
    Question q=new Question("How old are you","19",5);
    String textexpect="How old are you";
    String answerexpect="19";
    int pointexpect=5;
	@Test
	public void testgetText() {
		String text=q.getText();
		assertEquals(textexpect,text);
		
	}
	
	public void testgetAnswer(){
		String ans=q.getAnswer();
		assertEquals(answerexpect,ans);
	}
	public void testgetPoint(){
		int point=q.getPoint();
		assertEquals(pointexpect,point);
	}

}
