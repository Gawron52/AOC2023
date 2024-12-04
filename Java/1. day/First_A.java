import java.util.regex.*;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class First_A {

    private static int sum = 0;

    public static void main(String[] args) {

        Pattern patern_first = Pattern.compile("(\\d)");
        Pattern patern_last = Pattern.compile("(\\d)\\D*$");

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
            System.out.print(matcher_first.group(1));
            System.out.println(matcher_last.group(1));
            number = Integer.parseInt(matcher_first.group(1) + matcher_last.group(1));
            sum += number;
        }
    }
}