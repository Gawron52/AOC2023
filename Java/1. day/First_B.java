import java.util.regex.*;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class First_B {

    private static int sum = 0;

    public static void main(String[] args) {

        Pattern patern_first = Pattern.compile("(\\d|one|two|three|four|five|six|seven|eight|nine)");
        Pattern patern_last = Pattern.compile(".*(\\d|one|two|three|four|five|six|seven|eight|nine)");

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Matcher matcher_first = patern_first.matcher(data);
                Matcher matcher_last = patern_last.matcher(data);
                find(matcher_first, matcher_last);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    private static void find(Matcher matcher_first, Matcher matcher_last) {

        // For each match, we can extract the captured information by reading the
        // captured groups.
        int number = 0;
        if (matcher_first.find() && matcher_last.find()) {
            number = strToDigit(matcher_first.group(1)) * 10 + strToDigit(matcher_last.group(1));
        }
        System.out.print(matcher_first.group(1));
        System.out.println(matcher_last.group(1));
        System.out.println(number);
        sum += number;
    }

    private static int strToDigit(String str) {
        switch (str) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return Integer.parseInt(str);
        }
    }
}