/**
 * 
 */
package topquizbackend;

/**
 * @author keshavgovindaraju
 *
 */
public class MultipleChoiceQuestion extends Question {
	private String [] choices = new String[5];
	/**
	 * 
	 */
	public MultipleChoiceQuestion() {
		super();
	}

	/**
	 * @param questionText
	 * @param correctAnswer
	 * @param score
	 */
	public MultipleChoiceQuestion(String questionText, String correctAnswer, int score) {
		super(questionText, correctAnswer, score);
		choices = new String[5];
		//note, this constructor should not really be in use... but might be useful for testing purposes.
	}
        @Override
        public String getCorrectAnswer() {
		return super.getCorrectAnswer();
	}
	
	public MultipleChoiceQuestion(String questionText, String correctAnswer, int score, 
			String choiceA, String choiceB, String choiceC, String choiceD, String choiceE) {
		super(questionText, correctAnswer, score);
		choices[0] = choiceA;
		choices[1] = choiceB;
		choices[2] = choiceC;
		choices[3] = choiceD;
		choices[4] = choiceE;
	}
	
	public boolean isCorrectNumericAnswer(int answer) {
		if (answer < 0 || answer > 4) {
			System.out.println("[MultipleChoiceQuestion] Error: Answer given to question must be in range 0-4 inclusive. User attempted to enter " + answer + " to answer MultipleChoiceQuestion.");
			return false;
		}
		String letteranswer = Integer.toString('A' + answer);
		return this.isCorrectAnswer(letteranswer);
	}
	
        public String [] getChoices(){
            return choices;
        }
        
        public String getSpecificChoice(int choice) {
                return choices[choice];
        }
        
	public String getChoiceA() {
		return choices[0];
	}
	
	public String getChoiceB() {
		return choices[1];
	}
	
	public String getChoiceC() {
		return choices[2];
	}
	
	public String getChoiceD() {
		return choices[3];
	}
	
	public String getChoiceE() {
		return choices[4];
	}
}
