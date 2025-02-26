package Classes;
import java.util.Scanner;

public class ClassesDriver 
{
    public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int turn = 0;
		Class calculus = new Class();
		Class physics = new Class();
		while(turn != 9)
		{
			System.out.println("Enter 1 for Calculus Class");
			System.out.println("Enter 2 for Physics Class");
			int pick = kb.nextInt();
			if(pick == 1)
			{
				System.out.println("Enter 3 to add student");
				System.out.println("Enter 4 to remove student");
				System.out.println("Enter 5 to names of students");
				System.out.println("Enter 6 to print out seating chart");
				System.out.println("Enter 7 to add to wait list");
				if(kb.nextInt() == 3)
				{
					calculus.addStudent();
				}
                else if (kb.nextInt() == 4)
                {
                    calculus.removeStudent();
                }
                else if (kb.nextInt() == 5)
                {
                    calculus.printNames();
                }
                else if (kb.nextInt() == 6)
                {
                    calculus.printSeatingChart();
                }
                else if (kb.nextInt() == 7)
                {
                    calculus.addToWaitlist();
                }
			}
			else if(pick == 2)
			{

			}
		}
	}
}



