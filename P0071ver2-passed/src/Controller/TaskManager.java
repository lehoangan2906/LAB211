package Controller;

import Model.Task;
import Utility.Inputter;
import java.util.*;

/**
 *
 * @author darkksilver
 */
public class TaskManager {

    // create an ArrayList to store task list
    ArrayList<Task> taskList = new ArrayList<>();

    // function to add task top the list
    public int addTask(String requirementName, String taskTypeID,
            Date date, double planFrom, double planTo, String assignee, String reviewer) throws Exception {

        if (checkTaskAvailable(date, assignee, planFrom, planTo)) {
            throw new Exception("Cannot add this task!. Try different time or assignee.");
        } else {

            // create new task with informations user've just input
            Task newTask = new Task(taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);

            // ask new task to the task list
            taskList.add(newTask);
            System.out.println("Task added successfully");

            // return the newly added task's id
            return newTask.getTaskID();
        }
    }

    // function to check overlap tasks of one particular employee
    // in one particular date, cannot exist 2 tasks that have the same assignee in the same time
    public boolean checkTaskAvailable(Date date, String assignee, double planFrom, double planTo) {

        // initialize variable isNotAvailable with default value false
        boolean isNotAvailable = false;

        // loop use to access each element of arraylist from begining to the end
        for (Task task : taskList) {
            // compare date in list with date input and assignee in list with assignee input
            if ((task.getDate().equals(date)) && (task.getAssignee().equalsIgnoreCase(assignee))
                    && (task.getPlanTo() == planTo) && (task.getPlanFrom() == planFrom)) {
                // compare planto and planfrom of input task with every task in list. 
                // if planTo is before planFrom of task in list or planFrom is after planTo of task in list then continue. 
                // Otherwise, return true
                if ((planTo <= task.getPlanFrom()) || (planFrom >= task.getPlanTo())) {
                    continue;
                } else {
                    isNotAvailable = true;
                    break;
                }
            }
        }
        return isNotAvailable;
    }
    
    // function to get id of the last task in the list
    public Integer getlastID(){
        if (taskList.isEmpty()){
            return null;
        }else{
            int a = taskList.get(taskList.size() - 1).getTaskID();
            return a;
        }
    }

    // function to delete a task from the task list
    public void deleteTask(int taskId) throws Exception {

        //throw exception if the task list is empty. Otherwise perform delete
        if (taskList.isEmpty()) {
            throw new Exception("Empty taskList");
        } else {
            // initialize variable index with default value -1
            int index = -1;

            //loop through task list to find the task that user want to delete
            for (Task task : taskList) {
                //if task id equals input id the get the index of the task
                if (taskId == task.getTaskID()) {
                    index = taskList.indexOf(task);
                }
            }

            //if index not equal -1 then remove it
            if (index != -1) {
                taskList.remove(index);
                System.out.println("Remove successfully");
            } else {
                throw new Exception("ID doesn't exist");
            }
        }
    }
    
    // function to return list of tasks
    public ArrayList<Task> getDataTask() {
        return taskList;
    }

}
