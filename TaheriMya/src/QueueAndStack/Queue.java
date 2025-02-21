package QueueAndStack;

public class Queue 
{
    String[] lunchLine;

    public Queue(int length)
    {
        lunchLine = new String[length];
    }

    public void dequeue() //out
    {
        for (int i = 1; i < lunchLine.length - 1; i++)
        {
            String tempName = lunchLine[i];
            lunchLine[i-1] = tempName;
        }
        lunchLine[lunchLine.length - 1] = null;
    }
    
    public void enqueue(String name) //in
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

    public void peek() //who is in front / who is being served next
    {
        if (lunchLine[0] == null)
            System.out.println("line is empty");
        else
            System.out.println(lunchLine[0]);
    }

    public boolean isFull()
    {
        if (lunchLine[lunchLine.length - 1] == null)
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
