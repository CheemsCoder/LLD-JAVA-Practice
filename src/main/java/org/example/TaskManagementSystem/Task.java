package org.example.TaskManagementSystem;

public class Task {
    String title;
    Integer id;
    String dueDate;
    Priority priority;
    TaskStatus status;
    User createdBy;
    User assignedTo;

    public Task(String title, Integer id, String dueDate, Priority priority, User createdBy) {
        this.title = title;
        this.id = id;
        this.dueDate = dueDate;
        this.priority = priority;
        this.createdBy = createdBy;
        this.status = TaskStatus.pending;
        this.assignedTo = null;
    }

    public void assignTask(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void changeStatus(TaskStatus newStatus) {
        this.status = newStatus;
    }

    public void reset() {
        this.assignedTo = null;
    }

    public String printTask() {
        String s = "Title : " + title + "\nDue Date : " + dueDate + "\nPriority : " + priority + "\nStatus : " + status;
        return s;
    }


}
