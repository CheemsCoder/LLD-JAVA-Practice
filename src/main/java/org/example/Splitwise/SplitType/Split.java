package org.example.Splitwise.SplitType;

import org.example.Splitwise.User;

public abstract class Split {
    User user;
    Double amount;

    public Split(User user) {
        this.user = user;
    }

    public abstract Double getAmount();

    public User getUser() {
        return user;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
