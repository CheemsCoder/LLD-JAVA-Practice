package org.example.TaskManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    Map<Integer, User> users;
    Map<Integer, Task> tasks;

    public TaskManager() {
        users = new HashMap<>();
        tasks = new HashMap<>();
    }

    public User addUser(Integer id, String name) {
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    public void createTask(String title, Integer id, String dueDate, Priority priority, User createdBy) {
        Task task = new Task(title, id, dueDate, priority, createdBy);
        tasks.put(id, task);
    }

    public void assignTaskToUser(Integer taskId, User user) {
        Task task = tasks.get(taskId);
        user.assignTask(task);
        task.assignTask(user);
    }

    public void deleteTask(Integer taskId) {
        Task task = tasks.get(taskId);
        User user = users.get(task.assignedTo);
        user.deleteTask(task);
        task.reset();
        tasks.remove(taskId);
    }

    public void updateTaskStatus(Integer userId, Integer taskId, TaskStatus status) {
        User user = users.get(userId);
        Task task = tasks.get(taskId);
        if(status == TaskStatus.completed) {
            user.completeTask(task);
        }
        task.changeStatus(status);
    }

    public void viewCompletedTaskOfUser(Integer userId) {
        User user = users.get(userId);
        Map<Integer, Task> completedTasks = user.getCompleteTasks();
        for(Task task : completedTasks.values()) {
            System.out.println(task.printTask());
        }
    }

    public void viewInProgressTaskOfUser(Integer userId) {
        User user = users.get(userId);
        Map<Integer, Task> inProgressTasks = user.getInprogressTasks();
        for(Task task : inProgressTasks.values()) {
            System.out.println(task.printTask());
        }
    }

    public void filterTaskByPriority(Priority priority) {
        for(Task task : tasks.values()) {
            if(task.priority == priority) {
                System.out.println(task.printTask());
            }
        }
    }

    public void filterTaskByDueDate(String dueDate) {
        for(Task task : tasks.values()) {
            if(task.dueDate.equals(dueDate)) {
                System.out.println(task.printTask());
            }
        }
    }

    public void filterTaskByUser(User user) {
        Map<Integer, Task> t = user.getCompleteTasks();
        for(Task task : t.values()) {
            System.out.println(task.printTask());
        }
        Map<Integer, Task> u = user.getInprogressTasks();
        for(Task task : u.values()) {
            System.out.println(task.printTask());
        }
    }
}
