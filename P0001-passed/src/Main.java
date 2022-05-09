import java.io.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author ikariss
 */
public class Main {

    public static int getInt(String msg, String err, int min, int max) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Input must lie in the range [" + min + " - " + max + "]");

                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    // function to create an array base on given size
    /*
    public static int[] CreateArray(int n) {
        int[] array = new int[n];
        Random rd = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = rd.nextInt(n);
        }

        return array;
    }
*/
    
    public static int[] createArray(int n, int min, int max){
        
        // create a new array with size n
        int[] array = new int[n];
        
        // initialize random variable
        Random rd = new Random();
        
        // create random value elements for the array
        for (int i = 0; i < n; i++){
            array[i] = rd.nextInt(max - min) + min;
        }
        
        return array;
    }
            

    public static void display(int[] array, String msg) {
        System.out.println(msg);
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            // check index to display commas
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void BubbleSort(int[] array) {

        // loop used to traverse the array from the first element to the last
        // after each loop, one element is sorted
        for (int i = 0; i < array.length; i++) {

            // loop used to accessed the first unsorted element to the element 
            // stand before the last unsorted element
            for (int j = 0; j < array.length - i - 1; j++) {

                // compare adjacent elements
                if (array[j] > array[j + 1]) {

                    // swap array[j + 1] and array[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
        // ask the user for the size of the array - positive decimal
        int n = getInt("Enter the size of the array (positive decimal number): ", "Invalid input", 1, Integer.MAX_VALUE);

        // ask the user to enter the range of the array
        int l = getInt("Enter the lower bound of the array: ", "Invalid input", Integer.MIN_VALUE, Integer.MAX_VALUE);

        int u = getInt("Enter the upper bound of the array: ", "Invalid input", Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        // generate a random array with the input size
        int[] array = createArray(n, l, u);

        // display the array before sorting
        display(array, "\nUnsorted array: ");   

        // sort the array using bubble sort
        BubbleSort(array);

        // display the final array
        display(array, "\nArray after sorting: ");
    }

}
