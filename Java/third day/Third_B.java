import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Third_A {

    private static int iterator = 1;
    private static int sum = 0;
    private static int height = 12;
    private static int width = 12;
    private static char[][] engine = new char[height][width];

    public static void main(String[] args) {
        try {
            File myObj = new File("test_input.txt");
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
                if (engine[row][column] == '*') {
                    String[] numbers = new String[6];
                    int numbersNear = 0;

                    // check left
                    if (isNumber(engine[row][column - 1])) {
                        int temp_column = column - 1;
                        while (isNumber(engine[row][temp_column])) {
                            numbers[numbersNear] = engine[row][temp_column] + numbers[numbersNear];
                            temp_column--;
                        }
                        numbersNear++;
                    }
                    // check right
                    if (isNumber(engine[row][column + 1])) {
                        int temp_column = column + 1;
                        while (isNumber(engine[row][temp_column])) {
                            numbers[numbersNear] = numbers[numbersNear] + engine[row][temp_column];
                            temp_column++;
                        }
                        numbersNear++;
                    }
                    // check up
                    if (isNumber(engine[row - 1][column])) {
                        int temp_column = column;
                        while (isNumber(engine[row - 1][temp_column])) {
                            numbers[numbersNear] = numbers[numbersNear] + engine[row - 1][temp_column];
                            temp_column++;
                        }
                        temp_column = column - 1;
                        while (isNumber(engine[row - 1][temp_column])) {
                            numbers[numbersNear] = engine[row - 1][temp_column] + numbers[numbersNear];
                            temp_column--;
                        }
                        numbersNear++;
                    } else {
                        // check top-left
                        if (isNumber(engine[row - 1][column - 1])) {
                            int temp_column = column - 1;
                            while (isNumber(engine[row - 1][temp_column])) {
                                numbers[numbersNear] = engine[row - 1][temp_column] + numbers[numbersNear];
                                temp_column--;
                            }
                            numbersNear++;
                        }
                        // check top-right
                        if (isNumber(engine[row - 1][column + 1])) {
                            int temp_column = column + 1;
                            while (isNumber(engine[row - 1][temp_column])) {
                                numbers[numbersNear] = numbers[numbersNear] + engine[row - 1][temp_column];
                                temp_column++;
                            }
                            numbersNear++;
                        }
                    }
                    // check down
                    if (isNumber(engine[row + 1][column])) {
                        int temp_column = column;
                        while (isNumber(engine[row + 1][temp_column])) {
                            numbers[numbersNear] = numbers[numbersNear] + engine[row + 1][temp_column];
                            temp_column++;
                        }
                        temp_column = column - 1;
                        while (isNumber(engine[row + 1][temp_column])) {
                            numbers[numbersNear] = engine[row + 1][temp_column] + numbers[numbersNear];
                            temp_column--;
                        }
                        numbersNear++;
                    } else {
                        // check bottom-left
                        if (isNumber(engine[row + 1][column - 1])) {
                            int temp_column = column - 1;
                            while (isNumber(engine[row + 1][temp_column])) {
                                numbers[numbersNear] = engine[row + 1][temp_column] + numbers[numbersNear];
                                temp_column--;
                            }
                            numbersNear++;
                        }
                        // check bottom-right
                        if (isNumber(engine[row + 1][column + 1])) {
                            int temp_column = column + 1;
                            while (isNumber(engine[row + 1][temp_column])) {
                                numbers[numbersNear] = numbers[numbersNear] + engine[row + 1][temp_column];
                                temp_column++;
                            }
                            numbersNear++;
                        }
                    }

                    if (numbersNear == 2) {
                        sum += Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                    }
                }
            }
        }
        return 1;
    }

    private static boolean isNumber(char myChar) {
        if (myChar >= 48 && myChar <= 57) {
            return true;
        }
        return false;
    }

}