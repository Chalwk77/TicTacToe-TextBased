package com.chalwk;

import java.util.Map;

import static com.chalwk.Main.*;

public class PrintBoard {

    static void printBoard(char[][] board, boolean clear) {

        if (clear) {
            print("\n".repeat(50));
        }

        switch (board.length) {
            case 2 -> {
                print("  --A---B--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " |");
                print("  |---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " |");
                print("  |-------|");
            }
            case 3 -> {
                print("  --A---B---C--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
                print("  |---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
                print("  |---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
                print("  |-----------|");
            }
            case 4 -> {
                // print with ABC 1234
                print("  --A---B---C---D--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " |");
                print("  |---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " |");
                print("  |---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " |");
                print("  |---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " |");
                print("  |---------------|");
            }
            case 5 -> {
                print("  --A---B---C---D---E--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " |");
                print("  |---+---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " |");
                print("  |---+---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " |");
                print("  |---+---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " |");
                print("  |---+---+---+---+---|");
                print("5 | " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " |");
                print("  |-------------------|");
            }
            case 6 -> {
                print("  --A---B---C---D---E---F--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " |");
                print("  |---+---+---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " |");
                print("  |---+---+---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " |");
                print("  |---+---+---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " |");
                print("  |---+---+---+---+---+---|");
                print("5 | " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " |");
                print("  |---+---+---+---+---+---|");
                print("6 | " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " |");
                print("  |-----------------------|");
            }
            case 7 -> {
                print("  --A---B---C---D---E---F---G--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6] + " |");
                print("  |---+---+---+---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6] + " |");
                print("  |---+---+---+---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6] + " |");
                print("  |---+---+---+---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6] + " |");
                print("  |---+---+---+---+---+---+---|");
                print("5 | " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6] + " |");
                print("  |---+---+---+---+---+---+---|");
                print("6 | " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6] + " |");
                print("  |---+---+---+---+---+---+---|");
                print("7 | " + board[6][0] + " | " + board[6][1] + " | " + board[6][2] + " | " + board[6][3] + " | " + board[6][4] + " | " + board[6][5] + " | " + board[6][6] + " |");
                print("  |---------------------------|");
            }
            case 8 -> {
                print("  --A---B---C---D---E---F---G---H--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6] + " | " + board[0][7] + " |");
                print("  |---+---+---+---+---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6] + " | " + board[1][7] + " |");
                print("  |---+---+---+---+---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6] + " | " + board[2][7] + " |");
                print("  |---+---+---+---+---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6] + " | " + board[3][7] + " |");
                print("  |---+---+---+---+---+---+---+---|");
                print("5 | " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6] + " | " + board[4][7] + " |");
                print("  |---+---+---+---+---+---+---+---|");
                print("6 | " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6] + " | " + board[5][7] + " |");
                print("  |---+---+---+---+---+---+---+---|");
                print("7 | " + board[6][0] + " | " + board[6][1] + " | " + board[6][2] + " | " + board[6][3] + " | " + board[6][4] + " | " + board[6][5] + " | " + board[6][6] + " | " + board[6][7] + " |");
                print("  |---+---+---+---+---+---+---+---|");
                print("8 | " + board[7][0] + " | " + board[7][1] + " | " + board[7][2] + " | " + board[7][3] + " | " + board[7][4] + " | " + board[7][5] + " | " + board[7][6] + " | " + board[7][7] + " |");
                print("  |---------------------------|");
            }
            case 9 -> {
                print("  --A---B---C---D---E---F---G---H---I--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6] + " | " + board[0][7] + " | " + board[0][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6] + " | " + board[1][7] + " | " + board[1][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6] + " | " + board[2][7] + " | " + board[2][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6] + " | " + board[3][7] + " | " + board[3][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("5 | " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6] + " | " + board[4][7] + " | " + board[4][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("6 | " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6] + " | " + board[5][7] + " | " + board[5][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("7 | " + board[6][0] + " | " + board[6][1] + " | " + board[6][2] + " | " + board[6][3] + " | " + board[6][4] + " | " + board[6][5] + " | " + board[6][6] + " | " + board[6][7] + " | " + board[6][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("8 | " + board[7][0] + " | " + board[7][1] + " | " + board[7][2] + " | " + board[7][3] + " | " + board[7][4] + " | " + board[7][5] + " | " + board[7][6] + " | " + board[7][7] + " | " + board[7][8] + " |");
                print("  |---+---+---+---+---+---+---+---+---|");
                print("9 | " + board[8][0] + " | " + board[8][1] + " | " + board[8][2] + " | " + board[8][3] + " | " + board[8][4] + " | " + board[8][5] + " | " + board[8][6] + " | " + board[8][7] + " | " + board[8][8] + " |");
                print("  |-----------------------------------|");
            }
        }

        StringBuilder available = new StringBuilder("Make your move:\n");
        int count = 0;

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            String pos = entry.getKey();
            int[] rowCol = entry.getValue();
            int row = rowCol[0];
            int col = rowCol[1];

            count++;
            if (count % 10 == 0) {
                available.append("\n");
            } else if (board[row][col] == empty) {
                available.append(pos).append(", ");
            }
        }

        System.out.println(header);
        System.out.println(available);
    }
}
