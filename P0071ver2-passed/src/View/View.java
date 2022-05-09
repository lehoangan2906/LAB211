package View;

import java.util.Date;
import Utility.Inputter;
import Controller.TaskManager;
import Model.Task;
import java.util.ArrayList;

/**
 *
 * @author darkksilver
 */
public class View {

    // = new TaskManager();
    Inputter inputter = new Inputter();

    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("|               Task Program           |");
        System.out.println("========================================");
        System.out.println("|\t1. Add Task                    |");
        System.out.println("|\t2. Delete Task                 |");
        System.out.println("|\t3. Display Task                |");
        System.out.println("|\t4. Exit                        |");
        System.out.println("========================================");
    }

    public void inputTask(TaskManager manager) throws Exception {
        System.out.println("\n------------Add Task---------------");

        String requireName = inputter.getString("Requirement Name: ", "", "");
        String taskType = inputter.getTaskType("Task Type: ");
        Date date = inputter.getDate();
        double planFrom = inputter.getDouble("From: ", "planFrom must be within 8-17h", 8.0, 17.0);
        double planTo = inputter.getDouble("To: ", "planTo must be after planFrom and not after 17h30", planFrom + 0.5, 17.5);
        String assignee = inputter.getString("Assignee: ", "", "");
        String reviewer = inputter.getString("Reviewer: ", "", "");

        manager.addTask(requireName, taskType, date, planFrom, planTo, assignee, reviewer);
    }

    public int inputID(TaskManager manager) throws Exception {
        System.out.println("--------- Del Task --------");

        // ask user to input id of the task to be deleted
        int taskId = inputter.getInt("ID: ", "Task id exceeds range", 1, manager.getlastID());
        
        return taskId;
    }
    
    public void displayTask(ArrayList<Task> taskList) throws Exception {
        
        //throw exception if the tasklist is empty
        if (taskList.isEmpty()) {
            throw new Exception("List task is empty!");
        } else {
            System.out.println("----------------------------------------- Task ----------------------------------------");
            System.out.format("%-6s%-20s%-13s%-13s%-14s%-13s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            //loop use to access each element of arraylist from begining to the end
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }
    
}
