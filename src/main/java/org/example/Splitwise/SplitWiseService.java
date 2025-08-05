package org.example.Splitwise;

import java.util.*;

import org.example.Splitwise.SplitType.EqualSplit;
import org.example.Splitwise.SplitType.PercentSplit;
import org.example.Splitwise.SplitType.Split;

public class SplitWiseService {
    private static SplitWiseService instance;
    Map<Integer, User> users;
    Map<Integer, Group> groups;

    private SplitWiseService() {
        users = new HashMap<>();
        groups = new HashMap<>();
    }
    public static SplitWiseService getInstance() {
        if(instance == null) {
            instance = new SplitWiseService();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.id, user);
    }

    public void addGroup(Group group) {
        groups.put(group.id, group);
    }

    public void addExpense(Integer groupId, Expense expense) {
        Group group = groups.get(groupId);
        group.addExpense(expense);
        splitExpense(expense);
        updateBalances(expense);

    }

    private void splitExpense(Expense expense) {
        Double total = expense.getAmount();
        List<Split> splits = expense.getSplits();
        int totalSplits = splits.size();
        for(Split split : splits) {
            if(split instanceof EqualSplit) {
                split.setAmount(total/ totalSplits);
            } else if(split instanceof PercentSplit) {
                split.setAmount(total*((PercentSplit) split).getPercent()/100.0);
            }
        }
    }

    private void updateBalances(Expense expense) {
        for(Split split : expense.getSplits()) {
            User paidBy = expense.getPaidBy();
            User user = split.getUser();
            Double amount = split.getAmount();

            if(!paidBy.equals(user)) {
                paidBy.addBalance(amount, user);
                user.addBalance(-amount, user);
            }
        }
    }


}
