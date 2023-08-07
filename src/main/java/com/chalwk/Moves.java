package com.chalwk;

import static com.chalwk.Main.print;
import static com.chalwk.Variables.cell_indicators;

public class Moves {

    static boolean moveAllowed(char[][] board, String input) {

        int[] cells = cell_indicators.get(input.toUpperCase());
        int row = cells[0];
        int col = cells[1];

        if (board[row][col] == '-') {
            return true;
        }

        print("Slot taken by [" + board[row][col] + "]. Please try again.");

        return false;
    }

    static void placeMove(char[][] board, String input, char symbol) {

        int[] cells = cell_indicators.get(input.toUpperCase());
        int row = cells[0];
        int col = cells[1];

        board[row][col] = symbol;
    }
}
