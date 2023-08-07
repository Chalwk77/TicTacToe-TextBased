package com.chalwk;

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

            // Show cell indicators (1,2,3 etc. & A,B,C etc.):
            for (int i = 0; i < board.length; i++) {
                String pos = positions[userInput - 1][i];
                for (int j = 0; j < board.length; j++) {
                    cell_indicators.put(pos + (j + 1), new int[]{j, i});
                }
            }

            break;
        }

        return board;
    }
}
