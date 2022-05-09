
import java.text.*;
import java.util.*;


/**
 *
 * @author darkksilver
 */
public class Controller {

    // function to check if a string input contains characters from '/' to '9'
    public static boolean checkContainCharacter(String input) {
        boolean isContain = true;

        //loop use to access each character of string from begining to the end
        for (int i = 0; i < input.length(); i++) {

            //check if character at index i is out of range from character '/' to '9'
            if (!(input.charAt(i) >= '/' && input.charAt(i) <= '9')) {
                isContain = false;
            }
        }
        return isContain;
    }

    public static Date inputDate(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        Date date;

        // keep asking user to input until the input is right
        do {
            System.out.print(msg);                                                  // print the desired message
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");       // used to cast string type to date type
            dateFormat.setLenient(false);
            input = sc.nextLine();                                                  // get user's input

            // nếu set lenient là true thì input datestring là 31/2/2019 thì nó 
            // sẽ tự động hiểu là 3 ngày sau 28/2/2019 - > thành 3/3/2019
            // check for empty input
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } // if input is not empty then check the user's input format is right or false
            // if input contains characters between '/' and '9' then:
            else if (checkContainCharacter(input)) {

                // \d{1,2}: the number have 1 or 2 digit number
                //[/]: contain character /
                //\d{4}: the number must have 4 digit
                // check if input matches the regex of datetime format
                if (!input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                    System.out.println("Input is wrong format date");
                    continue;
                }

                // try catch exception to deal with condition the date input is not exist  e.g. 32/02/2003
                try {
                    date = dateFormat.parse(input);
                    break;
                } catch (ParseException exception) {
                    System.out.println("Date doesn't existed!!");
                }
            } // if input does not contains characters between '/' and '9' then:
            else {
                System.out.println("Contain special character. Please enter again!");
            }
        } while (true);

        // return the input date
        return date;
    }
    
    public static String dayOfWeek(Date date){
        DateFormat format = new SimpleDateFormat("EEEE");   // EE meaning day of week, short version
        String finalDay = format.format(date);              // format the input date to day of week format
        
        return finalDay;
    }

}
