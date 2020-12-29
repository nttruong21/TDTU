import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static ArrayList<Object> readFileInput(String filePath) {
        ArrayList<Object> result = new ArrayList<Object>();
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            int numOperand = Integer.parseInt(sc.nextLine());
            int numOperator = numOperand - 1;
            for (int i = 0; i < numOperand; i++) {
                result.add(new BigInteger(sc.nextLine()));
            }
            for (int i = 0; i < numOperator; i++) {
                result.add(sc.nextLine().charAt(0));
            }
            sc.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readFileOutput(String filePath) {
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            String result = reader.nextLine();
            reader.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeFileOutput(BigInteger number, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(number.toString());
            writer.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }
}
