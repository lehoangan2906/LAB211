
import java.util.Date;
/**
 *
 * @author darkksilver
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //User enter date
        Date firstDate = Controller.inputDate("Please enter date with format [dd/mm/yyy]: ");
        
        String date = Controller.dayOfWeek(firstDate);
        
        System.out.println("Your day is: " + date);
    }
    
}
