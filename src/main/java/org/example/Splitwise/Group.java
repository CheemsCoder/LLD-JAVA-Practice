package org.example.Splitwise;


import java.util.*;

public class Group {
    Integer id;
    String name;
    List<User> users;
    List<Expense> expenses;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
        users = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    List<User> getUsers() {
        return users;
    }

    List<Expense> getExpenses() {
        return expenses;
    }

}
