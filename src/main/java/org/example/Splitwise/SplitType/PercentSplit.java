package org.example.Splitwise.SplitType;

import org.example.Splitwise.User;

public class PercentSplit extends Split {
    private final double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    public double getPercent() {
        return percent;
    }
}
