package View;

import java.util.Date;

public class View {

    public static void display(){
        //User enter first date
        Date firstDate = Controller.Controller.inputDate("Please enter the first date (dd/MM/yyyy): ");

        //User enter second date
        Date secondDate = Controller.Controller.inputDate("Please enter the second date (dd/MM/yyyy): ");

        //Compare and display
        Controller.Controller.CompareAndDisplay(firstDate, secondDate);
    }
    
}
