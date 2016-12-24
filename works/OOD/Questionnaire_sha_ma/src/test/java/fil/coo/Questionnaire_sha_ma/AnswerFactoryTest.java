package fil.coo.Questionnaire_sha_ma;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnswerFactoryTest {
    AnswerFactory af=new AnswerFactory();
    StringAnswer k=new StringAnswer("");
    Numerique t=new Numerique(678);
    YesNoAnswer y=new YesNoAnswer("");
	@Test
	public void testStringAnswer() {
		StringAnswer ans=(StringAnswer) af.buildAnswer("aaaa");
		k=ans;
		assertEquals(k,ans);
	}
	public void tesetNumeriqueAnswer(){
		Numerique ans=(Numerique) af.buildAnswer("555");
		t=ans;
		assertEquals(t,ans);
	}
	public void tesetYesNoAnswer(){
		YesNoAnswer ans=(YesNoAnswer) af.buildAnswer("555");
		y=ans;
		assertEquals(y,ans);
	}
	
}
