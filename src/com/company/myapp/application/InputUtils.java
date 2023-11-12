package com.company.myapp.application;

import java.util.Scanner;

public class InputUtils {
    private final static Scanner scanner = new Scanner(System.in);

    public static int getMenuInput(String message, int maxOption) {
        int option;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                if (option >= 0 && option <= maxOption) {
                    break;
                } else {
                    System.out.println("Invalid option. Please select a valid option (0-" + maxOption + ").");
                }
            } else {
                System.out.println("Input must be an integer.");
            }
        }

        clearScannerBuffer();
        return option;
    }

    public static int getUserInputInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static double getUserInputDouble(String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    public static String getUserInputString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    public static String getUserInputLine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static void clearScannerBuffer() {
        scanner.nextLine();
    }
}