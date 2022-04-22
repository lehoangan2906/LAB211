
import java.io.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author ikariss
 */
public class Main {

    //check user input a number integer
    private static int checkInputInt(int min, int max) {
        Scanner in = new Scanner(System.in);

        //loop until user input correct
        while (true) {
            try {
                int num = Integer.parseInt(in.nextLine().trim());
                if (min <= num && num <= max){
                    return num;
                }else{
                    System.out.println("Input must lie in the range [" + min + " - " + max + "]");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int[] getInputArray(int n) {
        // create new array with the input size
        int arr[] = new int[n];

        // ask the user to input every element of the array
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = checkInputInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return arr;
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

    public static void SelectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // find the minimum element in the unsorted array
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // swap the found minimum element with the first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        // ask the user for size of the array
        System.out.print("Enter the size of the array (positive integer): ");
        int n = checkInputInt(1, Integer.MAX_VALUE);

        //create a new array with size n
        int[] arr = getInputArray(n);

        // display the unsorted array
        display(arr, "\nUnsorted array: ");

        // perform selection sort on the array
        SelectionSort(arr);

        //display the sorted array
        display(arr, "\nSorted array: ");
    }

}
