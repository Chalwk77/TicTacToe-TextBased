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
     *                Gets the user input and checks if the move is allowed.
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
     *              Gets the computers input and checks if the move is allowed.
     */
    private static void computerTurn(char[][] board) {

        Random rand = new Random();
        String computerMove;

        // fixme: computer always chooses cells diagonally.
        do {
            int LEN = board.length;
            int index = rand.nextInt(LEN);
            computerMove = letters[index] + (index + 1);
        } while (!moveAllowed(board, computerMove));

        computer_chose = "Computer chose " + computerMove + "\n";
        placeMove(board, computerMove, player2);
    }

    /**
     * Game over.
     *
     * @param board The current board.
     * @return true,  If the game is over.
     * Checks if the game is over / Shows the winner / Shows a draw.
     */
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
                if (aChar == '-') {
                    return false;
                }
            }
        }
        showStatus(3);

        return false;
    }


    /**
     * Game over.
     *
     * @param board   The board
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
