package org.example.TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Integer n;
    Integer m;
    List<List<Sign>> board;
    Integer moveCount;

    public Board(Integer n, Integer m) {
        this.n = n;
        this.m = m;
        this.board = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            List<Sign> row = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                row.add(Sign.EMPTY);
            }
            board.add(row);
        }

        this.moveCount = 0;
    }


    public void markBoard(Integer row, Integer col, Sign sign) {
        board.get(row).set(col, sign);
        printBoard();
        moveCount++;
    }

    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Boolean CheckWin(Sign sign) {
        for(int i = 0; i < n; i++) {
            boolean rowWin = true;
            for(int j=0; j < m; j++) {
                if(board.get(i).get(j) != sign) {
                    rowWin = false;
                    break;
                }
            }
            if(rowWin) return true;
        }

        for(int j=0;j<m;j++) {
            boolean colWin = true;
            for(int i=0; i<n; i++) {
                if(board.get(i).get(j) != sign) {
                    colWin = false;
                    break;
                }
            }
            if(colWin) return true;
        }

        // Diagonal
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < n; i++) {
            if(board.get(i).get(i) != sign) {
                diag1 = false;
            }
            if(board.get(i).get(n-i-1) != sign) {
                diag2 = false;
            }
        }

        return diag1 || diag2;
    }

    public boolean isDraw() {
        if(moveCount == n*m) { return true; }
        return false;
    }

    public void reset() {
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>(m));
            for (int j = 0; j < m; j++) {
                board.get(i).set(j, Sign.EMPTY);
            }
        }
    }



}
