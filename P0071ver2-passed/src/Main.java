
import Controller.TaskManager;
import Utility.Inputter;
import View.View;
import java.util.Date;

/**
 *
 * @author darkksilver
 */
public class Main {
    TaskManager manager = new TaskManager();
        Inputter inputter = new Inputter();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create instances of TaskManager class and View class
        TaskManager manager = new TaskManager();
        Inputter inputter = new Inputter();
        View view = new View();

        int choice;     // variable store user's choice

        //Loop until user choose exit
        do {
            //1, display menu
            view.displayMenu();

            //2. get option from user
            choice = inputter.getOption("\nEnter your choice: ", 1, 4);

            try {
                //3. perform function based on user choice
                switch (choice) {
                    //add task
                    case 1:
                        view.inputTask(manager);
                        break;
                        
                    //delete task
                    case 2:
                        manager.deleteTask(view.inputID(manager));
                        break;
                    //display task
                    case 3:
                        view.displayTask(manager.getDataTask());
                        break;
                    //exit
                    default:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
