import java.util.regex.*;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Third_A {

    private static int iterator = 1;
    private static int sum = 0;
    private static int height = 142;
    private static int width = 142;
    private static char[][] engine = new char[height][width];

    public static void main(String[] args) {
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = " " + myReader.nextLine() + " ";
                engine[iterator] = data.toCharArray();
                iterator++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        searchForNumbers(engine);
        System.out.println(sum);
    }

    private static int searchForNumbers(char[][] engine) {
        for (int row = 1; row < height - 1; row++) {
            for (int column = 1; column < width - 1; column++) {
                if (engine[row][column] >= 48 && engine[row][column] <= 57) {
                    boolean isSignNear = false;
                    int number = 0;
                    while (engine[row][column] >= 48 && engine[row][column] <= 57) {
                        if (/**/isSign(engine[row + 1][column - 1]) ||
                                isSign(engine[row + 1][column/**/]) ||
                                isSign(engine[row + 1][column + 1]) ||
                                isSign(engine[row/**/][column - 1]) ||
                                isSign(engine[row/**/][column + 1]) ||
                                isSign(engine[row - 1][column - 1]) ||
                                isSign(engine[row - 1][column/**/]) ||
                                isSign(engine[row - 1][column + 1])) {
                            isSignNear = true;
                        }
                        number = number * 10 + Character.getNumericValue(engine[row][column]);
                        column++;
                    }
                    if (isSignNear) {
                        sum += number;
                    }
                }
            }
        }
        return 1;
    }

    private static boolean isSign(char myChar) {
        char[] symbols = { '@', '#', '$', '%', '&', '*', '-', '/', '+', '=' };
        for (char c : symbols) {
            if (myChar == c) {
                return true;
            }
        }
        return false;
    }

}