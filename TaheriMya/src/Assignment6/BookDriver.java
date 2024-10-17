package Assignment6;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;

public class BookDriver 
{
    public static void main (String[] args)
    {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book());
        bookList.add(new Book());
        bookList.add(new Book());
        bookList.add(new Book());

        for (int k = 0; k < bookList.size(); k++)
        {
            System.out.println("Book " + (k + 1) + ": ");
            System.out.println(bookList.get(k).getTitle());
            System.out.println(bookList.get(k).getNumberOfPages());
            System.out.println(bookList.get(k).getHaveRead());
            System.out.println("----------");
        }

        String bookChars = JOptionPane.showInputDialog("Of the three books, what characteristic would you like to search for?");
        System.out.println("Books that have " + bookChars + " are...");
        for (int k = 0; k < bookList.size(); k++)
        {
            if (bookList.get(k).getTitle().equalsIgnoreCase(bookChars) || bookList.get(k).getHaveRead() == Boolean.valueOf(bookChars) || bookList.get(k).getNumberOfPages() == Integer.parseInt(bookChars))
            {
                System.out.println(bookList.get(k).getTitle());
            }
        }

    }
    
}
