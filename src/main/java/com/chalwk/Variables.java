package com.chalwk;

import java.util.HashMap;
import java.util.Map;

public class Variables {

    public static String header = "";
    public static char player1 = 'X';
    public static char player2 = 'O';
    public static char empty = '-';
    public static Map<String, int[]> cell_indicators = new HashMap<>();
    public static char[][][] boards;

    public static String[][] positions = {
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
    public static void resetBoards(){

        boards = new char[][][]{

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
    }

    public static int[][][] WINNING_COMBINATIONS = {

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
}
