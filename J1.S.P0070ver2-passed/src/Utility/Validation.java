package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validation {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getOption(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err, String regex) {
        String str = "";
        try {
            System.out.println(msg);
            str = in.readLine();
            if (str.matches(regex)) {
                return str;
            }
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        return str;

    }
}
