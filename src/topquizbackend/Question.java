/**
 * 
 */
package topquizbackend;

import java.io.*;

/**
 * @author keshavgovindaraju
 *
 */
public class Question implements Serializable {

	private String questionText;
	private String correctAnswer;
	private int score;
	/**
	 * 
	 */
	public Question() {
		questionText = "";
		correctAnswer = "";
		score = 0;
	}
	
	public Question(String questionText, String correctAnswer, int score) {
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
		this.score = score;
	}

	public boolean isCorrectAnswer(String answer) {
		return this.getCorrectAnswer().equalsIgnoreCase(answer);
	}
	
	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

}
