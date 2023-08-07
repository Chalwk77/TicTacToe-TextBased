package com.chalwk;

import java.util.Scanner;

import static com.chalwk.Main.print;
import static com.chalwk.Moves.moveAllowed;
import static com.chalwk.Moves.placeMove;
import static com.chalwk.Variables.player1;

public class PlayerTurn {

    static void playerTurn(char[][] board, Scanner scanner) {

        String userInput;
        while (true) {
            userInput = scanner.nextLine();
            if (moveAllowed(board, userInput)) {
                break;
            } else {
                print(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, player1);
    }
}
