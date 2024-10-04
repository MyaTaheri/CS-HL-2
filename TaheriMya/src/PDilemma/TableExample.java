package PDilemma;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;


public class TableExample extends JFrame implements ActionListener 
{
    private String[] colNames = {"Customer", "order", "cooked", "age"};
    private String[][] data = {{"tate", "chicken wings", "deep fried", "17"},
                                {"Paige", "hamburger", "well-done", "18"},
                                {"adam", "salad", "dirt", "16"}};

    private JTable table;

    public TableExample()
    {
        super ("Table example");
        setSize (1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        table = new JTable(data,colNames);
            JScrollPane tablePane = new JScrollPane(table);
            tablePane.setBounds(100,100,400,200);
            table.setBackground(Color.black);
            table.setForeground(Color.white);
        add(tablePane);
        JButton changeButton = new JButton("change");
            changeButton.addActionListener(this);
            changeButton.setBounds(10, 10, 100, 50);
        add(changeButton);
    }

    public void actionPerformed (ActionEvent e)
    {
        if(e.getActionCommand().equals("change"))
        {
            System.out.print("test");
            if (table.getValueAt(0, 0).equals("tate"))
            {
                table.setValueAt("hot dog", 0, 1);
            }
        }
    }

    
}
