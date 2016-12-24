package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuestionaireFactoryTest {
	QuestionaireFactory qf=new  QuestionaireFactory();
	
	@Test
	public void TestcreatQuestion() throws IOException {
		Question q=qf.creatQuestion("how are you", "fine", "5");
 List questions=new ArrayList();
 questions.add(q);
	assertNotNull(questions);
	System.out.println(q);
	
	} 
	public void TestcreatQuestionnaire() throws IOException{
		Questionnaire questionnaire=new Questionnaire();
		questionnaire=qf.creatQuestionnaire("src/question_tolkien_2.txt");
		assertNotNull(questionnaire);
		System.out.println(questionnaire);
	}
	public void TestbuildAnswer(){
	String sa = "minmin";
	Answer ans=qf.buildAnswer("minmin");
	assertSame(sa,ans);
	}
	public void TestGetSetQuestions() throws Exception{
		Question q=qf.creatQuestion("how are you", "fine", "5");
		 List questions=new ArrayList();
		 questions.add(q);
		 List getquestions=new ArrayList();
		 qf.setQuestions((ArrayList<Question>) questions);
		 getquestions=qf.getQuestions();
		 assertNotNull(getquestions);
		 
	}
}