package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QuestionnaireTest {
ArrayList<Question>questions=new ArrayList();
Question q=new Question("hhh","hhh",5);
	@Test
	public void testaddQuestion() {
		questions.add(q);
		assertNotNull(questions);
	}

}
