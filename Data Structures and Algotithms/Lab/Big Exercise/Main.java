import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileInputPath = "input.txt";
        ArrayList<Object> input = Utils.readFileInput(fileInputPath);

        ArrayList<BigInteger> operandArr = new ArrayList<BigInteger>();
        ArrayList<Character> operatorArr = new ArrayList<Character>();

        for (int j = 0; j < input.size(); j++) {
            if (input.get(j) instanceof BigInteger) {
                operandArr.add(((BigInteger) input.get(j)));
            }
            else if (input.get(j) instanceof Character) {
                operatorArr.add(((Character) input.get(j)));
            }
        }

        BigInteger output = BigInteger.computeValue(operandArr, operatorArr);
        String fileOutputPath = "output.txt";
        Utils.writeFileOutput(output, fileOutputPath);
    }
}