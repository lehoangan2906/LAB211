package Controller;

import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class Utilities {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private final Scanner input = new Scanner(System.in);

    public int getInt(String msg, String err, int min, int max) throws IOException {
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

    public double getDouble(String msg, String err, double min, double max) throws IOException {
        while (true) {
            try {
                System.out.print(msg);
                double num;
                num = Double.parseDouble(in.readLine());
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

    private boolean isDouble(String str) {
        try {
            // check if it can be parsed as any double
            double x = Double.parseDouble(str);
            // check if the double can be converted without loss to an int
            if (x == (int) x) // if yes, this is an int, thus return false
            {
                return false;
            }
            // otherwise, this cannot be converted to an int (e.g. "1.2")
            return true;
            // short version: return x != (int) x;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    static boolean isInt(String s) // assuming integer is in decimal number system
    {
        for (int a = 0; a < s.length(); a++) {
            if (a == 0 && s.charAt(a) == '-') {
                continue;
            }
            if (!Character.isDigit(s.charAt(a))) {
                return false;
            }
        }
        return true;
    }

    public String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.print(msg);
                String str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("IOException");
            }
            System.out.println(err);
        }
    }
    
    public String checkInputString(String result) {
        //loop until user input correct
        while (true) {
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    //check user input double
    public boolean checkInputDouble(double result) {
        //loop until user input correct
        while (true) {
            try {
                return result > 0;
            } catch (NumberFormatException e) {
                System.err.println("Must input a positive double");
                System.out.print("Enter again: ");
            }

        }
    }
    
    //check user input int
    public boolean checkInputInt(int result) {
        //loop until user input correct
        while (true) {
            try {
                return result > 0;
            } catch (NumberFormatException e) {
                System.err.println("Must input a positive integer.");
                System.out.print("Enter again: ");
            }
        }
    }
}
