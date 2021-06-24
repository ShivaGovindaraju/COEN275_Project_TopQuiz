/**
 * 
 */
package topquizbackend;

import java.util.*;

/**
 * @author keshavgovindaraju
 *
 */
public class ShortAnswerQuestion extends Question {
	private ArrayList<String> acceptableResponses;
	/**
	 * 
	 */
	public ShortAnswerQuestion() {
		super();
		this.acceptableResponses = new ArrayList<>();
	}

	/**
	 * @param questionText
	 * @param correctAnswer
	 * @param score
	 */
	public ShortAnswerQuestion(String questionText, String correctAnswer, int score) {
		super(questionText, correctAnswer, score);
		this.acceptableResponses = new ArrayList<>();
	}

	public ShortAnswerQuestion(String questionText, String correctAnswer, int score, ArrayList<String> acceptableResponses) {
		super(questionText, correctAnswer, score);
		this.acceptableResponses = acceptableResponses;
	}
	
	@Override
	public boolean isCorrectAnswer(String answer) {
		//answer.toLowerCase().contains(this.getCorrectAnswer().toLowerCase())
		//this.getCorrectAnswer().equalsIgnoreCase(answer)
		if (answer.toLowerCase().contains(this.getCorrectAnswer().toLowerCase())) {
			return true;
		} else if (this.acceptableResponses.isEmpty() == false) {
			for (String acceptable : acceptableResponses) {
				if(answer.toLowerCase().contains(acceptable.toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}
}
