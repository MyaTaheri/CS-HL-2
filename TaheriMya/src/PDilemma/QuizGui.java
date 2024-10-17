package PDilemma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.*;
import java.awt.*;

public class QuizGui  extends JFrame implements ActionListener
{
    JLabel questionLabel; 
    JTextField inputField;
    JTable table;
    JButton submitButton;

    private int currentQuestionNum = 1;

    private String[] colNames = {"question number", "question", "correct answer", "student answer", "result"};
    private String[][] compiledData = new String[10][5]; //questions, answer, student answer, student result
    String[] triviaQuestions = {
        "What is the capital of France?", 
        "Who wrote 'To Kill a Mockingbird'?", 
        "What is the biggest planet in the solar system?",
        "Who painted the Mona Lisa?", 
        "What is the twelth element on the periodic table?", 
        "In what year did World War II end?",
        "Who is the shortest Meridian teacher?", 
        "What is the largest mammal?", 
        "Who discovered penicillin?",
        "What is the square root of 64?"
    };

    String[] triviaAnswers = {
        "Paris",
        "Harper Lee",
        "Jupiter",
        "Leonardo da Vinci",
        "Carbon",
        "1945",
        "Snyder",
        "blue whale",
        "Alexander Fleming",
        "8"
    };

    private Color lightGreen = new Color(174, 209, 188);
    private Color lightPurple = new Color(187, 174, 209);
    private Color lightBlue = new Color(174, 177, 209);

    public QuizGui()
    {
        super("quiz gui!");

        for (int i = 0; i < triviaQuestions.length; i++) {
            compiledData[i][0] = Integer.toString(i + 1);
            compiledData[i][1] = triviaQuestions[i];
            compiledData[i][2] = triviaAnswers[i];
        }
        
            setSize(750,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            JTabbedPane tPane = new JTabbedPane();
                tPane.setBounds(0,0,750,450);
                JPanel instructionPanel = new JPanel();
                    instructionPanel.setBackground(lightGreen);
                    JTextArea instructionText = new JTextArea();
                    instructionText.setText("Welcome to the Random Trivia Quiz! You will be asked 10 random trivia questions. For each question, select or type your answer and press submit. After each submission, you will know if your answer was correct or incorrect, and your results will be recorded in a table.");
                    instructionText.setEditable(false);
                    instructionText.setBounds(5,5,695, 145);
                    instructionText.setBackground(lightGreen);
                    instructionText.setFont(new Font("serif", Font.PLAIN, 18));
                    instructionText.setLineWrap(true);
                    instructionPanel.add(instructionText);
                
                JPanel quizPanel = new JPanel();
                    quizPanel.setBackground(lightPurple);
                    questionLabel = new JLabel(compiledData[0][1]);
                    questionLabel.setBounds(5,5, 200, 10);
                    quizPanel.add(questionLabel);
                    inputField = new JTextField(" ", 15); //TOOD; is this the best way to make it longer w/ columns?
                    inputField.setBounds(205,5,150, 100);
                    quizPanel.add(inputField);
                    submitButton = new JButton("check answer");
                    submitButton.addActionListener(this);
                    submitButton.setBounds(500,0, 100, 50);
                    quizPanel.add(submitButton);
                
                JPanel resultsPanel = new JPanel();
                    resultsPanel.setBackground(lightBlue);
                    table = new JTable(compiledData,colNames);
                    JScrollPane tablePane = new JScrollPane(table);
                    tablePane.setPreferredSize(new Dimension(600, 400));
                    tablePane.setForeground(Color.black);
                    resultsPanel.add(tablePane);
                    JButton saveButton = new JButton("save file");
                    saveButton.addActionListener(this);
                    saveButton.setBounds(650, 0, 100, 50);
                    resultsPanel.add(saveButton);
                
            tPane.add("instructions", instructionPanel); 
            tPane.add("quiz", quizPanel); 
            tPane.add("results", resultsPanel);
            add(tPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("check answer"))
        {
            String studentAnswer = inputField.getText();
            if (studentAnswer.startsWith("incorrect") || studentAnswer.equals(" "))
                studentAnswer = "no answer";
            compiledData[currentQuestionNum -1][3] = studentAnswer;
            
            if (studentAnswer.equalsIgnoreCase(compiledData[currentQuestionNum - 1][2]))
            {
                compiledData[currentQuestionNum -1][4] = "correct";
                inputField.setText("correct!");
            }
            else
            {
                compiledData[currentQuestionNum -1][4] = "incorrect";
                inputField.setText("incorrect, correct answer: " + compiledData[currentQuestionNum - 1][2]);
            }

            if (currentQuestionNum < 10)
            {
                questionLabel.setText(compiledData[currentQuestionNum][1]);
                currentQuestionNum++;
            }
               
            else
            {
                submitButton.setEnabled(false);
                inputField.setEditable(false);
                questionLabel.setText("quiz complete! check out your results in the next tab");
            }
        }  
        if (e.getActionCommand().equals("save file"))
        {

            PrintWriter outputStream = null;
            try
            {
                File file = new File("/Users/mt25190/Desktop/CS-HL2-Projects/TaheriMya/src/quizData.txt");
                outputStream = new PrintWriter(new FileOutputStream(file, false));
                outputStream.println("");
                outputStream.close(); 

                outputStream = new PrintWriter(new FileOutputStream(file, true));
                outputStream.println("Question Number, Question, Correct Answer, Student Answer, Result \n");

                for (int i = 0; i < compiledData.length; i++) {
                    outputStream.println(compiledData[i][0] + ", " + compiledData[i][1] + ", " + compiledData[i][2] + ", " + compiledData[i][3] + ", " + compiledData[i][4]);
                }
                
                outputStream.close(); 
            }
            catch(FileNotFoundException err)
            {
                System.out.println("file not found");
                System.exit(0);
            }
            
        }
    }
}

