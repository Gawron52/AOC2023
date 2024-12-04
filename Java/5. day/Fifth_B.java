import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

class Fifth_B {
    private static long min = Long.MAX_VALUE;

    public static void main(String[] args) {
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            long[] seedsInfo = Arrays.stream(myReader.nextLine().substring(7).split(" +")).mapToLong(Long::parseLong)
                    .toArray();
            for (int i = 0; i < seedsInfo.length; i += 2) {
                for (int j = 0; j < seedsInfo[i + 1]; j++) {
                    long seed = seedsInfo[i] + j;

                    myReader.nextLine();
                    String line;
                    while (myReader.hasNextLine()) {
                        myReader.nextLine();
                        line = myReader.nextLine();
                        do {
                            long[] map = Arrays.stream(line.split(" ")).mapToLong(Long::parseLong).toArray();
                            if (seed >= map[1] && seed < map[1] + map[2]) {
                                seed += map[0] - map[1];
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
                    if (seed < min)
                        min = seed;

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(min);
    }
}