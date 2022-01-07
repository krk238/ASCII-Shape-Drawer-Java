package com.Administrator;

import java.util.Scanner;

public class ASCII_Drawer {
    Scanner input = new Scanner(System.in);                                                   // Import Scanner class for user input
    UserInputChecker inputChecker = new UserInputChecker();                                   // Class to check the users' inputs

    String shape;
    String enterHeightTr;
    String label;
    String enterRowTr;
    String repeat;

    public ASCII_Drawer() {                                                                   // Constructor
        shape_Drawer_Input();
        System.out.println("Would you like to print another shape? Enter Y or N uppercase");  // Ask to repeat the shape construction
        repeat = input.nextLine();
        if (repeat.equals("Y")) {                                                             // Only if response is yes, will it repeat
            shape_Drawer_Input();                                                             // Recursion call to shape drawer
        }
    }

    public void shape_Drawer_Input() {                                                        // Constructor starts the ASCII shape building when class instantiates
        System.out.println("What shape do you want to draw?");                                // We ask the user for the shape
        shape = input.nextLine();
        String shapeChecked = inputChecker.shapeCheck(shape);
        System.out.println("Enter the height of the shape.");                                 // We ask the user for the shape's height
        enterHeightTr = input.nextLine();
        int heightChecked = inputChecker.heightCheck(enterHeightTr);
        System.out.println("What label should I print on this " + shapeChecked + "? Make sure it is less than " + enterHeightTr + " letters long.");        // Ask for the user's display label
        label = input.nextLine();
        String labelDispalyed = inputChecker.labelCheck(label);
        System.out.println("On what row should we print " + labelDispalyed + "?");            // Ask for the row
        enterRowTr = input.nextLine();
        int rowChecked = inputChecker.rowCheck(enterRowTr);
        shapeDrawer(shapeChecked, heightChecked, labelDispalyed, rowChecked);
        System.out.println();                                                                 // Creates space below drawing
        System.out.println();                                                                 // Creates space below drawing


    }

    public void shapeDrawer(String enterShape, int enterHeight, String enterLabel, int enterRow) {
        switch(enterShape) {
            case "square":
                drawSquare(enterHeight, enterLabel, enterRow);
                break;

            case "triangle":
                drawTriangle(enterHeight, enterLabel, enterRow);
                break;

            case "diamond":
                drawDiamond(enterHeight, enterLabel, enterRow);
                break;
        }
    }

    public void drawSquare(int enterHeightSq, String enterLabelSq, int enterRowSq) {            // When is called, draws a square
        int offsetLeft;                                                                         // Number of asterisks left of the label
        int offsetRight;                                                                        // Number of asterisks right of the label
        int totalOffset = enterHeightSq - enterLabelSq.length();                                // Total number of asterisks left and right of label
        if (totalOffset == 0) {
            offsetLeft = offsetRight = totalOffset / 2;
        }
        else {
            offsetLeft = (totalOffset - 1) / 2;
            offsetRight = totalOffset - offsetLeft;
        }
        int rightWordBound = enterLabelSq.length() + offsetLeft;                                // Index right of the label
        int wordIndex = 0;
        for (int x = 1; x <= enterHeightSq; x++) {                                              // Begin building the square based off its height
            System.out.println();                                                               // New line every iteration
            if (x == enterRowSq) {                                                              // If the row entered matches the current line
                for (int y2 = 0; y2 < enterHeightSq - 1; y2++) {
                    if (y2 <= offsetLeft) {                                                     // Prints asterisks left of label
                        System.out.print("* ");
                    }
                    if (y2 > offsetLeft && y2 <= rightWordBound) {
                        System.out.print(enterLabelSq.charAt(wordIndex) + " ");                 // Prints label
                        wordIndex++;
                    }
                    if (y2 >= rightWordBound) {                                                 // Print asterisks right of label
                        System.out.print("* ");
                    }
                }
            }
            else {for (int y = 0; y < enterHeightSq; y++) {                                     // When not print the label, prints asterisks
                System.out.print("* ");
                }
            }
        }
    }

    public void drawTriangle(int enterHeightTr, String enterLabelTr, int enterRowTr) {          // When is called, draws a triangle
        int midHeightTr = enterHeightTr % 2;                                                    // Used to gauge how many spaces before printing asterisks
        int numBlankPerLineTr = enterHeightTr;

        for (int x = 1; x <= enterHeightTr; x++) {                                              // Begins Drawing Triangle
            System.out.println();                                                               // Prints new line
            int numBlankTr = numBlankPerLineTr;                                                 // Made global in reference to 1st for loop, so the change remains permanent
            if (enterRowTr == x) {                                                              // If line equals the row we want to put label on
                for (int spaces1 = 1; spaces1 <= numBlankPerLineTr; spaces1++) {
                    System.out.print("  ");
                }
                for (int charIndex = 0; charIndex < enterLabelTr.length(); charIndex++) {
                    System.out.print(enterLabelTr.charAt(charIndex) + "  ");
                }
                numBlankPerLineTr--;                                                            // -1 because now we move on to the next line
                continue;
            }
            for (int blank = numBlankTr; blank > 0; blank--) {                                 // Print spaces
                System.out.print("  ");
                numBlankTr--;
            }
            numBlankPerLineTr--;                                                               // -1 because now we have taken care of printing the spaces and will do 1 less next iteration
            for (int numAst = 1; numAst <= x; numAst++) {                                      // Prints the asterisks
                System.out.print("*   ");
            }
        }
    }

    public void drawDiamond(int enterHeightD, String enterLabelD, int enterRowD) {               // When is called, draws a diamond
        int midHeight = enterHeightD % 2;
        if (midHeight == 0) {
            enterHeightD++;
        }
                                                                                                 // First Triangle
        int numBlankPerLine = ((enterHeightD - 1) / 2);
        for (int x = 1; x <= ((enterHeightD - 1) / 2 + 1); x++) {
            System.out.println();

            int numBlank = numBlankPerLine;

            if (enterRowD == x) {
                for (int spaces1 = 1; spaces1 <= numBlankPerLine; spaces1++) {
                    System.out.print("  ");
                }
                for (int charIndex = 0; charIndex < enterLabelD.length(); charIndex++) {
                    System.out.print(enterLabelD.charAt(charIndex) + "  ");
                }
                numBlankPerLine--;
                continue;
            }
            for (int blank = numBlank; blank > 0; blank--) {
                System.out.print("  ");
                numBlank--;
            }
            numBlankPerLine--;
            for (int numAst = 1; numAst <= x; numAst++) {
                System.out.print("*   ");
            }
        }
                                                                                                   // Second Upside down Triangle
        int numBlankPerLine2 = ((enterHeightD - 1) / 2);

        for (int x2 = 1; x2 <= ((enterHeightD - 1) / 2); x2++) {
            System.out.println();

            if (enterRowD == x2 + ((enterHeightD - 1) / 2 + 1)) {
                for (int spaces2 = 1; spaces2 <= numBlankPerLine; spaces2++) {
                    System.out.print("  ");
                }
                for (int charIndex = 0; charIndex < enterLabelD.length(); charIndex++) {
                    System.out.print(enterLabelD.charAt(charIndex) + "  ");
                }
                numBlankPerLine2--;
                continue;
            }

            for (int blanks2 = 1; blanks2 <= x2; blanks2++) {
                System.out.print("  ");
            }

            int numBlank2 = numBlankPerLine2;
            for (int numAst2 = numBlank2; numAst2 > 0; numAst2--) {
                System.out.print("*   ");
                numBlank2--;
            }
            numBlankPerLine2--;
        }
    }
}
