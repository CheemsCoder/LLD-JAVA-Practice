package org.example.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1, "Ram", Sign.X);
        Player p2 = new Player(2, "Pandey", Sign.O);

        Board board = new Board(3,3);

        Player[] players = new Player[]{p1, p2};
        Game game = new Game(board, players);

        Scanner scanner = new Scanner(System.in);
        while(game.gameStatus == GameStatus.IN_PROGRESS) {
            System.out.println("Turn of : " + game.getPlayerName());
            Integer row = scanner.nextInt();
            Integer column = scanner.nextInt();
            game.playMove(row, column);
        }
    }
}
