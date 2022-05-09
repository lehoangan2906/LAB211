
/**
 *
 * @author darkksilver
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ask the user for size of the array
        System.out.print("Enter the size of the array (positive integer): ");
        int n = Selectionsort.checkInputInt(1, 100);

        //create a new array with size n
        int[] arr = Selectionsort.getInputArray(n);

        // display the unsorted array
        Selectionsort.display(arr, "\nUnsorted array: ");

        // perform selection sort on the array
        Selectionsort.SelectionSort(arr);

        //display the sorted array
        Selectionsort.display(arr, "\nSorted array: ");
    }
    
}
