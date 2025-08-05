package org.example.Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.example.Splitwise.SplitType.Split;

public class Expense {
    User paidBy;
    List<Split> splits;
    Integer id;
    Double amount;

    public Expense(User user, Integer id, Double amount) {
        this.paidBy = user;
        this.id = id;
        this.amount = amount;
        this.splits = new ArrayList<Split>();
    }

    public void addSplit(Split split) {
        splits.add(split);
    }

    public Integer getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

}
