package com.chalwk;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static com.chalwk.Main.print;
import static com.chalwk.Variables.*;

public class BoardPicker {

    /**
     * Board picker.
     *
     * @param scanner The scanner.
     *                Gets the user input and returns the board to use.
     */
    static char[][] pickABoard(Scanner scanner) {

        print("Pick a board size:");
        print("1 - 2x2     2 - 3x3     3 - 4x4     4 - 5x5");
        print("5 - 6x6     6 - 7x7     7 - 8x8     8 - 9x9");

        resetBoards();

        char[][] board;

        while (true) {

            // Check if user input is an integer:
            if (!scanner.hasNextInt()) {
                print("Invalid input, please try again.");
                scanner.next();
                continue;
            }

            // Get user input:
            int userInput = scanner.nextInt();
            if (userInput <= 0 || userInput > boards.length) {
                print("Invalid input, please try again.");
                continue;
            }

            // Set board size:
            board = boards[userInput - 1];

            // Set cell indicators:
            letters = Arrays.copyOfRange(new String[]{
                    "A", "B", "C", "D",
                    "E", "F", "G", "H",
                    "I", "J", "K", "L",
                    "M", "N", "O", "P",
                    "Q", "R", "S", "T",
                    "U", "V", "W", "X",
                    "Y", "Z"
            }, 0, board.length);

            for (int i = 0; i < board.length; i++) {
                String letter = letters[i];
                for (int j = 0; j < board.length; j++) {
                    cell_indicators.put(letter + (j + 1), new int[]{i, j});
                }
            }

            // A1 = [0, 0]      A2 = [0, 1]      A3 = [0, 2]

            // TEST:
            String input = "A3";
            int[] cell = cell_indicators.get(input);

            System.out.println(Arrays.toString(cell) + " " + board[cell[0]][cell[1]]);

            board[cell[0]][cell[1]] = 'X';

            break;
        }

        return board;
    }
}
