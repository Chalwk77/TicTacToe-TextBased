/*

// COMING IN A FUTURE UPDATE:
// Multi-dimensional Tic Tac Toe game - Win 3 boards in a row, for example, boards 1, 5 and 9 to win the game.

 - | - | -      - | - | -       - | - | -
---+---+---    ---+---+---     ---+---+---
 - | X | -      - | - | -       - | - | -
---+---+---    ---+---+---     ---+---+---
 - | - | -      - | - | -       - | - | -

 - | - | -      - | - | -       - | - | -
---+---+---    ---+---+---     ---+---+---
 - | - | -      - | X | -       - | - | -
---+---+---    ---+---+---     ---+---+---
 - | - | -      - | - | -       - | - | -

 - | - | -      - | - | -       - | - | -
---+---+---    ---+---+---     ---+---+---
 - | - | -      - | - | -       - | X | -
---+---+---    ---+---+---     ---+---+---
 - | - | -      - | - | -       - | - | -

*/

package com.chalwk;

import java.util.HashMap;
import java.util.Scanner;

import static com.chalwk.BoardPicker.pickABoard;
import static com.chalwk.GameLoop.gameLoop;
import static com.chalwk.PlayAgain.playAgain;
import static com.chalwk.PrintBoard.printBoard;
import static com.chalwk.Variables.cell_indicators;

public class Main {

    public static void main(String[] args) {

        char[][] board;
        cell_indicators = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        showStatus(0);
        board = pickABoard(scanner);

        scanner = new Scanner(System.in);

        printBoard(board, false);
        gameLoop(board, scanner);
        playAgain(scanner);

        scanner.close();
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