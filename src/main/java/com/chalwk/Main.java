/*

 - | - | -
---+---+---
 - | - | -
---+---+---
 - | - | -

*/

package com.chalwk;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String header = "";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}};

        showStatus(0);
        printBoard(board, false);

        while (true) {

            playerTurn(board, scanner);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board, true);

            computerTurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board, true);
        }

        while (true) {

            print("Play again? (Y/N)");
            if (!scanner.hasNextLine()) {
                break;
            }

            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("Y")) {
                main(null);
            } else if (userInput.equalsIgnoreCase("N")) {
                print("Thanks for playing!");
                break;
            } else {
                print("Invalid input");
            }
        }

        scanner.close();
    }

    private static boolean isGameFinished(char[][] board) {

        if (getWinner(board, 'X')) {
            showStatus(1);
            return true;
        } else if (getWinner(board, 'O')) {
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

    private static boolean getWinner(char[][] board, char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        do {
            computerMove = rand.nextInt(9) + 1;
        } while (!isValidMove(board, Integer.toString(computerMove)));
        header = "Computer chose " + computerMove;
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove(char[][] board, String position) {
        return switch (position) {
            case "1" -> (board[0][0] == '-');
            case "2" -> (board[0][1] == '-');
            case "3" -> (board[0][2] == '-');
            case "4" -> (board[1][0] == '-');
            case "5" -> (board[1][1] == '-');
            case "6" -> (board[1][2] == '-');
            case "7" -> (board[2][0] == '-');
            case "8" -> (board[2][1] == '-');
            case "9" -> (board[2][2] == '-');
            default -> false;
        };
    }

    private static void playerTurn(char[][] board, Scanner scanner) {

        String userInput;
        while (true) {
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                print(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default -> print("Invalid input");
        }
    }

    private static void printBoard(char[][] board, boolean clear) {

        if (clear) {
            print("\n".repeat(50));
        }

        print(board[0][0] + "  | " + board[0][1] + " | " + board[0][2]);
        print("---+---+---");
        print(board[1][0] + "  | " + board[1][1] + " | " + board[1][2]);
        print("---+---+---");
        print(board[2][0] + "  | " + board[2][1] + " | " + board[2][2]);

        StringBuilder available = new StringBuilder("Make your move: ");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    if (i == board.length - 1 && j == board[i].length - 1) {
                        available.append((i * board.length + j + 1));
                        break;
                    }
                    available.append((i * board.length + j + 1)).append(", ");
                }
            }
        }
        System.out.println(header);
        System.out.println(available);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void showStatus(int status) {
        System.out.println("\n".repeat(50));
        switch (status) {
            case 0 -> System.out.println("""
                    ___    __     ___       __     ___  __   ___
                     |  | /  `     |   /\\  /  `     |  /  \\ |__
                     |  | \\__,     |  /~~\\ \\__,     |  \\__/ |___
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