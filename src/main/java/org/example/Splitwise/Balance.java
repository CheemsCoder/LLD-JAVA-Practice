package org.example.Splitwise;

import java.util.HashMap;
import java.util.Map;

public class Balance {
    User user;
    Integer id;
    Double totalBalance;
    Map<User, Double> balances;

    public Balance(User user, Integer id) {
        this.id = id;
        this.user = user;
        this.totalBalance = 0.0;
        this.balances = new HashMap<User, Double>();
    }

    public void addBalance(Double amount, User user) {
        totalBalance += amount;
        if(!balances.containsKey(user)) {
            balances.put(user, 0.0);
        }
        balances.put(user, balances.get(user) + amount);
    }
}
