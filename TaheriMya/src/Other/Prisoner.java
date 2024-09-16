package Other;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import RockPaperScissor.RSP2;

import java.awt.*;

public class Prisoner extends JFrame implements ActionListener
{
    JComboBox person1cb;
    JComboBox person2cb;
    private JButton submitButton;
    private String[] choices = {"rat","don't rat"};
    private JLabel resultLabel;
    
    public Prisoner() {
		super("Prisoner");
		setSize(400,400);
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

        Color backgroundColor = new Color(168, 173, 179);
        Color fontColor = new Color (41, 77, 120);

        JLabel person1Label  = new JLabel("Person 1 decision:");
            person1Label.setBounds(40, 40, 750, 50);
            person1Label.setFont(new Font("Ariel", Font.PLAIN, 16));
            person1Label.setForeground(fontColor);
			add(person1Label);
        person1cb = new JComboBox<String>(choices);
            person1cb.setBounds(40, 70, 150, 50);
            add(person1cb);

        JLabel person2Label  = new JLabel("Person 2 decision:");
            person2Label.setBounds(210, 40, 750, 50);
            person2Label.setFont(new Font("Ariel", Font.PLAIN, 16));
            person2Label.setForeground(fontColor);
			add(person2Label);
        person2cb = new JComboBox<String>(choices);
            person2cb.setBounds(210, 70, 150, 50);
            add(person2cb);

        submitButton = new JButton("Submit");
            submitButton.setBounds(150, 140, 100, 50);
            submitButton.addActionListener(this);
            add(submitButton);

        resultLabel  = new JLabel("decisions to be made");
            resultLabel.setBounds(10, 200, 750, 50);
            resultLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            resultLabel.setForeground(fontColor);
			add(resultLabel);

        getContentPane().setBackground(backgroundColor);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Submit"))
        {
            String person1 = (String)person1cb.getSelectedItem();
            String person2 = (String)person2cb.getSelectedItem();
            String result = "";

            if (person1.equals("rat") && person2.equals("don't rat"))
            {
                result = "Person 1 has 2 years while Person 2 has 10 years";
            }
            else if (person1.equals("don't rat") && person1.equals("rat"))
            {
                result = "Person 1 has 10 years while Person 2 has 2 years";
            }
            else if (person1.equals("rat") && person1.equals("rat"))
            {
                result = "Person 1 has 5 years while Person 2 has 5 years";
            }
            else 
            {
                result = "Person 1 has 1 year while Person 2 has 1 year";
            }
            resultLabel.setText(result);

           
           
        }
    }

    public static void main(String[] args) {
		Prisoner prisoner = new Prisoner();
		prisoner.setVisible(true);	
	}

}
