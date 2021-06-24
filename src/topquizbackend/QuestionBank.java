/**
 * 
 */
package topquizbackend;

import java.io.*;
import java.util.*;
import java.time.*;

/**
 * @author keshavgovindaraju
 *
 */
public class QuestionBank {
	private ArrayList<Question> bank;
	private int currentScore;
	/**
	 * 
	 */
	public QuestionBank() {
		this.bank = new ArrayList<>();
		this.currentScore = 0;
		//this.populateQuestionBank("question_bank.ser");
		//Collections.shuffle(bank);
	}
	
	public QuestionBank(String filename) {
		this.bank = new ArrayList<>();
		this.currentScore = 0;
		this.populateQuestionBank(filename);
		Collections.shuffle(this.bank);
	}

	/**
	 * @return the currentScore
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * @return the bank
	 */
	public ArrayList<Question> getBank() {
		return bank;
	}

	/**
	 * @param currentScore the currentScore to set
	 */
	public void setCurrentScore(int currentScore) {
		if (currentScore < 0) {
			System.out.println("[QuestionBank] Error: Cannot set CurrentScore to negative value.");
			return;
		}
		this.currentScore = currentScore;
	}

	public void addPoints(int points) {
		if(points < 0) {
			System.out.println("[QuestionBank] Error: Cannot add negative points to CurrentScore.");
			return;
		}
		this.currentScore = this.currentScore + points;
	}
	
	public void addNewQuestion(Question newQuestion) {
		this.bank.add(newQuestion);
	}
	
	public Question popQuestion() {
		if (this.bank.isEmpty()) {
			System.out.println("[QuestionBank] Error: Question Bank is Empty - Cannot pop Question from bank.");
			return null;
		}
		return this.bank.remove(0);
	}

	public void populateQuestionBank(String filename) {
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream input = new ObjectInputStream(file);
			
			this.bank = (ArrayList<Question>)input.readObject();
			
			input.close();
			file.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		} catch (ClassNotFoundException cnfex) {
			System.out.println("[QuestionBank] ClassNotFoundException: Caught.");
			cnfex.printStackTrace();
		}
	}
	
	public void storeQuestionBank(String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream output = new ObjectOutputStream(file);
			
			output.writeObject(this.bank);
			
			output.close();
			file.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		}
	}
        
        public void storeQuizResult(String filename, String testerName, LocalDateTime currentTime) {
            try {
			PrintWriter file = new PrintWriter(new FileWriter(filename, true));
                        
                        
                        String outputResult = testerName + "\t" + this.getCurrentScore() 
                                                    + "\t" + currentTime;
			file.println(outputResult);
			file.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		}
        }
        
        public ArrayList<String> retrieveQuizResults(String filename) {
            ArrayList<String> results = new ArrayList<>();
            try {
			//FileInputStream file = new FileInputStream(filename);
			//ObjectInputStream input = new ObjectInputStream(file);
			//this.bank = (ArrayList<Question>)input.readObject();
			BufferedReader br = new BufferedReader(new FileReader(filename));
                        String line = br.readLine();
                        while (line != null) {
                            results.add(line);
                            line = br.readLine();
                        }
                        br.close();
                        
			//input.close();
			//file.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		} /*catch (ClassNotFoundException cnfex) {
			System.out.println("[QuestionBank] ClassNotFoundException: Caught.");
			cnfex.printStackTrace();
		}*/
            return results;
        } 
}
