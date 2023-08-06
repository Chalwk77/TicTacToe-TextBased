/*

 - | - | -
---+---+---
 - | - | -
---+---+---
 - | - | -

*/

package com.chalwk;

import java.util.*;

public class Main {
    public static String header = "";
    static char player1 = 'X';
    static char player2 = 'O';
    static char empty = '-';
    static char[][][] boards = {

            // 3x3
            {
                    {empty, empty, empty},
                    {empty, empty, empty},
                    {empty, empty, empty}
            },

            // 4x4
            {
                    {empty, empty, empty, empty},
                    {empty, empty, empty, empty},
                    {empty, empty, empty, empty},
                    {empty, empty, empty, empty}
            },

            // 5x5
            {
                    {empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty}
            }
    };

    static Map<String, int[]> map;
    static String[][] positions = {
            {"A", "B", "C"},
            {"A", "B", "C", "D"},
            {"A", "B", "C", "D", "E"}
    };

    public static void main(String[] args) {

        char[][] board;
        map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        showStatus(0);
        board = pickABoard(scanner);

        scanner = new Scanner(System.in);

        printBoard(board, false);
        gameLoop(board, scanner);
        playAgain(scanner);

        scanner.close();
    }

    private static char[][] pickABoard(Scanner scanner) {

        print("Pick a board size: 3x3, 4x4, 5x5 (1, 2, 3 respectively)");
        char[][] board;
        while (true) {

            int userInput = scanner.nextInt();
            if (userInput <= 0 || userInput > boards.length) {
                print("Invalid input");
                continue;
            }
            board = boards[userInput - 1];

            for (int i = 0; i < board.length; i++) {
                String pos = positions[userInput - 1][i];
                for (int j = 0; j < board.length; j++) {
                    map.put(pos + (j + 1), new int[]{j, i});
                }
            }

            break;
        }
        return board;
    }

    private static void gameLoop(char[][] board, Scanner scanner) {
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
            } else if (userInput.equalsIgnoreCase("N")) {
                print("Thanks for playing!");
                break;
            } else {
                print("Invalid input");
            }
        }
    }

    private static boolean isGameFinished(char[][] board) {

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

    private static boolean getWinner(char[][] board, char symbol) {

        // Easier, cleaner way to do this:
        switch (board.length) {
            case 3 -> {

            }
        }

        switch (board.length) {
            case 3 -> {
                return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                        (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                        (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
                        (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                        (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                        (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
                        (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                        (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
            }
            case 4 -> {
                return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol && board[0][3] == symbol) ||
                        (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol && board[1][3] == symbol) ||
                        (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol && board[2][3] == symbol) ||
                        (board[3][0] == symbol && board[3][1] == symbol && board[3][2] == symbol && board[3][3] == symbol) ||
                        (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol && board[3][0] == symbol) ||
                        (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol && board[3][1] == symbol);
            }
            case 5 -> {
                return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol && board[0][3] == symbol && board[0][4] == symbol) ||
                        (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol && board[1][3] == symbol && board[1][4] == symbol) ||
                        (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol && board[2][3] == symbol && board[2][4] == symbol) ||
                        (board[3][0] == symbol && board[3][1] == symbol && board[3][2] == symbol && board[3][3] == symbol && board[3][4] == symbol) ||
                        (board[4][0] == symbol && board[4][1] == symbol && board[4][2] == symbol && board[4][3] == symbol && board[4][4] == symbol) ||
                        (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol && board[3][0] == symbol && board[4][0] == symbol) ||
                        (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol && board[3][1] == symbol && board[4][1] == symbol) ||
                        (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol && board[3][2] == symbol && board[4][2] == symbol) ||
                        (board[0][3] == symbol && board[1][3] == symbol && board[2][3] == symbol && board[3][3] == symbol && board[4][3] == symbol) ||
                        (board[0][4] == symbol && board[1][4] == symbol && board[2][4] == symbol && board[3][4] == symbol && board[4][4] == symbol) ||
                        (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol && board[3][3] == symbol && board[4][4] == symbol) ||
                        (board[0][4] == symbol && board[1][3] == symbol && board[2][2] == symbol && board[3][1] == symbol && board[4][0] == symbol);
            }
        }

        return false;
    }

    private static boolean isValidMove(char[][] board, String input) {

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            String pos = entry.getKey();
            if (input.equalsIgnoreCase(pos)) {
                int[] rowCol = entry.getValue();
                int row = rowCol[0];
                int col = rowCol[1];
                return board[row][col] == empty;
            }
        }

        return false;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        String computerMove;
        do {

            int LEN = board.length;
            String letter = positions[LEN - 1][rand.nextInt(LEN)];
            int num = rand.nextInt(LEN) + 1;
            computerMove = letter + num;

        } while (!isValidMove(board, computerMove));
        header = "Computer chose " + computerMove;
        placeMove(board, computerMove, player2);
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
        placeMove(board, userInput, player1);
    }

    private static void placeMove(char[][] board, String input, char symbol) {

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            String pos = entry.getKey();
            if (input.equalsIgnoreCase(pos)) {
                int[] rowCol = entry.getValue();
                int row = rowCol[0];
                int col = rowCol[1];
                board[row][col] = symbol;
                break;
            }
        }

        print("Invalid input");
    }

    private static void printBoard(char[][] board, boolean clear) {

        if (clear) {
            print("\n".repeat(50));
        }

        switch (board.length) {
            case 3 -> {
                print("  --A---B---C--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
                print("  |---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
                print("  |---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
                print("  |-----------|");
            }
            case 4 -> {
                // print with ABC 1234
                print("  --A---B---C---D--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " |");
                print("  |---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " |");
                print("  |---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " |");
                print("  |---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " |");
                print("  |---------------|");
            }
            case 5 -> {
                print("  --A---B---C---D---E--");
                print("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " |");
                print("  |---+---+---+---+---|");
                print("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " |");
                print("  |---+---+---+---+---|");
                print("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " |");
                print("  |---+---+---+---+---|");
                print("4 | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " |");
                print("  |---+---+---+---+---|");
                print("5 | " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " |");
                print("  |-------------------|");
            }
        }

        StringBuilder available = new StringBuilder("Make your move: ");

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            String pos = entry.getKey();
            int[] rowCol = entry.getValue();
            int row = rowCol[0];
            int col = rowCol[1];
            if (board[row][col] == empty) {
                available.append(pos).append(", ");
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