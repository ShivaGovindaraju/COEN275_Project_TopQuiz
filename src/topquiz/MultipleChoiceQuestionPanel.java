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

	
public class MultipleChoiceQuestionPanel extends QuestionPanel {
        private MultipleChoiceQuestion MCQ;
	private TopQuiz topquiz;
        
       /* JPanel answersPanel = new gradientPanelBackground();
        ButtonGroup group = new ButtonGroup();
        JRadioButton [] responses;*/
        
        private String userResponse;
        private JRadioButton [] responses;
        
        public MultipleChoiceQuestionPanel(MultipleChoiceQuestion MCQ, TopQuiz topquiz){
            super(MCQ,topquiz);
            this.MCQ = MCQ;
            this.topquiz = topquiz;
            
            JPanel answersPanel = new gradientPanelBackground();
            ButtonGroup group = new ButtonGroup();
            
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            answersPanel.add(Box.createVerticalGlue());
            this.responses = new JRadioButton[this.MCQ.getChoices().length];
            
		for(int i=0;i<this.MCQ.getChoices().length;++i){
			this.responses[i]=new JRadioButton(this.MCQ.getSpecificChoice(i));
			this.responses[i].addActionListener(this);
			//this.answersPanel.add(responses[i]);
                        answersPanel.add(responses[i]);
                        /*responses[i]=new JRadioButton(this.MCQ.getSpecificChoice(i));
			responses[i].addActionListener(this);
			answersPanel.add(responses[i]);
                        responses[i].setHorizontalAlignment(SwingConstants.CENTER);*/
                        group.add(responses[i]);
		}
               
		//add(this.answersPanel);
                add(answersPanel);
        }
         
        @Override
        public void actionPerformed(ActionEvent e){
		Object src=e.getSource();                
                int selected = -1;
                
                for (int i = 0; i < this.MCQ.getChoices().length; i++){
                    if(src == this.responses[i]){
                        selected = i;
                    }
                }
                if(src instanceof JRadioButton) {
                    this.userResponse = ((JRadioButton) src).getText();
                }
                
                if(src == this.getSubmitButton()){
                    if(this.MCQ.isCorrectAnswer(this.userResponse)) {
                        this.topquiz.quizBank.addPoints(this.MCQ.getScore());
                    }
                    this.topquiz.nextQuestion();
                }
        }
        
    
}
