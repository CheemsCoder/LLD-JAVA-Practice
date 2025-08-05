package org.example.TicTacToe;

public class Player {
    Integer id;
    String name;
    Sign sign;
    public Player(Integer id, String name, Sign sign) {
        this.id = id;
        this.name = name;
        this.sign = sign;
    }

    public void assignSign(Sign sign) {
        this.sign = sign;
    }

}
