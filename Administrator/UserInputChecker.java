package com.Administrator;

import java.util.Set;
import java.util.Scanner;

public class UserInputChecker {
    Scanner input2 = new Scanner(System.in);                                              // Import scanner for input retries

    String newShape;                                                                      // Global variable because it eliminates buffer errors and used for recursion
    public String shapeCheck(String shape) {
        Set<String> shapes = Set.of("square", "triangle", "diamond");
        newShape = shape.trim().replaceAll("\\s","").toLowerCase();       // No white spaces anywhere and all lowercase
        if (!(shapes.contains(newShape))) {                                               // Checks the set for the shape entered
            System.out.println("I'm sorry, please enter either a circle, triangle, diamond or square.");
            newShape = input2.nextLine();
            shapeCheck(newShape);                                                         // Calls the function once more
        }
        return newShape;
    }

    private int heightCheck;                                                              // Placed as global variable due to recursion
    public int heightCheck(String height) {                                               // Checks the height input from the user
        if (height.isEmpty() || !height.matches(".*\\d.*")) {
            System.out.println("I'm sorry, I didn't understand that. Please enter a positive integer");
            height = input2.nextLine();                                                   // Asks for another input if first one is invalid
            heightCheck(height);                                                          // Calls the function again if need be
        } else {
            height.trim();
            heightCheck = Integer.parseInt(height);                                       // Converts to String after trimmed and filtered to integer
        }
        return heightCheck;
    }

    public String labelCheck(String label) {                                              // Checks to see if user entered in label
        String labelChecked;
        if (label.isEmpty()) {
            labelChecked = "LU";                                                          // Defaults to LU if nothing entered
        } else {
            labelChecked = label;
        }
        return labelChecked;
    }

    public int rowCheck(String row) {                                                     // Checks the row input
        int rowCheck;
        if (row.isEmpty()) {                                                              // Checks if the row input is empty
            rowCheck = 4;                                                                 // Defaults to 4
        } else {
            rowCheck = Integer.parseInt(row);                                             // Converts String to Integer
        }
        return rowCheck;
    }
}
