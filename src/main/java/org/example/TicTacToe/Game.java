package org.example.TicTacToe;

public class Game {
    Board board;
    Player[] players;
    GameStatus gameStatus;
    Integer currentPlayer;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.currentPlayer = 0;
    }

    public Boolean playMove(Integer row, Integer col) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Game already finished.");
        }
        Player player = players[currentPlayer];
        Sign sign = player.sign;
        board.markBoard(row, col, sign);

        if(board.CheckWin(sign)) {
            gameStatus = GameStatus.WIN;
            System.out.println("Player " + player.name + " wins");
        } else if(board.isDraw()) {
            gameStatus = GameStatus.DRAW;
            System.out.println("Game draws");
        } else {
            currentPlayer = 1-currentPlayer;
        }
        return true;
    }

    public void reset() {
        gameStatus = GameStatus.IN_PROGRESS;
        currentPlayer = 0;
        board.reset();
    }

    public void printBoard() {
        board.printBoard();
    }

    public String getPlayerName() {
        Player player = players[currentPlayer];
        return player.name;
    }

}
