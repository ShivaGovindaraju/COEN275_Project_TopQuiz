/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;

/**
 *
 * @author ericpiacentini
 */
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

class QuestionTimer extends Thread {
  private static int DELAY = 250;
  private TopQuiz topquiz;

  private JProgressBar myQuestionTimer;
  private int currQuestion;

  public QuestionTimer(JProgressBar progBar, TopQuiz topquiz) {
    this.myQuestionTimer = progBar;
    this.topquiz = topquiz;
    this.currQuestion = this.topquiz.getQNum();
  }

  public void run() {
    int minimum = this.myQuestionTimer.getMinimum();
    int maximum = this.myQuestionTimer.getMaximum();
    this.myQuestionTimer.setValue(maximum);
    this.myQuestionTimer.setBounds(250, 15, 200, 50);

    for (int i = maximum; i > minimum; i--) {
      try {
        int value = this.myQuestionTimer.getValue();
        this.myQuestionTimer.setValue(value - 1);
        Thread.sleep(this.DELAY);
      } catch (InterruptedException ignoredException) {
      }
      
    }
    
    if(this.topquiz.getQNum() == this.currQuestion)
        this.topquiz.nextQuestion();
  }

}
