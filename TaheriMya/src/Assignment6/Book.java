package Assignment6;

import java.awt.*;
import javax.swing.*;

public class Book 
{
    private String title;
    private int numberOfPages;
    private boolean haveRead;

    public Book (String title, int numberOfPages, boolean haveRead)
    {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.haveRead = haveRead;
    }

    public Book()
    {
        setTitle();
        setNumberOfPages();
        setHaveRead();
    }
    
    private void setNumberOfPages() 
    {
        this.numberOfPages = Integer.parseInt(JOptionPane.showInputDialog("Number of Pages?"));
    }

    private void setTitle() 
    {
        this.title = JOptionPane.showInputDialog("Title?");
    }

    private void setHaveRead() 
    {
        this.haveRead = Boolean.parseBoolean(JOptionPane.showInputDialog("Have you read it? Answer as a boolean."));
    }

    public String getTitle()
    {
        return title;
    }

    public int getNumberOfPages()
    {
        return numberOfPages;
    }

    public Boolean getHaveRead()
    {
        return haveRead;
    }

}
