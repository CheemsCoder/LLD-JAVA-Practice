package org.example.TaskManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class User {
    Integer id;
    String name;
    Map<Integer, Task> completeTasks;
    Map<Integer, Task> inProgressTasks;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.completeTasks = new HashMap<>();
        this.inProgressTasks = new HashMap<>();
    }

    public void assignTask(Task task) {
        inProgressTasks.putIfAbsent(task.id, task);
    }

    public void completeTask(Task task) {
        if(inProgressTasks.containsKey(task.id)) {
            inProgressTasks.remove(task.id);
        }
        completeTasks.putIfAbsent(task.id, task);
    }

    public void deleteTask(Task task) {
        if(completeTasks.containsKey(task.id)) {
            completeTasks.remove(task.id);
        }
        if(inProgressTasks.containsKey(task.id)) {
            inProgressTasks.remove(task.id);
        }
    }

    public Map<Integer, Task> getInprogressTasks() {
        return inProgressTasks;
    }

    public Map<Integer, Task> getCompleteTasks() {
        return completeTasks;
    }
}


