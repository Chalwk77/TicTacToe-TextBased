package com.chalwk;

import java.util.Scanner;

import static com.chalwk.Main.*;
import static com.chalwk.Variables.*;

public class BoardPicker {
    static char[][] pickABoard(Scanner scanner) {

        print("Pick a board size:");
        print("1 - 2x2     2 - 3x3     3 - 4x4     4 - 5x5");
        print("5 - 6x6     6 - 7x7     7 - 8x8     8 - 9x9");

        char[][] board;
        while (true) {

            int userInput = scanner.nextInt();
            if (userInput <= 0 || userInput > boards.length) {
                continue;
            }
            board = boards[userInput - 1];

            for (int i = 0; i < board.length; i++) {
                String pos = positions[userInput - 1][i];
                for (int j = 0; j < board.length; j++) {
                    map.put(pos + (j + 1), new int[]{j, i});
                }
            }

            break;
        }
        return board;
    }
}
