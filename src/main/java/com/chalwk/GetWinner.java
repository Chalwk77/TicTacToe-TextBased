package com.chalwk;

import static com.chalwk.Main.WINNING_COMBINATIONS;

public class GetWinner {

    static boolean getWinner(char[][] board, char symbol) {

        switch (board.length) {
            case 2 -> {
                for (int[] combination : WINNING_COMBINATIONS[0]) {
                    int x = combination[0];
                    int y = combination[1];
                    if (board[x / 2][x % 2] == symbol
                            && board[y / 2][y % 2] == symbol) {
                        return true;
                    }
                }
            }
            case 3 -> {
                for (int[] combination : WINNING_COMBINATIONS[0]) {
                    int x = combination[0];
                    int y = combination[1];
                    int z = combination[2];
                    if (board[x / 3][x % 3] == symbol
                            && board[y / 3][y % 3] == symbol
                            && board[z / 3][z % 3] == symbol) {
                        return true;
                    }
                }
            }
            case 4 -> {
                for (int[] combination : WINNING_COMBINATIONS[1]) {
                    int x = combination[0];
                    int y = combination[1];
                    int z = combination[2];
                    int w = combination[3];
                    if (board[x / 4][x % 4] == symbol
                            && board[y / 4][y % 4] == symbol
                            && board[z / 4][z % 4] == symbol
                            && board[w / 4][w % 4] == symbol) {
                        return true;
                    }
                }
            }
            case 5 -> {
                for (int[] combination : WINNING_COMBINATIONS[2]) {
                    int x = combination[0];
                    int y = combination[1];
                    int z = combination[2];
                    int w = combination[3];
                    int v = combination[4];
                    if (board[x / 5][x % 5] == symbol
                            && board[y / 5][y % 5] == symbol
                            && board[z / 5][z % 5] == symbol
                            && board[w / 5][w % 5] == symbol
                            && board[v / 5][v % 5] == symbol) {
                        return true;
                    }
                }
            }
            case 6 -> {
                for (int[] combination : WINNING_COMBINATIONS[3]) {
                    int x = combination[0];
                    int y = combination[1];
                    int z = combination[2];
                    int w = combination[3];
                    int v = combination[4];
                    int u = combination[5];
                    if (board[x / 6][x % 6] == symbol
                            && board[y / 6][y % 6] == symbol
                            && board[z / 6][z % 6] == symbol
                            && board[w / 6][w % 6] == symbol
                            && board[v / 6][v % 6] == symbol
                            && board[u / 6][u % 6] == symbol) {
                        return true;
                    }
                }
            }
            case 7 -> {
                for (int[] combination : WINNING_COMBINATIONS[4]) {
                    int x = combination[0];
                    int y = combination[1];
                    int z = combination[2];
                    int w = combination[3];
                    int v = combination[4];
                    int u = combination[5];
                    int t = combination[6];
                    if (board[x / 7][x % 7] == symbol
                            && board[y / 7][y % 7] == symbol
                            && board[z / 7][z % 7] == symbol
                            && board[w / 7][w % 7] == symbol
                            && board[v / 7][v % 7] == symbol
                            && board[u / 7][u % 7] == symbol
                            && board[t / 7][t % 7] == symbol) {
                        return true;
                    }
                }
            }
            case 8 -> {
                for (int[] combination : WINNING_COMBINATIONS[5]) {
                    int x = combination[0];
                    int y = combination[1];
                    int z = combination[2];
                    int w = combination[3];
                    int v = combination[4];
                    int u = combination[5];
                    int t = combination[6];
                    int s = combination[7];
                    if (board[x / 8][x % 8] == symbol
                            && board[y / 8][y % 8] == symbol
                            && board[z / 8][z % 8] == symbol
                            && board[w / 8][w % 8] == symbol
                            && board[v / 8][v % 8] == symbol
                            && board[u / 8][u % 8] == symbol
                            && board[t / 8][t % 8] == symbol
                            && board[s / 8][s % 8] == symbol) {
                        return true;
                    }
                }
            }
            case 9 -> {
                for (int[] combination : WINNING_COMBINATIONS[6]) {
                    int x = combination[0];
                    int y = combination[1];
                    int z = combination[2];
                    int w = combination[3];
                    int v = combination[4];
                    int u = combination[5];
                    int t = combination[6];
                    int s = combination[7];
                    int r = combination[8];
                    if (board[x / 9][x % 9] == symbol
                            && board[y / 9][y % 9] == symbol
                            && board[z / 9][z % 9] == symbol
                            && board[w / 9][w % 9] == symbol
                            && board[v / 9][v % 9] == symbol
                            && board[u / 9][u % 9] == symbol
                            && board[t / 9][t % 9] == symbol
                            && board[s / 9][s % 9] == symbol
                            && board[r / 9][r % 9] == symbol) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
