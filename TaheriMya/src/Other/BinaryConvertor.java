
import java.util.Scanner;

public class BinaryConvertor 
{
    public static void main (String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a number in base 10: ");
        int base10 = scnr.nextInt();
        System.out.println("Binary: " + convertBinary(base10));

    }
   
    public static String convertBinary(int baseTen)
    {
        // return Integer.toBinaryString(baseTen);
        String s = "";
        while (baseTen > 0)
        {
            if ((baseTen % 2 ) == 0)
                s = 0 + s;
            else
                s = 1 + s;
            baseTen = baseTen / 2;
        }
        return s;
    }
    
}
