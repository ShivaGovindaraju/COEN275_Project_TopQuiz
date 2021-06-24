/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import topquizbackend.*;
/**
 *
 * @author ericpiacentini
 */
public class InteractiveQuestionPanel extends QuestionPanel {
        private InteractiveQuestion IAQ;
	private TopQuiz topquiz;
        private String userResponse;
        
        public InteractiveQuestionPanel(InteractiveQuestion IAQ, TopQuiz topquiz){
            super(IAQ,topquiz);
            this.IAQ = IAQ;
            this.topquiz = topquiz;
            this.userResponse = "";
            
            JPanel answersPanel = new gradientPanelBackground();
            //answersPanel.setPreferredSize(new Dimension(800,600));
            
            ImageIcon fourcorners = new ImageIcon(getClass().getResource("fourcorners_mod.jpg"));
            JLabel imageLabel = new JLabel(fourcorners);

            answersPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                      int x = e.getX();
                      int y = e.getY();                    
                      
                      //System.out.println("x: " + x + " y: " + y);
                      
                      if(x < 150 && y < 183){
                        System.out.println("Utah");
                         userResponse = "North-West";  
                         imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_Utah.jpg")));
                         imageLabel.repaint();
                      }
                      else if(x > 150 && y < 183){
                         userResponse = "North-East";
                         imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_Colorado.jpg")));
                         imageLabel.repaint();
                      }
                      else if(x < 150 && y > 183){
                         userResponse = "South-West";
                         imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_Arizona.jpg")));
                         imageLabel.repaint();
                      }
                       else if (x > 150 && y > 183){
                         userResponse = "South-East";
                        imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_NewMexico.jpg")));
                        imageLabel.repaint();
                       }
                }

            });
            
            answersPanel.add(imageLabel);
            add(answersPanel);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
                Object src=e.getSource();
                if(src == this.getSubmitButton()){
                    if(this.IAQ.isCorrectAnswer(this.userResponse)) {
                        this.topquiz.quizBank.addPoints(this.IAQ.getScore());
                    }
                    this.topquiz.nextQuestion();
        }
       
    }
}
