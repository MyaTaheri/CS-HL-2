package Classes;
import java.util.Scanner;

public class ClassesDriver 
{
    public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		Class calculus = new Class("Calculus");
		Class physics = new Class("Physics");
		int x = 0;
		while(x != 100)
		{
			System.out.println("Enter 1 for Calculus Class");
			System.out.println("Enter 2 for Physics Class");
			int pick = kb.nextInt();
			if(pick == 1)
			{
				System.out.println("Enter 3 to add student");
				System.out.println("Enter 4 to remove student");
				System.out.println("Enter 5 to print out names of students");
				System.out.println("Enter 6 to print out seating chart");
				System.out.println("Enter 7 to add to wait list");
				System.out.println("Enter 100 to END program");
				x = kb.nextInt();
				if(x == 3)
				{
					System.out.println("Enter name for student to add: ");
					calculus.addStudent(kb.next());
				}
                else if (x == 4)
                {
					System.out.println("Enter name for student to remove: ");
                    calculus.removeStudent(kb.next());
                }
                else if (x == 5)
                {
                    calculus.printNames();
                }
                else if (x == 6)
                {
                    calculus.printSeatingChart();
                }
			}
			else if(pick == 2)
			{
				System.out.println("Enter 3 to add student");
				System.out.println("Enter 4 to remove student");
				System.out.println("Enter 5 to print out names of students");
				System.out.println("Enter 6 to print out seating chart");
				System.out.println("Enter 7 to add to wait list");
				System.out.println("Enter 100 to END program");
				x = kb.nextInt();
				if(x == 3)
				{
					System.out.println("Enter name for student to add: ");
					physics.addStudent(kb.next());
				}
                else if (x == 4)
                {
					System.out.println("Enter name for student to remove: ");
                    physics.removeStudent(kb.next());
                }
                else if (x == 5)
                {
                    physics.printNames();
                }
                else if (x == 6)
                {
                    physics.printSeatingChart();
                }
			}
		}
	}
}



