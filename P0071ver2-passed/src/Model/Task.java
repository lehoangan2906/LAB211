package Model;

import java.util.*;
import java.text.*;

/**
 *
 * @author darkksilver
 */
public class Task {

    private String TaskTypeID;
    private String RequirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String Assignee;
    private String Reviewer;
    private static int temp = 1;
    private int id;

    public Task(String TaskTypeID, String RequirementName, Date date, double planFrom, double planTo, String Assignee, String Reviewer) {
        this.TaskTypeID = TaskTypeID;
        this.RequirementName = RequirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
        this.id = temp++;
    }

    public int getTaskID() {
        return id;
    }

    public void setTaskID(int TaskID) {
        this.id = TaskID;
    }

    public String getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(String TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    @Override
    public String toString() {
        double time = planTo - planFrom;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String stringDate = dateFormat.format(date);
        String planTime = String.format("%.1f", time);
        String result = String.format("%-6d%-20s%-13s%-13s%-14s%-13s%-15s", id, RequirementName, TaskTypeID, stringDate, planTime, Assignee, Reviewer);
        return result;
    }
}
