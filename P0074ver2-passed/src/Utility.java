
import java.util.Scanner;

/**
 *
 * @author darkksilver
 */
public class Utility {

    // function to ask user to choose option from min to max
    public int selectOption(String msg, int min, int max) {
        int input;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print(msg);
            String s = sc.nextLine();

            // check if input is empty
            if (s.isEmpty()) {
                throw new Exception("Input cannot be empty");
            }

            input = Integer.parseInt(s);

            //throw exception if the input is not in the range min to max
            if (max < input || input < min) {
                throw new Exception("Input is not in range [" + min + " - " + max + "]");
            }

            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return selectOption(msg, min, max);
        }
    }

    // function to get input integer from the user
    /*
        param input must be an integer, otherwise will throw exception
        param option 1 for inputting entry value, 2 for row, 3 for column,
        default is inputting entry value
        return the integer that user enter
     */
    public int inputInteger(String msg, int option) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(msg);
            int input = Integer.parseInt(sc.nextLine());

            // throw exception if row's size is smaller than 1
            if (option == 2 && input < 1) {
                throw new IllegalArgumentException("Row's size must be greater than 0");
            } // throw exception if column's size is smaller than 1
            else if (option == 3 && input < 1) {
                throw new IllegalArgumentException("Column's size must be greater than 0");
            }

            return input;
        } catch (NumberFormatException e) {
            // print different exceptions based on user's option
            switch (option) {
                // for inputting matrix' entries
                case 1:
                    System.out.println("Value of matrix' entries must be digits");
                    break;

                // for inputting row
                case 2:
                    System.out.println("Value of row must be digit");
                    break;

                // for inputting column
                case 3:
                    System.out.println("Value of column is digit");
                    break;

                // default case
                default:
                    System.out.println("Value of matrix's entries mst be digits");
                    break;
            }

            // ask user for input new values
            return inputInteger(msg, option);

        } catch (IllegalArgumentException e) {
            // print the cause of exception
            System.out.println(e.getMessage());

            // ask user for input new values
            return inputInteger(msg, option);
        }
    }
}
