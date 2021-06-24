/**
 * 
 */
package topquizbackend;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author keshavgovindaraju
 *
 */
public class InteractiveQuestion extends Question {

	private String imageFileName;
	private String [] choices;
	
	/**
	 * 
	 */
	public InteractiveQuestion() {
		super();
		this.setImageFileName("fourcorners_mod.jpg");
		this.choices = new String[4];
	}

	/**
	 * @param questionText
	 * @param correctAnswer
	 * @param score
	 */
	public InteractiveQuestion(String questionText, String correctAnswer, int score) {
		super(questionText, correctAnswer, score);
		this.imageFileName = "fourcorners_mod.jpg";
		this.choices = new String[4];
	}

	public InteractiveQuestion(String questionText, String correctAnswer, int score, String imageFileName,
			String choiceA, String choiceB, String choiceC, String choiceD) {
		super(questionText, correctAnswer, score);
		this.setImageFileName(imageFileName);
		this.choices = new String[4];
		this.choices[0] = choiceA;
		this.choices[1] = choiceB;
		this.choices[2] = choiceC;
		this.choices[3] = choiceD;
	}
	
	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * @return the choices
	 */
	public String[] getChoices() {
		return choices;
	}
	
	public String getSpecificChoice(int choice) {
		return choices[choice];
	}
	
	public ImageIcon getInteractiveQuestionImageIcon() {
		return new ImageIcon(this.getImageFileName());
	}
	
	public Image getInteractiveQuestionImage() {
		return new ImageIcon(this.getImageFileName()).getImage();
	}
}
