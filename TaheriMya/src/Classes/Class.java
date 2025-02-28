package Classes;

import java.util.ArrayList;

public class Class {

	int rows = 2;
	private String[][] chart = new String[rows][2];
	private String course;
	private int studentsEnrolled = 0;
	private ArrayList<String> waitList = new ArrayList<String>();

	public Class(String course)
	{
		this.course = course;
	}

	public void addStudent(String name)
    {
        if (studentsEnrolled < (chart.length * chart[0].length))
        {
            for (int i = 0; i < chart.length; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    if (chart[i][j] == null)
                    {
                        chart[i][j] = name;
                        studentsEnrolled++;
                        return;  // exit once student is added
                    }
                }
            }
        }
        else
        {
            System.out.println("Class is full. Adding to waitlist...");
            addToWaitlist(name);
        }
    }

	public void removeStudent(String name)
    {
        for (int i = 0; i < chart.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if (chart[i][j] != null && chart[i][j].equals(name))
                {
                    chart[i][j] = null;
                    studentsEnrolled--;

                    if (waitList.size() > 0)
                    {
                        chart[i][j] = waitList.get(0);
                        waitList.remove(0);
                        System.out.println("Enrolled waitlisted student: " + chart[i][j]);
                    }
                    return;
                }
            }
        }
        System.out.println("Student not found in class.");
    }

    public void printNames()
    {
		for (int i = 0; i < chart.length; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (chart[i][j] == null)
					System.out.print ("empty ");
				else
					System.out.print(chart[i][j] + " ");
			}
		}
		System.out.println();
    }

	public void printSeatingChart()
	{

		for (int i = 0; i < chart.length; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (chart[i][j] == null) {
					System.out.print("empty ");
				}
				else
					System.out.print(chart[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void addToWaitlist(String name)
	{
		waitList.add(name);
	}

}