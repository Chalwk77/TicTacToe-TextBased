package com.chalwk;

import java.util.Random;

import static com.chalwk.Main.*;
import static com.chalwk.Moves.moveAllowed;
import static com.chalwk.Moves.placeMove;

public class ComputerTurn {

    static void computerTurn(char[][] board) {
        Random rand = new Random();
        String computerMove;
        do {
            int LEN = board.length;
            int index = rand.nextInt(LEN);
            switch (LEN) {
                case 2 -> computerMove = positions[0][index] + (index + 1);
                case 3 -> computerMove = positions[1][index] + (index + 1);
                case 4 -> computerMove = positions[2][index] + (index + 1);
                case 5 -> computerMove = positions[3][index] + (index + 1);
                case 6 -> computerMove = positions[4][index] + (index + 1);
                case 7 -> computerMove = positions[5][index] + (index + 1);
                case 8 -> computerMove = positions[6][index] + (index + 1);
                case 9 -> computerMove = positions[7][index] + (index + 1);
                default -> throw new IllegalStateException("Board size not supported: (" + LEN + "x" + LEN + ")");
            }

        } while (!moveAllowed(board, computerMove));
        header = "Computer chose " + computerMove;
        placeMove(board, computerMove, player2);
    }
}
