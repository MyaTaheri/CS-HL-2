import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlantGui  extends JFrame implements ActionListener
{
    
    public PlantGui()
    {
        super("Water Plant Tracker");
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JTabbedPane tPane = new JTabbedPane();
            tPane.setBounds(0,0,1000,450);
            InstructionPanel panel1 = new InstructionPanel();
            // JPanel panel1 = new JPanel();
            //     panel1.setLayout(null);
            //     panel1.setBackground(new Color(201, 155, 197));
            JPanel panel2 = new JPanel();
                panel2.setLayout(null);
                panel2.setBackground(new Color(125, 140, 181));
            JPanel panel3 = new JPanel();
                panel3.setLayout(null);
                panel3.setBackground(new Color(125, 140, 181));
            JPanel panel4 = new JPanel();
                panel4.setLayout(null);
                panel4.setBackground(new Color(125, 140, 181));
        tPane.add("tab 1", panel1); //for IA, this will be the instruction page
        tPane.add("tab 2", panel2); //for IA, it is going to be a form/input data
        tPane.add("tab 3", panel3); //for IA, table of all data, can sort and delete dead plants
        tPane.add("tab 4", panel4); //for IA, inserts schedule, creates a watering schedule

        //extra points for international minded (have a secondary language option) 
        //read another file to search for a plant and import its scientific name and it will have its watering schedule
        //2 clinets can use this at the same time
        add(tPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
