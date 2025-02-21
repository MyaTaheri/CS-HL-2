package QueueAndStack;

public class Stack 
{
    String[] lunchLine = new String[5];

    public void pop() //out
    {
        if (lunchLine[0] == null)
        {
            System.out.println("line is empty");
        }
        else
        {
            for (int i = lunchLine.length -1; i > 0; i--)
            {
                if(lunchLine[i] != null)
                {
                    lunchLine[i] = null;
                    break;
                }
            }
        }
    }

    public void push(String name) //in
    {
        if (!isFull())
        {
            for (int i = 0; i < lunchLine.length; i++)
            {
                if(lunchLine[i] == null)
                {
                    lunchLine[i] = name;
                    break;
                }
            }
        }
        else   
            System.out.println("line is full!");
    }

    public void peek() //see who is next being served? (last non empty)
    {
        if (lunchLine[0] == null)
        {
            System.out.println("line is empty");
        }
        else
        {
            for (int i = lunchLine.length - 1; i >= 0; i--)
            {
                if(lunchLine[i] != null)
                {
                    System.out.println(lunchLine[i]);
                    break;
                }
            }
        }
            
    }

    public boolean isFull()
    {
        if (lunchLine[4] == null)
            return false;
        else
            return true;
    }

    public void printList()
    {
        for (int i = 0; i < lunchLine.length; i++)
        {
            if (lunchLine[i] == null)
                System.out.print("[empty] ");
            else
                System.out.print (lunchLine[i] + " ");
        }
        System.out.println("");
    }
    
}
