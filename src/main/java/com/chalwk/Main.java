/*

// COMING IN A FUTURE UPDATE:
// Win 3 boards in a row, for example, boards 1, 5 and 9 to win the game.

      A   B   C       A   B   C       A   B   C
  1 | - | - | - |   | - | - | - |   | - | - | - |
    |---+---+---|   |---+---+---|   |---+---+---|
  2 | - | - | - |   | - | - | - |   | - | - | - |
    |---+---+---|   |---+---+---|   |---+---+---|
  3 | - | - | - |   | - | - | - |   | - | - | - |

      A   B   C       A   B   C       A   B   C
  1 | - | - | - |   | - | - | - |   | - | - | - |
    |---+---+---|   |---+---+---|   |---+---+---|
  2 | - | - | - |   | - | - | - |   | - | - | - |
    |---+---+---|   |---+---+---|   |---+---+---|
  3 | - | - | - |   | - | - | - |   | - | - | - |

      A   B   C       A   B   C       A   B   C
  1 | - | - | - |   | - | - | - |   | - | - | - |
    |---+---+---|   |---+---+---|   |---+---+---|
  2 | - | - | - |   | - | - | - |   | - | - | - |
    |---+---+---|   |---+---+---|   |---+---+---|
  3 | - | - | - |   | - | - | - |   | - | - | - |

*/

package com.chalwk;

import java.util.Scanner;

import static com.chalwk.BoardPicker.pickABoard;
import static com.chalwk.GameLoop.gameLoop;
import static com.chalwk.PrintBoard.printBoard;

public class Main {

    /***
     * Main method - Entry point
     * Starts the game.
     * @see BoardPicker#pickABoard(Scanner)
     * @see PrintBoard#printBoard(char[][], boolean)
     * @see GameLoop#gameLoop(char[][], Scanner)
     * @see #playAgain(Scanner)
     * @param args The program arguments (unused)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        showStatus(0);
        char[][] board = pickABoard(scanner);

        scanner = new Scanner(System.in);

        printBoard(board, false);
        gameLoop(board, scanner);
        playAgain(scanner);

        scanner.close();
    }

    /***
     * Play again?
     * @param scanner The scanner
     *                Asks the user if they want to play again.
     *                If yes, restarts the game.
     *                If no, exits the game.
     *                If invalid input, asks again.
     */
    private static void playAgain(Scanner scanner) {
        while (true) {

            print("Play again? (Y/N)");
            if (!scanner.hasNextLine()) {
                break;
            }

            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("Y")) {
                main(null);
                break;
            } else if (userInput.equalsIgnoreCase("N")) {
                print("Thanks for playing!");
                break;
            } else {
                print("Invalid input");
            }
        }
    }

    /***
     * Prints a string
     * @param s The string to print
     */
    public static void print(String s) {
        System.out.println(s);
    }

    /***
     * Status screen.
     * @param status The status to print (0 = title screen, 1 = win, 2 = lose, 3 = draw)
     *               Prints the status.
     */
    public static void showStatus(int status) {
        System.out.println("\n".repeat(50));
        switch (status) {
            case 0 -> System.out.println("""
                    ________________________________________________
                    Copyright (c) 2023, Tic Tac Toe, Jericho Crosby
                    ___    __     ___       __     ___  __   ___
                     |  | /  `     |   /\\  /  `     |  /  \\ |__
                     |  | \\__,     |  /~~\\ \\__,     |  \\__/ |___
                    ________________________________________________
                    """);
            case 1 -> System.out.println("""
                         __
                    \\ / /  \\ |  |    |  | | |\\ |
                     |  \\__/ \\__/    |/\\| | | \\|
                    """);
            case 2 -> System.out.println("""
                         __                __   __   ___
                    \\ / /  \\ |  |    |    /  \\ /__` |__
                     |  \\__/ \\__/    |___ \\__/ .__/ |___
                    """);
            case 3 -> System.out.println("""
                    ___    ___
                     |  | |__
                     |  | |___
                    """);
        }
    }
}