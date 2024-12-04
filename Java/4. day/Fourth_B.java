import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

class Fourth_B {
    private static int sum = 0;
    private static int cardNumber = 0;
    private static int[] cardsCopies = new int[225];

    public static void main(String[] args) {
        Arrays.fill(cardsCopies, 1);
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int matches = 0;
                String[] data = myReader.nextLine().split(": +| \\| +");
                String[] winningCards = data[1].split(" +");
                String[] myCards = data[2].split(" +");
                for (String winningCard : winningCards) {
                    for (String myCard : myCards) {
                        if (winningCard.equals(myCard)) {
                            matches++;
                        }
                    }
                }
                for (int i = 1; i <= matches; i++) {
                    cardsCopies[cardNumber + i] += cardsCopies[cardNumber];
                }
                sum += cardsCopies[cardNumber];
                cardNumber++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}