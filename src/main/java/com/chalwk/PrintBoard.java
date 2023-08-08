package com.chalwk;

import java.util.Map;

import static com.chalwk.Main.print;
import static com.chalwk.Variables.*;

public class PrintBoard {

    /***
     * Board printer.
     *
     * @param board The board to print
     * @param clear Whether to clear the console before printing
     */
    static void printBoard(char[][] board, boolean clear) {

        if (clear) {
            print("\n".repeat(50));
        }

        printLetters(board);
        int len = board.length;
        switch (len) {
            case 3 -> board1(board);
            case 4 -> board2(board);
            case 5 -> board3(board);
            case 6 -> board4(board);
            case 7 -> board5(board);
            case 8 -> board6(board);
            case 9 -> board7(board);
            default -> throw new IllegalStateException("Board size not supported: (" + len + "x" + len + ")");
        }
        printCellIndicators(board);
    }

    /***
     * Board printer for 3x3.
     * @param b The board to print
     */
    private static void board1(char[][] b) {
        for (int i = 0; i < 3; i++) {
            print((i + 1) + " | " + b[i][0] + " | " + b[i][1] + " | " + b[i][2] + " |");
            if (i != 2) {
                print("  |---+---+---|");
            }
        }
    }

    /***
     * Board printer for 4x4.
     * @param b The board to print
     */
    private static void board2(char[][] b) {
        for (int i = 0; i < 4; i++) {
            print((i + 1) + " | " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]
                    + " | " + b[i][3] + " |");
            if (i != 3) {
                print("  |---+---+---+---|");
            }
        }
    }

    /***
     * Board printer for 5x5.
     * @param b The board to print
     */
    private static void board3(char[][] b) {
        for (int i = 0; i < 5; i++) {
            print((i + 1) + " | " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]
                    + " | " + b[i][3] + " | " + b[i][4] + " |");
            if (i != 4) {
                print("  |---+---+---+---+---|");
            }
        }
    }

    /***
     * Board printer for 6x6.
     * @param b The board to print
     */
    private static void board4(char[][] b) {
        for (int i = 0; i < 6; i++) {
            print((i + 1) + " | " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]
                    + " | " + b[i][3] + " | " + b[i][4] + " | " + b[i][5] + " |");
            if (i != 5) {
                print("  |---+---+---+---+---+---|");
            }
        }
    }

    /***
     * Board printer for 7x7.
     * @param b The board to print
     */
    private static void board5(char[][] b) {
        for (int i = 0; i < 7; i++) {
            print((i + 1) + " | " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]
                    + " | " + b[i][3] + " | " + b[i][4] + " | " + b[i][5]
                    + " | " + b[i][6] + " |");
            if (i != 6) {
                print("  |---+---+---+---+---+---+---|");
            }
        }
    }

    /***
     * Board printer for 8x8.
     * @param b The board to print
     */
    private static void board6(char[][] b) {
        for (int i = 0; i < 8; i++) {
            print((i + 1) + " | " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]
                    + " | " + b[i][3] + " | " + b[i][4] + " | " + b[i][5]
                    + " | " + b[i][6] + " | " + b[i][7] + " |");
            if (i != 7) {
                print("  |---+---+---+---+---+---+---+---|");
            }
        }
    }

    /***
     * Board printer for 9x9.
     * @param b The board to print
     */
    private static void board7(char[][] b) {
        for (int i = 0; i < 9; i++) {
            print((i + 1) + " | " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]
                    + " | " + b[i][3] + " | " + b[i][4] + " | " + b[i][5]
                    + " | " + b[i][6] + " | " + b[i][7] + " | " + b[i][8] + " |");
            if (i != 8) {
                print("  |---+---+---+---+---+---+---+---+---|");
            }
        }
    }

    /***
     * Letter to number conversion, printer.
     * Prints the letters on the top of the board.
     * @param board The current board
     */
    public static void printLetters(char[][] board) {
        StringBuilder chars = new StringBuilder("    ");
        for (int i = 0; i < board.length; i++) {
            chars.append(letters[i]).append("   ");
        }
        print(chars.toString());
    }

    /***
     * Prints cell numbers on the left side of the board.
     * @param board The current board
     */
    private static void printCellIndicators(char[][] board) {

        StringBuilder available = new StringBuilder("Make your move:\n");
        int count = 0;

        for (Map.Entry<String, int[]> entry : cell_indicators.entrySet()) {
            String pos = entry.getKey();

            int[] rowCol = entry.getValue();
            int row = rowCol[0];
            int col = rowCol[1];

            count++;
            if (count % 10 == 0) {
                available.append("\n");
            } else if (board[row][col] == filler) {
                available.append(pos).append(", ");
            }
        }

        System.out.println(computer_chose);
        System.out.println(available);
    }
}
