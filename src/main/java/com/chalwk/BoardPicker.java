package com.chalwk;

import java.util.Arrays;
import java.util.Scanner;

import static com.chalwk.Main.print;
import static com.chalwk.Variables.*;

public class BoardPicker {

    /**
     * Board picker.
     *
     * @param scanner The scanner
     *                Gets the user input from the scanner and sets the board to use.
     */
    static char[][] pickABoard(Scanner scanner) {

        print("Pick a board size:");
        print("1 - 3x3     2 - 4x4     3 - 5x5     4 - 6x6");
        print("5 - 7x7     6 - 8x8     7 - 9x9     8 - 10x10");

        resetBoards();

        char[][] board;

        while (true) {

            if (!scanner.hasNextInt()) {
                print("Invalid input, please try again.");
                scanner.next();
                continue;
            }

            int userInput = scanner.nextInt();
            if (userInput <= 0 || userInput > boards.length) {
                print("Invalid input, please try again.");
                continue;
            }

            // Set the board to use:
            board = boards[userInput - 1];

            letters = Arrays.copyOfRange(new String[]{
                    "A", "B", "C", "D",
                    "E", "F", "G", "H",
                    "I", "J", "K", "L",
                    "M", "N", "O", "P",
                    "Q", "R", "S", "T",
                    "U", "V", "W", "X",
                    "Y", "Z"
            }, 0, board.length);

            // Set the cell indicators (e.g. A1, B2, C3, etc.):
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    board[row][col] = filler;
                    cell_indicators.put(letters[row] + (col + 1), new int[]{col, row});
                }
            }

            break;
        }

        return board;
    }
}
