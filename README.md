# COEN275_Project_TopQuiz
SCU COEN 275 Object Oriented Design and Programming - Course Project - Top Quiz

Collaboration between [Shiva Govindaraju](https://github.com/ShivaGovindaraju "Shiva Govindaraju Github Profile") and [Eric Piacentini](https://github.com/epiacentini/TopQuizGame "Eric Piacentini Github Profile").

The Back-End was built by Shiva Govindaraju. The Front-End was built by Eric Piacentini.

TopQuiz is a Java Application developed with the intention of testing elementary-school 
students in the United States on their knowledge of United States History and Civics.
The application is intended for children around the ages of 8-10, and is poised to be 
relatively challenging, though still within the expectation that children should know 
basic facts about United States history and civics. Many of the questions in TopQuiz 
are in fact taken from sample questions given on U.S. Citizenship exams.

TopQuiz was implemented with multi-threading in order to add a Timer to each individual
question, so that the user cannot simply take forever to answer each question. If 
the user fails to answer the question in the time alloted, their result is taken as-is.  
TopQuiz also displays a list of previous users' scores and the times they completed
the quiz at the end of the Quiz, as a means of showing the quiz-taker how they rank
up against previous testers.

Notes:
-To run the TopQuiz application, please execute the TopQuiz executable. To do so,
run the main method in the TopQuiz.java file within the topquiz package.

-In the event that the question_bank.ser file is missing or malfunctional, please run 
the main method in the GenerateQuestionBank class. The  GenerateQuestionBank.java
file may be found in the topquizbackend package.

-Should the user wish to reset the list of displayed results, simply delete the file,
results.txt from the project in order to clear all previous-test results. When TopQuiz
is run after the deletion of results.txt, the completion of the quiz will generate a
new version of results.txt. Otherwise, all results will simply be concatenated to the
end of any existing results.txt existent within the Java project.
