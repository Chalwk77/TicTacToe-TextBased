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

    /**
     * Player turn.
     *
     * @param board   The current board
     * @param scanner The scanner
     *                Gets the user input from the scanner and checks if the move is allowed.
     *                If the move is allowed, the move is placed.
     *                If the move is not allowed, the user is prompted to try again.
     */
    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput = null;
        do {

            if (!scanner.hasNextLine()) {
                break;
            }
            userInput = scanner.nextLine();

        } while (!moveAllowed(board, userInput));

        assert userInput != null;
        placeMove(board, userInput, player1);
    }

    /**
     * Computer turn.
     *
     * @param board The current board
     *              The computer chooses a random cell and checks if the move is allowed.
     *              If the move is allowed, the move is placed.
     *              If the move is not allowed, the computer chooses another random cell and checks if the move is allowed.
     */
    private static void computerTurn(char[][] board) {

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        String computerMove;

        do {
            int randRow = rand.nextInt(board.length);
            int randCol = rand.nextInt(board.length);
            computerMove = letters[randRow] + (randCol + 1);
        } while (!moveAllowed(board, computerMove));

        computer_chose = "Computer chose " + computerMove + "\n";
        placeMove(board, computerMove, player2);
    }

    /**
     * Game over.
     *
     * @param board The current board.
     * @return true     If the game is over.
     * Checks if the game should end (displays the winner or a draw).
     */
    private static boolean gameOver(char[][] board) {

        int count = 0;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar != filler) {
                    count++;
                }
            }
        }

        if (count == board.length * board.length) {
            showStatus(3);
            return true;
        } if (getWinner(board, player1)) {
            showStatus(1);
            return true;
        } else if (getWinner(board, player2)) {
            showStatus(2);
            return true;
        }

        return false;
    }

    /**
     * Game loop.
     *
     * @param board   The current board
     * @param scanner The scanner
     *                The primary game loop.
     */
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
