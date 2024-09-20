package PDilemma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SplitOrSteal extends JFrame implements ActionListener{

    JComboBox person1cb;
    JComboBox person2cb;
    JLabel resultsLabel;
    private String[] choices = {"split","steal"};
    JButton submitButton;

    public SplitOrSteal()
    {
        super("$$$$");
        setSize(700,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
      
        JTabbedPane sPane = new JTabbedPane();
        sPane.setBounds(0,0,700,150);
        
        Color customGreen = new Color(129, 166, 123);
        Color customRed = new Color(219, 148, 143);
        Color customBlue = new Color(123, 144, 166);
        Color customYellow = new Color(226, 230, 197);

        JPanel panel1 = new JPanel();
            panel1.setBackground(customYellow);
            panel1.setLayout(null);
            JTextArea instructionText = new JTextArea();
            instructionText.setText("There are 2 players. Each will have 2 options, split or steal. \nIf both players choose split, they each get 100. \nIf both players choose steal, they both get 0 \nIf one chooses split and the other chooses steal, the one who steals recieves 250 while the one who chose splits recieves 0.");
            instructionText.setEditable(false);
            instructionText.setBounds(5,5,695, 145);
            instructionText.setLineWrap(true);
            panel1.add(instructionText);
        JPanel panel2 = new JPanel();
            panel2.setBackground(customRed);
            person1cb = new JComboBox<String>(choices);
            person1cb.setBounds(75, 15, 150, 50);
            panel2.add(person1cb);
        JPanel panel3 = new JPanel();
            panel3.setBackground(customBlue);
            person2cb = new JComboBox<String>(choices);
            person2cb.setBounds(75, 15, 150, 50);
            panel3.add(person2cb);
        JPanel panel4 = new JPanel();
            panel4.setBackground(customGreen);
            resultsLabel = new JLabel();
            submitButton = new JButton("Submit");
            submitButton.addActionListener(this);
            panel4.add(resultsLabel);
            panel4.add(submitButton);

            
        sPane.add("instructions", panel1); 
        sPane.add("player 1", panel2); 
        sPane.add("player 2", panel3); 
        sPane.add("results", panel4); 
        
        add(sPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Submit"))
        {
            String person1 = (String)person1cb.getSelectedItem();
            String person2 = (String)person2cb.getSelectedItem();
            String result = "";

            System.out.println("debug");

            if (person1.equals("steal") && person2.equals("split"))
            {
                result = "Person 1 has 250 dollars while Person 2 has 0 dollars";
            }
            else if (person1.equals("split") && person1.equals("steal"))
            {
                result = "Person 1 has 0 dollars while Person 2 has 250 dollars";
            }
            else if (person1.equals("steal") && person1.equals("steal"))
            {
                result = "Person 1 has 0 dollars  while Person 2 has 0 dollars";
            }
            else 
            {
                result = "Person 1 has 100 dollars while Person 2 has 100 dollars";
            }
            resultsLabel.setText(result);
            submitButton.setEnabled(false);
        }
    }
    
}
