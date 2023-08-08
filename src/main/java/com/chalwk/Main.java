/*

// COMING IN A FUTURE UPDATE:
// Multi-dimensional Tic Tac Toe game - Win 3 boards in a row, for example, boards 1, 5 and 9 to win the game.

     A   B   C      A   B   C       A   B   C
  1  - | - | -      - | - | -       - | - | -
    ---+---+---    ---+---+---     ---+---+---
  2  - | X | -      - | - | -       - | - | -
    ---+---+---    ---+---+---     ---+---+---
  3  - | - | -      - | - | -       - | - | -

     A   B   C      A   B   C       A   B   C
  1  - | - | -      - | - | -       - | - | -
    ---+---+---    ---+---+---     ---+---+---
  2  - | X | -      - | - | -       - | - | -
    ---+---+---    ---+---+---     ---+---+---
  3  - | - | -      - | - | -       - | - | -

     A   B   C      A   B   C       A   B   C
  1  - | - | -      - | - | -       - | - | -
    ---+---+---    ---+---+---     ---+---+---
  2  - | X | -      - | - | -       - | - | -
    ---+---+---    ---+---+---     ---+---+---
  3  - | - | -      - | - | -       - | - | -

*/

package com.chalwk;

import java.util.Scanner;

import static com.chalwk.BoardPicker.pickABoard;
import static com.chalwk.GameLoop.gameLoop;
import static com.chalwk.PrintBoard.printBoard;

public class Main {

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

    public static void print(String s) {
        System.out.println(s);
    }

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