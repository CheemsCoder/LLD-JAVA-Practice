package org.example.TaskManagementSystem;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        User u1 = taskManager.addUser(1, "ram");
        User u2 = taskManager.addUser(2, "sam");
        User u3 = taskManager.addUser(3, "jam");
        User u4 = taskManager.addUser(4, "tam");

        taskManager.createTask("task1", 1, "929191", Priority.P0, u1);
        taskManager.assignTaskToUser(1, u2);

        taskManager.createTask("task2", 2, "929192", Priority.P1, u2);
        taskManager.assignTaskToUser(2, u3);

        taskManager.createTask("task3", 3, "929193", Priority.P2, u3);
        taskManager.assignTaskToUser(3, u4);

        taskManager.updateTaskStatus(2, 1, TaskStatus.completed);

        System.out.println("User1");
        taskManager.filterTaskByUser(u1);
        System.out.println("User2");
        taskManager.filterTaskByUser(u2);
        System.out.println("User3");
        taskManager.filterTaskByUser(u3);
        System.out.println("User4");
        taskManager.filterTaskByUser(u4);

    }
}
