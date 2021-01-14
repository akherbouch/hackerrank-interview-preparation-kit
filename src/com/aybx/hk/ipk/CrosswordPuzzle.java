package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class CrosswordPuzzle {


    char[][] grid = new char[10][10];
    String[] words;
    int[] dRow = {0, 1};
    int[] dCol = {1, 0};


    private List<Position> availablePositions(String word) {
        List<Position> res = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            for (int j = 0; j<10; j++) {
                for (int d = 0; d<2; d++) {
                    Position cur = new Position(i, j, d);
                    if (check(word, cur)) res.add(cur);
                }
            }
        }
        return res;
    }

    private boolean check(String word, Position position) {
        for (int i = 0, row, col; i<word.length(); i++) {
            row = position.row + i*dRow[position.dir];
            col = position.col + i*dCol[position.dir];
            if (row >= 10 || col >= 10) return false;
            if (grid[row][col] == word.charAt(i)) continue;
            if (grid[row][col] != '-') return false;
        }
        return true;
    }

    private void putWord(String word, Position position) {
        for (int i = 0, row, col; i<word.length(); i++) {
            row = position.row + i*dRow[position.dir];
            col = position.col + i*dCol[position.dir];
            grid[row][col] = word.charAt(i);
        }
    }

    private void undo(String word, Position position) {
        for (int i = 0, row, col; i<word.length(); i++) {
            row = position.row + i*dRow[position.dir];
            col = position.col + i*dCol[position.dir];
            grid[row][col] = '-';
        }
    }


    public boolean rec(int index) {
        if (index == words.length) return true;
        String word = words[index];
        List<Position> poss = availablePositions(word);
        for (Position pos : poss) {
            putWord(word, pos);
            if (rec(index + 1)) return true;
            undo(word, pos);
        }
        return false;
    }



    public void solve(int testNumber, Scanner in, PrintWriter out) {
        for (int i = 0; i<10; i++) {
            String row = in.nextLine();
            for (int j = 0; j<10; j++) {
               grid[i][j] = row.charAt(j);
            }
        }
        words = in.next().split(";");

        rec(0);

        for (int i = 0; i<10; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j<10; j++) {
                row.append(grid[i][j]);
            }
            out.println(row);
        }
    }

    private static class Position {
        int row, col, dir;

        public Position(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }
}
