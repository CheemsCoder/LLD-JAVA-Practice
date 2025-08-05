package org.example.Splitwise.SplitType;

import org.example.Splitwise.User;

public class ExactSplit extends Split {
    public ExactSplit(final User user) {
        super(user);
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }
}
