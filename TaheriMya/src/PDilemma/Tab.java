package PDilemma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tab extends JFrame implements ActionListener{

    JLabel aLabel; 

    public Tab()
    {
        super("Multiple screens");
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JTabbedPane tPane = new JTabbedPane();
            tPane.setBounds(0,0,1000,450);
            JPanel panel1 = new JPanel();
                panel1.setBackground(new Color(201, 155, 197));
                JButton aButton = new JButton("ABC");
                aButton.addActionListener(this);
                aButton.setBounds(500, 100, 100,100);
                panel1.add(aButton);
            JPanel panel2 = new JPanel();
                panel2.setBackground(new Color(125, 140, 181));
                aLabel = new JLabel ("a label :D");
                aLabel.setBounds(500, 100, 100, 100);
                panel2.add(aLabel);
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
        if (e.getActionCommand().equals("ABC"))
        {
            aLabel.setText("you clicked a button");
        }
        
    }
    
}
