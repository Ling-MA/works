package fil.coo.Questionnaire_sha_ma;


import java.util.ArrayList;

public  class Questionnaire {
ArrayList<Question>questions=new ArrayList();

public void addQuestion(Question q) {
   
	questions.add(q);

}
public String toString(){
	return questions+"";
	
	
}
 }