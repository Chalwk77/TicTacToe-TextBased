package com.chalwk;

import java.util.Map;

import static com.chalwk.Main.print;
import static com.chalwk.Variables.cell_indicators;
import static com.chalwk.Variables.header;

public class Moves {

    static boolean moveAllowed(char[][] board, String input) {

        for (Map.Entry<String, int[]> entry : cell_indicators.entrySet()) {
            String pos = entry.getKey();
            if (input.equalsIgnoreCase(pos)) {
                int[] rowCol = entry.getValue();
                int row = rowCol[0];
                int col = rowCol[1];
                if (board[row][col] == '-') {
                    return true;
                }
            }
        }

        print("Invalid input");
        return false;
    }

    static void placeMove(char[][] board, String input, char symbol) {

        for (Map.Entry<String, int[]> entry : cell_indicators.entrySet()) {
            String pos = entry.getKey();
            if (input.equalsIgnoreCase(pos)) {

                int[] rowCol = entry.getValue();
                int row = rowCol[0];
                int col = rowCol[1];
                board[row][col] = symbol;

                break;
            }
        }

        print("Invalid input");
    }
}
