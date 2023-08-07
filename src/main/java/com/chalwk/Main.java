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

import java.util.*;
import java.util.stream.Collectors;

import static com.chalwk.GetWinner.getWinner;
import static com.chalwk.PrintBoard.printBoard;

public class Main {
    public static String header = "";
    static char player1 = 'X';
    static char player2 = 'O';
    static char empty = '-';
    static char[][][] boards = {

            //2x2:
            {
                    {empty, empty},
                    {empty, empty}
            },

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
            },

            // 6x6
            {
                    {empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty},
            },

            //7x7
            {
                    {empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty},
            },

            //8x8
            {
                    {empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty},
            },

            //9x9
            {
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
                    {empty, empty, empty, empty, empty, empty, empty, empty, empty},
            }
    };

    static Map<String, int[]> map;
    static String[][] positions = {
            {"A", "B"},
            {"A", "B", "C"},
            {"A", "B", "C", "D"},
            {"A", "B", "C", "D", "E"},
            {"A", "B", "C", "D", "E", "F"},
            {"A", "B", "C", "D", "E", "F", "G"},
            {"A", "B", "C", "D", "E", "F", "G", "H"},
            {"A", "B", "C", "D", "E", "F", "G", "H", "I"},
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"}
    };

    static int[][][] WINNING_COMBINATIONS = {

            // 2x2:
            {
                    {0, 1}, {2, 3}, // rows

                    {0, 2}, {1, 3}, // columns

                    {0, 3}, {1, 2} // diagonals
            },

            // 3x3:
            {
                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows

                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns

                    {0, 4, 8}, {2, 4, 6} // diagonals
            },

            //4x4:
            {
                    {0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}, // rows

                    {0, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, // columns

                    {0, 5, 10, 15}, {3, 6, 9, 12} // diagonals
            },

            //5x5:
            {
                    {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24}, // rows

                    {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24}, // columns

                    {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20} // diagonals
            },

            //6x6:
            {
                    {0, 1, 2, 3, 4, 5}, {6, 7, 8, 9, 10, 11}, {12, 13, 14, 15, 16, 17}, // rows
                    {18, 19, 20, 21, 22, 23}, {24, 25, 26, 27, 28, 29}, {30, 31, 32, 33, 34, 35},
                    {0, 6, 12, 18, 24, 30}, {1, 7, 13, 19, 25, 31}, {2, 8, 14, 20, 26, 32},

                    {3, 9, 15, 21, 27, 33}, {4, 10, 16, 22, 28, 34}, {5, 11, 17, 23, 29, 35}, // columns

                    {0, 7, 14, 21, 28, 35}, {5, 10, 15, 20, 25, 30} // diagonals
            },

            // 7x7:
            {
                    {0, 1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12, 13}, {14, 15, 16, 17, 18, 19, 20}, // rows
                    {21, 22, 23, 24, 25, 26, 27}, {28, 29, 30, 31, 32, 33, 34}, {35, 36, 37, 38, 39, 40, 41},
                    {42, 43, 44, 45, 46, 47, 48},

                    {0, 7, 14, 21, 28, 35, 42}, {1, 8, 15, 22, 29, 36, 43}, {2, 9, 16, 23, 30, 37, 44}, // columns
                    {3, 10, 17, 24, 31, 38, 45}, {4, 11, 18, 25, 32, 39, 46}, {5, 12, 19, 26, 33, 40, 47},
                    {6, 13, 20, 27, 34, 41, 48},

                    {0, 8, 16, 24, 32, 40, 48}, {6, 12, 18, 24, 30, 36, 42} // diagonals
            },

            // 8x8:
            {
                    {0, 1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14, 15}, {16, 17, 18, 19, 20, 21, 22, 23}, // rows
                    {24, 25, 26, 27, 28, 29, 30, 31}, {32, 33, 34, 35, 36, 37, 38, 39}, {40, 41, 42, 43, 44, 45, 46, 47},
                    {48, 49, 50, 51, 52, 53, 54, 55}, {56, 57, 58, 59, 60, 61, 62, 63},

                    {0, 8, 16, 24, 32, 40, 48, 56}, {1, 9, 17, 25, 33, 41, 49, 57}, {2, 10, 18, 26, 34, 42, 50, 58}, // columns
                    {3, 11, 19, 27, 35, 43, 51, 59}, {4, 12, 20, 28, 36, 44, 52, 60}, {5, 13, 21, 29, 37, 45, 53, 61},
                    {6, 14, 22, 30, 38, 46, 54, 62}, {7, 15, 23, 31, 39, 47, 55, 63},

                    {0, 9, 18, 27, 36, 45, 54, 63}, {7, 14, 21, 28, 35, 42, 49, 56} // diagonals
            },

            // 9x9:
            {
                    {0, 1, 2, 3, 4, 5, 6, 7, 8}, {9, 10, 11, 12, 13, 14, 15, 16, 17}, {18, 19, 20, 21, 22, 23, 24, 25, 26},// rows
                    {27, 28, 29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42, 43, 44},
                    {45, 46, 47, 48, 49, 50, 51, 52, 53}, {54, 55, 56, 57, 58, 59, 60, 61, 62},
                    {63, 64, 65, 66, 67, 68, 69, 70, 71}, {72, 73, 74, 75, 76, 77, 78, 79, 80},

                    {0, 9, 18, 27, 36, 45, 54, 63, 72}, {1, 10, 19, 28, 37, 46, 55, 64, 73}, // columns
                    {2, 11, 20, 29, 38, 47, 56, 65, 74}, {3, 12, 21, 30, 39, 48, 57, 66, 75},
                    {4, 13, 22, 31, 40, 49, 58, 67, 76}, {5, 14, 23, 32, 41, 50, 59, 68, 77},
                    {6, 15, 24, 33, 42, 51, 60, 69, 78}, {7, 16, 25, 34, 43, 52, 61, 70, 79},
                    {8, 17, 26, 35, 44, 53, 62, 71, 80},

                    {0, 10, 20, 30, 40, 50, 60, 70, 80}, {8, 16, 24, 32, 40, 48, 56, 64, 72} // diagonals
            }
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

        print("Pick a board size:");
        print("1 - 2x2     2 - 3x3     3 - 4x4     4 - 5x5");
        print("5 - 6x6     6 - 7x7     7 - 8x8     8 - 9x9");

        char[][] board;
        while (true) {

            int userInput = scanner.nextInt();
            if (userInput <= 0 || userInput > boards.length) {
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

    private static boolean moveAllowed(char[][] board, String input) {

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
            switch (LEN) {
                case 2 -> computerMove = positions[0][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                case 3 -> computerMove = positions[1][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                case 4 -> computerMove = positions[2][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                case 5 -> computerMove = positions[3][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                case 6 -> computerMove = positions[4][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                case 7 -> computerMove = positions[5][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                case 8 -> computerMove = positions[6][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                case 9 -> computerMove = positions[7][rand.nextInt(LEN)] + (rand.nextInt(LEN) + 1);
                default -> throw new IllegalStateException("Unexpected value: " + LEN);
            }

        } while (!moveAllowed(board, computerMove));
        header = "Computer chose " + computerMove;
        placeMove(board, computerMove, player2);
    }

    private static void playerTurn(char[][] board, Scanner scanner) {

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