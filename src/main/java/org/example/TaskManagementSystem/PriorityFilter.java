package org.example.TaskManagementSystem;

import java.util.Map;

public class PriorityFilter implements FilterTask{
    Map<Integer, Task> tasks;
    public PriorityFilter(Map<Integer, Task> tasks) {
        this.tasks = tasks;
    }
    @Override
    public Map<Integer, Task> filterTasks() {
        return Map.of();
    }
}
