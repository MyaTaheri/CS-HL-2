package PDilemma;

import java.awt.*;
import javax.swing.*;

public class Colleges 
{
    //class variables or instance variables
    //class variables should typically always be private
    private int classSize;
    private String location;

    //2 Constructors

    public Colleges (String location, int classSize)
    {
        this.classSize = classSize;
        this.location = location;
    }

    public Colleges()
    {
        setLocation();
        setClassSize();
    }

    private void setClassSize() 
    {
        this.classSize = Integer.parseInt(JOptionPane.showInputDialog("Class Size?"));
    }

    private void setLocation() 
    {
        this.location = JOptionPane.showInputDialog("Location?");
    }

    public String getLocation()
    {
        return location;
    }

    public int getClassSize()
    {
        return classSize;
    }


}
