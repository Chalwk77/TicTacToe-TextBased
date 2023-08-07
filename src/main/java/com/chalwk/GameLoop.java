package com.chalwk;

import java.util.Scanner;

import static com.chalwk.ComputerTurn.computerTurn;
import static com.chalwk.GameOver.gameOver;
import static com.chalwk.PlayerTurn.playerTurn;
import static com.chalwk.PrintBoard.printBoard;

public class GameLoop {
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
