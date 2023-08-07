package com.chalwk;

import java.util.Map;

import static com.chalwk.Main.*;
import static com.chalwk.Variables.empty;
import static com.chalwk.Variables.map;

public class Moves {

    static boolean moveAllowed(char[][] board, String input) {

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            String pos = entry.getKey();
            if (input.equalsIgnoreCase(pos)) {
                int[] rowCol = entry.getValue();
                int row = rowCol[0];
                int col = rowCol[1];
                return board[row][col] == empty;
            }
        }

        return false;
    }

    static void placeMove(char[][] board, String input, char symbol) {

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
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
