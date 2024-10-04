package PDilemma;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SavingFile 
{
    public static void main (String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Name a person: ");
        String answer = scnr.nextLine();
        PrintWriter outputStream = null;
        try
        {
            File file = new File ("/Users/mt25190/Desktop/CS-HL2-Projects/TaheriMya/names.txt");
            outputStream = new PrintWriter(new FileOutputStream(file, true)); // true means that it doesn't delete the old stuff in the txt file
        }
        catch(FileNotFoundException err)
        {
            System.out.println("File not found");
            System.exit(0);
        }
        outputStream.print("name: ");
        outputStream.println(answer);
        scnr.close();
        outputStream.close();

    }
    
}
