package QueueAndStack;

import java.security.cert.X509CRL;
import java.util.Scanner;

public class QueueAndStackDriver 
{
    public static void main (String[] args)
    {
        //object methods, control a que or stack
        System.out.println("----------------------------");
        Scanner kb = new Scanner (System.in);
        System.out.println("Dear Lunch Lady, do you want to use a stack or queue?");
        String answer = kb.next();
        System.out.println("How long can the line be?");
        int length = kb.nextInt();
        if (answer.equalsIgnoreCase("queue"))
        {
            Queue list = new Queue(length);
            int x = -1;
            while (x!= 7)
            {
                System.out.println("Please select the following: ");
                System.out.println ("1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.println("3. To peek at front");
                System.out.println("4. Is the line full?");
                System.out.println("5. Print out list");
                System.out.println("7. End of the day");
                x = kb.nextInt();
                if (x == 1)
                {
                    System.out.print("Enter name: ");
                    list.enqueue(kb.next());
                }
                    
                else if (x == 2)
                    list.dequeue();
                else if (x == 3)
                    list.peek();
                else if (x == 4)
                    if (list.isFull())
                        System.out.println("line is full!");
                    else
                        System.out.println("line is not full!");
                else if (x == 5)
                    list.printList();
                else if (x != 7)
                    System.out.println ("invalid number");
                System.out.println("----------------------------");
            }
        }
        if (answer.equalsIgnoreCase("stack"))
        {
            Stack list = new Stack(length);
            int x = -1;
            while (x!= 7)
            {
                System.out.println("Please select the following: ");
                System.out.println ("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. To peek at front");
                System.out.println("4. Is the line full?");
                System.out.println("5. Print out list");
                System.out.println("7. End of the day");
                x = kb.nextInt();
                if (x == 1)
                {
                    System.out.print("Enter name: ");
                    list.push(kb.next());
                }
                else if (x == 2)
                    list.pop();
                else if (x == 3)
                    list.peek();
                else if (x == 4)
                    if (list.isFull())
                        System.out.println("line is full!");
                    else
                        System.out.println("line is not full!");
                else if (x == 5)
                    list.printList();
                else if (x != 7)
                    System.out.println ("invalid number");
                System.out.println("----------------------------");
            }
        }
    }
    
}
