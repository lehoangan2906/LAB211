package Utility;

import java.util.*;
import java.text.*;

/**
 *
 * @author darkksilver
 */
public class Inputter {

    //take input option and validate it
    public static int getOption(String message, int min, int max) {
        int input;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(message);

            // get user's input
            String s = sc.nextLine();

            //throw exception if the input is empty
            if (s.isEmpty()) {
                throw new Exception("Empty input");
            }

            // check if the input is of type integer
            input = Integer.parseInt(s);

            //throw exception if the input is not in range from min to max
            if (input < min || input > max) {
                throw new Exception("Not in range [" + min + "-" + max + "]");
            }
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getOption(message, min, max);
        }
    }

    // function to get integer input
    public int getInt(String msg, String errorMsg, int min, int max) {
        String input;
        Scanner sc = new Scanner(System.in);
        //loop until user enter a valid integer
        do {
            try {
                System.out.print(msg);

                // get user's input
                input = sc.nextLine();

                //throw exception if the input is empty
                if (input.isEmpty()) {
                    throw new Exception("Empty input");
                }

                // check if input is of type integer
                int result = Integer.parseInt(input);

                //throw exception if input is out of range
                if (result < min || result > max) {
                    throw new Exception(errorMsg);
                }
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    // function to get string input
    public String getString(String msg, String errorMsg, String regex) {
        String input;
        Scanner sc = new Scanner(System.in);
        //loop until user enter a valid string
        do {
            try {
                System.out.print(msg);

                // get user's input
                input = sc.nextLine();

                //throw exception if input is empty
                if (input.isEmpty()) {
                    throw new Exception("Empty input");
                }

                //return input if regex is not empty and input matches regex
                if (regex.isEmpty() || input.matches(regex)) {
                    return input;
                } else {
                    throw new Exception(errorMsg);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    // function to input date time
    public Date getDate() {
        while (true) {
            // get user's input
            String resultDate = getString("Input the date ", "", "");

            SimpleDateFormat tempDate = new SimpleDateFormat("dd-MM-yyyy");     // date must in the form dd-MM-yyyy
            tempDate.setLenient(false);     // not except wrong format
            try {
                // check if user's input is valid
                Date date = tempDate.parse(resultDate);

                return date;
            } catch (Exception e) {
                System.out.print("invalid date ! -  please enter again: ");
            }
        }
    }

    // function to get the task's type
    public String getTaskType(String msg) {

        // get user's input 
        int taskTypeID = getInt(msg, "Task Type must be in range [1-4]", 1, 4);

        switch (taskTypeID) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            default:
                return "Review";
        }
    }

    // function to input double value
    public double getDouble(String msg, String errorMsg, double min, double max) {
        double result;
        String input;

        //loop until user enter a valid double
        do {
            try {
                // prompt user for the input
                input = getString(msg, "Only accept multiples of 0.5 as input",
                        "(^[\\d]+\\.[05]$)|(^[\\d]+$)");

                // check if the input is of type double
                result = Double.parseDouble(input);

                //throw exception if result out of range
                if (result < min || result > max) {
                    throw new Exception(errorMsg);
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Not a real number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
