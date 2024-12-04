import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

class Fifth_A {
    private static long min = 0;

    public static void main(String[] args) {
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            long[] seeds = Arrays.stream(myReader.nextLine().substring(7).split(" +")).mapToLong(Long::parseLong)
                    .toArray();
            for (int i = 0; i < seeds.length; i++) {
                myReader.nextLine();
                String line;
                while (myReader.hasNextLine()) {
                    myReader.nextLine();
                    line = myReader.nextLine();
                    do {
                        long[] map = Arrays.stream(line.split(" ")).mapToLong(Long::parseLong).toArray();
                        if (seeds[i] >= map[1] && seeds[i] < map[1] + map[2]) {
                            seeds[i] += map[0] - map[1];
                            while (!line.equals("")) {
                                if (!myReader.hasNextLine()) {
                                    break;
                                }
                                line = myReader.nextLine();
                            }
                            break;
                        }
                        if (!myReader.hasNextLine()) {
                            break;
                        } else
                            line = myReader.nextLine();
                    } while (!line.equals(""));
                }
                myReader = new Scanner(myObj);
                myReader.nextLine();
                myReader.nextLine();
            }
            myReader.close();
            min = seeds[0];
            for (int i = 1; i < seeds.length; i++) {
                if (seeds[i] < min)
                    min = seeds[i];
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(min);
    }
}