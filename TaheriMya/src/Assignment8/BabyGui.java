package Assignment8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

import Assignment6.Book;

import java.awt.*;

public class BabyGui extends JFrame implements ActionListener
{
    String[][] recentSearchData = new String[5][2];
    private String[] colNames = {"Name", "Amount in 2007-2022"};
    private JTable studentTable;
    JComboBox sexComboBox;
    private String[] sexChoices = {"Any","Female","Male"};
    JTextField nameField;
    JButton sortTableButton, searchListButton, splitFileButton;
    ArrayList<Baby> babyList = new ArrayList<>();
 

    public BabyGui()
    {
        super("NY State Baby Names");
        setSize(730,230);
        getContentPane().setBackground(new Color(194, 187, 242));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        this.setResizable(true);

        sexComboBox = new JComboBox<String>(sexChoices);
        sexComboBox.setBounds(20, 20, 125, 25);
        add(sexComboBox);

        splitFileButton = new JButton("Split File");
        splitFileButton.addActionListener(this);
        splitFileButton.setBounds(160, 17, 125, 30);
        add(splitFileButton);

        searchListButton = new JButton("Search List");
        searchListButton.addActionListener(this);
        searchListButton.setBounds(160, 62, 125, 30);
        searchListButton.setEnabled(false);
        add(searchListButton);

        sortTableButton = new JButton("Sort Table");
        sortTableButton.addActionListener(this);
        sortTableButton.setBounds(160, 107, 125, 30);
        sortTableButton.setEnabled(false);
        add(sortTableButton);

        JLabel nameSearchLabel = new JLabel("What name would you like to search?");
        nameSearchLabel.setBounds(300, 17, 250, 30);
        add(nameSearchLabel);

        nameField = new JTextField();
        nameField.setBounds(565, 17, 150, 30);
        add(nameField);


        studentTable = new JTable(recentSearchData, colNames);
        JScrollPane tablePane = new JScrollPane(studentTable);
        tablePane.setBounds(300, 62, 350, 100);
        studentTable.setBackground(new Color(49, 51, 97));
        studentTable.setForeground(Color.white);
        add(tablePane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Split File"))
        {
            searchListButton.setEnabled(true);
            sortTableButton.setEnabled(true);
            splitFileButton.setEnabled(false);

            String line = "";
            String splitBy = ",";
            try
            {
                File file = new File("/Users/mt25190/Desktop/CS-HL2-Projects/TaheriMya/bnames2007.csv");
                BufferedReader br = new BufferedReader(new FileReader (file));
                System.out.println(br.readLine());

                while ((line = br.readLine()) != null) {
                    String[] info = line.split(splitBy);
                    String name = info[1];
                    char sex = info[3].charAt(0);
                    int numToInc = Integer.parseInt(info[4]);
                    
                    boolean found = false;  
            
                    for (int i = 0; i < babyList.size(); i++) {
                        if (babyList.get(i).getName().equalsIgnoreCase(name) && babyList.get(i).getSex() == sex) {
                            babyList.get(i).increaseNumOfName(numToInc);
                            found = true;
                            break;
                        }
                    }
            
                    if (!found) {
                        int numOfName = numToInc; 
                        babyList.add(new Baby(name, sex, numOfName));
                    }
                }
            }
            catch(IOException | NumberFormatException err)
            {
                err.printStackTrace();
            }

            //TESTING
            // for (Baby baby : babyList) {
            //     System.out.println(baby.getName() + ", " + baby.getSex() + ", " + baby.getNumOfName());
            // }
        }
        if (e.getActionCommand().equals("Search List"))
        {

            String name = nameField.getText();
            int numOfNames = 0;
            String sexSelected = (String)sexComboBox.getSelectedItem();
            System.out.println(sexSelected);
            char sexChar = 'A';
            String tableString = "";
            if (sexSelected.equals("Male"))
            {
                sexChar = 'M';
                tableString = name + " | Gender: " + "Male";
            }
            else if (sexSelected.equals("Female"))
            {
                sexChar = 'F';
                tableString = name + " | Gender: " + "Female";
            }
            else if (sexSelected.equals("Any"))
            {
                tableString = name + " | Gender: " + "Any";
            }
                

            for (int i = 0; i < babyList.size(); i++)
            {
                if (name.equalsIgnoreCase(babyList.get(i).getName()))
                {
                    if (sexChar == 'A')
                        numOfNames += babyList.get(i).getNumOfName();
                    if (sexChar == 'M' && babyList.get(i).getSex() == 'M')
                        numOfNames += babyList.get(i).getNumOfName();
                    if (sexChar == 'F' && babyList.get(i).getSex() == 'F')
                        numOfNames += babyList.get(i).getNumOfName();
                }
            }
            updateTable(tableString, numOfNames);
            System.out.println(name);
            System.out.println(numOfNames);

        }

        if (e.getActionCommand().equals("Sort Table"))
        {

        }
    }

    public void updateTable(String nameAndSex, int numOfName)
    {
        //not full table
        for (int i = 0; i < recentSearchData.length; i++) {
            if (recentSearchData[i][0] == null) { 
                recentSearchData[i][0] = nameAndSex;
                recentSearchData[i][1] = String.valueOf(numOfName);
                return; 
            }
        }
    
        //full table
        for (int i = 1; i < recentSearchData.length; i++) {
            recentSearchData[i - 1][0] = recentSearchData[i][0];
            recentSearchData[i - 1][1] = recentSearchData[i][1];
        }
    
        recentSearchData[4][0] = nameAndSex;
        recentSearchData[4][1] = String.valueOf(numOfName);
    }

}
