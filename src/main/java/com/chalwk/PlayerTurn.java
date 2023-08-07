package com.chalwk;

import java.util.Scanner;

import static com.chalwk.Main.print;
import static com.chalwk.Moves.moveAllowed;
import static com.chalwk.Moves.placeMove;
import static com.chalwk.Variables.player1;

public class PlayerTurn {

    static void playerTurn(char[][] board, Scanner scanner) {

        String userInput = null;

        do {
            if (!scanner.hasNextLine()) {
                break;
            }
            userInput = scanner.nextLine();
        } while (!moveAllowed(board, userInput));

        placeMove(board, userInput, player1);
    }
}
