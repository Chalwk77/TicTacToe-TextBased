package com.chalwk;

import java.util.Scanner;

import static com.chalwk.Main.main;
import static com.chalwk.Main.print;

public class PlayAgain {
    static void playAgain(Scanner scanner) {
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
}