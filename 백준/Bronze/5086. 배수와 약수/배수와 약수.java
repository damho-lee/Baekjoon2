import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String FACTOR = "factor";
    private static final String MULTIPLE = "multiple";
    private static final String NEITHER = "neither";

    private static void run() {
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs;
            int first;
            int second;
            while (true) {
                inputs = reader.readLine().trim().split(" ");
                first = Integer.parseInt(inputs[0].trim());
                second = Integer.parseInt(inputs[1].trim());

                if (first == 0 && second == 0) {
                    break;
                }

                if (second % first == 0) {
                    stringBuffer.append(FACTOR);
                } else if (first % second == 0) {
                    stringBuffer.append(MULTIPLE);
                } else {
                    stringBuffer.append(NEITHER);
                }
                stringBuffer.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        run();
    }
}
