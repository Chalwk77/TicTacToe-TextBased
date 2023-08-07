package com.chalwk;

import java.util.Random;
import java.util.Scanner;

import static com.chalwk.GetWinner.getWinner;
import static com.chalwk.Main.showStatus;
import static com.chalwk.Moves.moveAllowed;
import static com.chalwk.Moves.placeMove;
import static com.chalwk.PrintBoard.printBoard;
import static com.chalwk.Variables.*;

public class GameLoop {

    private static void playerTurn(char[][] board, Scanner scanner) {

        String userInput = null;

        do {
            if (!scanner.hasNextLine()) {
                break;
            }
            userInput = scanner.nextLine();
        } while (!moveAllowed(board, userInput));

        placeMove(board, userInput, player1);
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        String computerMove;
        do {

            // todo: [FIX] there is a bug here.

            int LEN = board.length;
            int index = rand.nextInt(LEN);

            switch (LEN) {
                case 2 -> computerMove = positions[0][index] + (index + 1); // 2x2
                case 3 -> computerMove = positions[1][index] + (index + 1); // 3x3
                case 4 -> computerMove = positions[2][index] + (index + 1); // 4x4
                case 5 -> computerMove = positions[3][index] + (index + 1); // 5x5
                case 6 -> computerMove = positions[4][index] + (index + 1); // 6x6
                case 7 -> computerMove = positions[5][index] + (index + 1); // 7x7
                case 8 -> computerMove = positions[6][index] + (index + 1); // 8x8
                case 9 -> computerMove = positions[7][index] + (index + 1); // 9x9
                default -> throw new IllegalStateException("Board size not supported: (" + LEN + "x" + LEN + ")");
            }


        } while (!moveAllowed(board, computerMove));
        header = "Computer chose " + computerMove + "\n";
        placeMove(board, computerMove, player2);
    }

    private static boolean gameOver(char[][] board) {

        if (getWinner(board, player1)) {
            showStatus(1);
            return true;
        } else if (getWinner(board, player2)) {
            showStatus(2);
            return true;
        }

        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == empty) {
                    return false;
                }
            }
        }
        showStatus(3);

        return false;
    }

    static void gameLoop(char[][] board, Scanner scanner) {
        while (true) {

            playerTurn(board, scanner);
            if (gameOver(board)) {
                break;
            }
            printBoard(board, true);

            computerTurn(board);
            if (gameOver(board)) {
                break;
            }
            printBoard(board, true);
        }
    }
}
