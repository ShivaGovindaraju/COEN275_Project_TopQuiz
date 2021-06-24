/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import topquizbackend.*;
/**
 *
 * @author ericpiacentini
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	
public class QuestionPanel extends gradientPanelBackground/*JPanel*/ implements ActionListener {
         private Question question;
         private TopQuiz topquiz;
        
         private JButton submit = new JButton("Submit");
	/*JPanel questionPanel = new gradientPanelBackground();

	JPanel submitPanel = new gradientPanelBackground();
	JButton submit = new JButton("Submit");
        
        JPanel headerPanel = new gradientPanelBackground();
        
        JLabel headerLabel = new JLabel();
        
        Font headerFont = new Font("Monospaced",Font.BOLD,30);
        Font questionFont = new Font("ZapfDingbats", Font.BOLD,15);*/
        
        //JPanel progressBarPanel = new gradientPanelBackground();
        
        //JProgressBar myProgBar = new JProgressBar(0, 120);
         
        public QuestionPanel(Question question, TopQuiz topquiz){
            this.topquiz = topquiz;
            this.question = question;
            
            JPanel questionPanel = new gradientPanelBackground();

            JPanel submitPanel = new gradientPanelBackground();
            //JButton submit = new JButton("Submit");

            JPanel headerPanel = new gradientPanelBackground();

            JLabel headerLabel = new JLabel();

            Font headerFont = new Font("Monospaced",Font.BOLD,30);
            Font questionFont = new Font("ZapfDingbats", Font.BOLD,15);
            
            JLabel questionLabel = new JLabel("Question " + topquiz.getQNum() + ": " + this.question.getQuestionText());
            questionLabel.setFont(questionFont);
            headerPanel.add(Box.createHorizontalGlue());
            headerLabel.setText("Top Quiz \t\t Test Taker: " + this.topquiz.getTesterName());
            headerLabel.setFont(headerFont);          
            headerPanel.add(headerLabel);

           // headerPanel.add(Box.createHorizontalGlue());
            JProgressBar myProgBar = new JProgressBar(0, 120);
            headerPanel.add(myProgBar);
            add(headerPanel);
            
            questionPanel.add(questionLabel);
            add(questionPanel);
            
            submitPanel.add(submit);
            submit.addActionListener(this);
            add(submitPanel);
            
            myProgBar.setStringPainted(false);
            Thread progress = new QuestionTimer(myProgBar,this.topquiz);
            progress.start();
        }
        
        public void actionPerformed(ActionEvent e){
		
        }
        
        public JButton getSubmitButton(){
            return this.submit;
        }
        
    
}
