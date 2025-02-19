public class Search
{
    //class variables (global variables)
    private int[] array;

    public Search (int[] array)
    {
        this.array = array;
    }

    //setter method/mutator method: doesn't return something (void), it just assigns a value or changes smth
    public void setPrintArray()
    {
        //for (int x:array)
        // System.out.print(x + " ");
        for (int i = 0; i < this.array.length; i++)
        {
            System.out.print(this.array[i]+ " ");
        }
        System.out.println("");
    }

    public void setShuffle()
    {
        //take the bottom card and put it in a random spot and then  
        for (int i = array.length - 1; i > 0; i--)
        {
            int newSpot = (int)(Math.random() * i);
            int temp = array[i];
            array[i] = array [newSpot];
            array[newSpot] = temp;
        }

        setPrintArray();
    }

    public int getBinarySearch(int num)
    {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;

        while (array[middle] != num)
        {
            if (num > array[middle])
            {
                left = middle + 1;
            }
            if (array[middle] > num)
            {
                right = middle - 1;
            }
            middle = (left + right) / 2;
        }
        return middle  + 1;
    }

    //getter method/acessor method: returns a value
    public int getLinearSearch(int num)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] == num)
                return i + 1;
        }
        return 100;
    }

    public int getBogoSearch (int num)
    {
        int counter = 1;
        int tempValue = array[(int)(Math.random() * 100)];
        while (tempValue != num)
        {
            counter++;
            tempValue = array[(int)(Math.random() * 100)];
        }
        return counter;
    }
}
