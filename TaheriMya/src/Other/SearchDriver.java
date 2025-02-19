import java.util.Scanner;

public class SearchDriver {
    public static void main (String[] args)
    {
        //make a 100 spot array that holds integers 
        int[] numbers = new int [100];
        //fill that array with the numbers 1 through 100
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i+1;
        }
        //make instantce of the search class with that array as argument
        Search search1 = new Search(numbers);

        Scanner kb = new Scanner (System.in);

    
        System.out.println("--------------------------------------------");
        search1.setPrintArray();
        System.out.println("--------------------------------------------");
        System.out.print("Enter number you want to find with Binary Search: ");
        int location = search1.getBinarySearch(kb.nextInt());
        System.out.println("I found that number at index " + location);
        System.out.println("--------------------------------------------");
        search1.setShuffle();
        System.out.println("--------------------------------------------");
        System.out.print("Enter number you want to find with Linear Search: ");
        location = search1.getLinearSearch(kb.nextInt());
        System.out.println("I found that number at index " + location);
        System.out.println("--------------------------------------------");
        System.out.print("Enter number you want to find with random searching: ");
        int counter = search1.getBogoSearch(kb.nextInt());
        System.out.println("I found that number with " + counter + " searches");
        System.out.println("--------------------------------------------");
    }
    
}
