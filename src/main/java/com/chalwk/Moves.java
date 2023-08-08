package com.chalwk;

import static com.chalwk.Main.print;
import static com.chalwk.Variables.cell_indicators;
import static com.chalwk.Variables.filler;

public class Moves {

    /***
     * Checks if the move is allowed.
     * @param board The current board
     * @param input The user input
     * @return True if the move is allowed, false if not.
     */
    static boolean moveAllowed(char[][] board, String input) {

        int[] cells = cell_indicators.get(input.toUpperCase());
        int row = cells[0];
        int col = cells[1];

        if (board[row][col] == filler) {
            return true;
        }

        print("Slot taken by [" + board[row][col] + "]. Please try again.");

        return false;
    }

    /***
     * Places the move on the board.
     * @param board The current board
     * @param input The user input
     * @param symbol The symbol to place
     */
    static void placeMove(char[][] board, String input, char symbol) {

        int[] cells = cell_indicators.get(input.toUpperCase());
        int row = cells[0];
        int col = cells[1];

        board[row][col] = symbol;
    }
}
