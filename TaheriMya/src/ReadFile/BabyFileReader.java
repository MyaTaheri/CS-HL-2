package ReadFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.*;

import javax.swing.*;
import java.awt.*;

public class BabyFileReader 
{
    public static void main(String[] args)
    {
        String line = "";
        String splitBy = ",";
        String name = "william";
        int counter = 0;
        try
        {
            File file = new File("/Users/mt25190/Desktop/CS-HL2-Projects/TaheriMya/bnames2007.csv");
            BufferedReader br = new BufferedReader(new FileReader (file));
            System.out.println(br.readLine());
            while ((line = br.readLine()) != null)
            {
                // System.out.println(line);
                String[] info = line.split(splitBy);
                // System.out.println(info[1]);
                if (info[1].equalsIgnoreCase(name))
                    counter += Integer.parseInt(info[4]);
            }
            System.out.println("Name amount: " + counter);
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
}
