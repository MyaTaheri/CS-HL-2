package PDilemma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tab extends JFrame implements ActionListener{

    JLabel aLabel; 
    JTextArea aTextArea;
    JButton aButton, bButton;

    public Tab()
    {
        super("Multiple screens");
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JTabbedPane tPane = new JTabbedPane();
            tPane.setBounds(0,0,1000,450);
            JPanel panel1 = new JPanel();
                panel1.setLayout(null);
                panel1.setBackground(new Color(201, 155, 197));
                aButton = new JButton("aButton");
                aButton.addActionListener(this);
                aButton.setBounds(500, 100, 100,100);
                panel1.add(aButton);
                bButton = new JButton("clearButton");
                bButton.addActionListener(this);
                bButton.setBounds(350,100, 100,100);
                panel1.add(bButton);
            JPanel panel2 = new JPanel();
                panel2.setLayout(null);
                panel2.setBackground(new Color(125, 140, 181));
                aLabel = new JLabel ("a label :D");
                aLabel.setBounds(500, 100, 200, 100);
                panel2.add(aLabel);
                aTextArea = new  JTextArea(); //for the IA, have actual variables name (not aTextField but inputField)
                aTextArea.setBackground(Color.BLUE); //color of the background
                aTextArea.setForeground(Color.white); //color of the font
                aTextArea.setLineWrap(true);
                aTextArea.setText("helloooo");
                aTextArea.setBounds(100, 100, 300, 100);
                panel2.add(aTextArea);
        tPane.add("tab 1", panel1); //for IA, this will be the instruction page
        tPane.add("tab 2", panel2); //for IA, it is going to be a form/input data
        // tPane.add("tab 3", panel3); //for IA, table of all data
        // tPane.add("tab 4", panel4); //for IA, it is analysis tab

        //extra points for international minded (have a secondary language option)
        add(tPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("aButton"))
        {
            aLabel.setText("you clicked A button");
            aTextArea.setText("long phrase i wonder if they will fall off the screen. no more button for you");
            aButton.setEnabled(false);
        }
        if (e.getActionCommand().equals("clearButton"))
        {
            aTextArea.setText("");
        } 

        
    }
    
}
