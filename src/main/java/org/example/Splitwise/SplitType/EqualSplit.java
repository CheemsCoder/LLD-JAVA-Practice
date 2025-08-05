package org.example.Splitwise.SplitType;

import org.example.Splitwise.User;

public class EqualSplit extends Split {

    public EqualSplit(final User user) {
        super(user);
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
