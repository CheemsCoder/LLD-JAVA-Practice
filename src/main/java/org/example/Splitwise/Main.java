package org.example.Splitwise;

import org.example.Splitwise.SplitType.EqualSplit;
import org.example.Splitwise.SplitType.PercentSplit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SplitWiseService splitwiseService = SplitWiseService.getInstance();

        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Charlie");

        splitwiseService.addUser(user1);
        splitwiseService.addUser(user2);
        splitwiseService.addUser(user3);

        Group group = new Group(1, "Apartment");
        group.addUser(user1);
        group.addUser(user2);
        group.addUser(user3);

        splitwiseService.addGroup(group);

        Expense expense = new Expense(user1,1, 300.0);
        EqualSplit equalSplit = new EqualSplit(user1);
        EqualSplit equalSplit2 = new EqualSplit(user2);
        PercentSplit percentSplit = new PercentSplit(user3, 20.0);

        expense.addSplit(equalSplit);
        expense.addSplit(equalSplit2);
        expense.addSplit(percentSplit);

        splitwiseService.addExpense(group.id, expense);

        for (User user : Arrays.asList(user1, user2, user3)) {
            System.out.println("Customer: " + user.name);
            for (Map.Entry<User, Double> entry : user.balance.balances.entrySet()) {
                System.out.println("  Balance with " + entry.getKey().name + ": " + entry.getValue());
            }
        }
    }
}
