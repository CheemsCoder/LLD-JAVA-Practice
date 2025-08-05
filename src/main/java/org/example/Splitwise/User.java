package org.example.Splitwise;

public class User {
    Integer id;
    String name;
    Balance balance;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.balance = new Balance(this, id);
    }

    public void addBalance(Double amount, User user) {
        balance.addBalance(amount, user);
    }
}
