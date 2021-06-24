/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import topquizbackend.*;
/**
 *
 * @author ericpiacentini
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	
public class ShortAnswerQuestionPanel extends QuestionPanel {
        private ShortAnswerQuestion SAQ;
	private TopQuiz topquiz;
        private String userResponse;
        
      /*  JPanel answersPanel = new gradientPanelBackground();
        JTextField answerTextField = new JTextField(20);*/
        private JTextField answerTextField = new JTextField(20);
        
        public ShortAnswerQuestionPanel(ShortAnswerQuestion SAQ, TopQuiz topquiz){
            super(SAQ,topquiz);
            this.SAQ = SAQ;
            this.topquiz = topquiz;
            
            JPanel answersPanel = new gradientPanelBackground();
            
            
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            answersPanel.add(answerTextField);
            //add(this.answersPanel);
            add(answersPanel);
           
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
                
                this.userResponse = this.answerTextField.getText();
                
                if(src == this.getSubmitButton()){
                    if (this.SAQ.isCorrectAnswer(userResponse)){
                        this.topquiz.quizBank.addPoints(this.SAQ.getScore());
                    }
                    this.topquiz.nextQuestion();
                }
        }
        
    
}
