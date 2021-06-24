package topquiz;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.awt.Color;
import topquizbackend.*;

public class TopQuiz extends JFrame{
    
        private JPanel myPanel;
        private CardLayout cards;

        private String testerName;
        private int qNum;
        public static QuestionBank quizBank;
    
    public TopQuiz() {
        myPanel = new gradientPanelBackground();
        cards = new CardLayout();
        qNum = 0;
        quizBank = new QuestionBank("./question_bank.ser"/*  ENTER FILENAME HERE */);
    }
    
    public String getTesterName(){
        return testerName;
    }
    
    public int getQNum(){
        return qNum;
    }
       
    public static void main(String args[]){
	TopQuiz myQuiz = new TopQuiz();
        myQuiz.initQuiz();
    }
	
    public void initQuiz(){
	setSize(900, 600);
        setResizable(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.myPanel.setLayout(cards);
        
        JPanel startPanel = new gradientPanelBackground();
      
        startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.Y_AXIS));
        
        Font titleFont = new Font("Monospaced",Font.BOLD,50);
        Font nameFont = new Font("Monospaced",Font.BOLD,25);
        
        JLabel title = new JLabel("Top Quiz");
        JLabel nameLabel = new JLabel("Please Enter Your Name");
        nameLabel.setFont(nameFont);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        title.setFont(titleFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField nameTextField = new JTextField(20);

        nameTextField.setMaximumSize( nameTextField.getPreferredSize() );
        nameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton beginButton = new JButton("Begin Quiz");
        beginButton.setPreferredSize(new Dimension(70,70));
        beginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        startPanel.add(title);
        startPanel.add(Box.createVerticalGlue());
        startPanel.add(nameLabel);
        startPanel.add(nameTextField);
        startPanel.add(Box.createVerticalGlue());
        startPanel.add(beginButton);
        
        beginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testerName = nameTextField.getText();
                if(!testerName.isEmpty())
                    nextQuestion();
                
            }
        });
        
        this.myPanel.add(startPanel, "init");
        this.cards.show(this.myPanel,"init");
        

       add(this.myPanel);
       setVisible(true);
    }

    public void nextQuestion(){
        ++qNum;
        
        if(this.quizBank.getBank().isEmpty()) {
            this.showResults();
        } else {   
        Question newQuestion = quizBank.popQuestion();
        QuestionPanel newQPanel;
        
        if (newQuestion instanceof  MultipleChoiceQuestion) {
            newQPanel = new MultipleChoiceQuestionPanel((MultipleChoiceQuestion)newQuestion, this);
        } else if (newQuestion instanceof ShortAnswerQuestion) {
            newQPanel = new ShortAnswerQuestionPanel((ShortAnswerQuestion)newQuestion, this);
        } 
        else{
            newQPanel = new InteractiveQuestionPanel((InteractiveQuestion)newQuestion, this);
        }
         
        this.myPanel.add(newQPanel, "Question: " + qNum);
        this.cards.show(this.myPanel,"Question: " + qNum);

        }
    }
    
    public void showResults(){
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        JLabel date = new JLabel("Time Submitted: " + currentTime.toString());
        date.setFont(new Font("Monospaced",Font.BOLD,20));
        date.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel resultsPanel = new gradientPanelBackground();
        resultsPanel.setLayout(new BoxLayout(resultsPanel,BoxLayout.Y_AXIS));
        
        String resultMessage = "Congratulations " + testerName + "!";
        String scoreMessage = " You Scored " + this.quizBank.getCurrentScore() +
                                    " out of " + 350  + "!";
        JLabel result = new JLabel(resultMessage);
        result.setFont(new Font("Monospaced",Font.BOLD,30));
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel scoreResult = new JLabel(scoreMessage);
        scoreResult.setFont(new Font("Monospaced",Font.BOLD,30));
        scoreResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        resultsPanel.add(result);
        resultsPanel.add(scoreResult);
        resultsPanel.add(date);
        
        JButton retryButton = new JButton("Retry?");
        retryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultsPanel.add(retryButton);
        
        this.myPanel.add(resultsPanel,"Results");
        this.cards.show(this.myPanel,"Results");

        quizBank.storeQuizResult("results.txt", this.testerName, currentTime);
        
        ArrayList<String> allQuizResults = quizBank.retrieveQuizResults("results.txt");
        
        System.out.println("ending retrieval, displaying resutls");
        for(int i = 0; i < allQuizResults.size(); i++){
            String[] tester = allQuizResults.get(i).split("\t");
            String displayScore = (i+1) + " " + tester[0] + "\t" + "Score: " + tester[1] + "\t" + "Time: " + tester[2];
            JLabel scoreLabel = new JLabel(displayScore);
            scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultsPanel.add(scoreLabel);
        }
        
        retryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               TopQuiz myQuiz = new TopQuiz();
               myQuiz.initQuiz();
            }
        });
        
    }
} 
