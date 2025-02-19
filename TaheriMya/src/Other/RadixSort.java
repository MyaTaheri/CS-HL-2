import java.util.ArrayList;
import java.util.List;
public class RadixSort {
	public static void main(String[] args) {
       int[] arr = {170, 45, 75, 90, 802, 24, 2, 66, 123, 456};
       System.out.println("Initial array:");
       printArray(arr);
       System.out.println("Sorting process:");
       radix(arr);
       System.out.println("Final sorted array:");
       printArray(arr);
   }
	
   public static void radix(int[] arr) {
       if (arr == null || arr.length == 0) {
           return;
       }
       int maxNumber = getMax(arr);
       int numDigits = getNumDigits(maxNumber);
       int placeValue = 1;
       for (int i = 0; i < numDigits; i++) {
           countingSortByPlace(arr, placeValue);
           printArray(arr);
           placeValue *= 10;
       }
   }
   private static int getMax(int[] arr) {
       int max = arr[0];
       for (int num : arr) {
           if (num > max) {
               max = num;
           }
       }
       return max;
   }
   private static int getNumDigits(int number) {
       int count = 0;
       while (number != 0) {
           count++;
           number /= 10;
       }
       return count;
   }


   private static void countingSortByPlace(int[] arr, int placeValue) {
       int n = arr.length;
       int[] output = new int[n];
       int[] count = new int[10];


       for (int i = 0; i < n; i++) {
           int digit = (arr[i] / placeValue) % 10;
           count[digit]++;
       }


       for (int i = 1; i < 10; i++) {
           count[i] += count[i - 1];
       }


       for (int i = n - 1; i >= 0; i--) {
           int digit = (arr[i] / placeValue) % 10;
           output[count[digit] - 1] = arr[i];
           count[digit]--;
       }
       System.arraycopy(output, 0, arr, 0, n);
   }


   private static void printArray(int[] arr) {
       for (int num : arr) {
           System.out.print(num + " ");
       }
       System.out.println();
   }
}
