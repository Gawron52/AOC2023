import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Fourth_A {
    private static int sum = 0;

    public static void main(String[] args) {
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int points = 1;
                String[] data = myReader.nextLine().split(": +| \\| +");
                String[] winningCards = data[1].split(" +");
                String[] myCards = data[2].split(" +");
                for (String winningCard : winningCards) {
                    for (String myCard : myCards) {
                        if (winningCard.equals(myCard)) {
                            points = points * 2;
                        }
                    }
                }
                points = points / 2;
                sum += points;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}