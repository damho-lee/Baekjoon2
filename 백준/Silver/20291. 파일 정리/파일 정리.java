import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> extensionCounter = new TreeMap<>();
        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            String inputString = scanner.nextLine().trim();
            String fileExtension = inputString.split("\\.")[1];
            Integer count = extensionCounter.get(fileExtension);
            if (Objects.isNull(count)) {
                extensionCounter.put(fileExtension, 1);
            } else {
                extensionCounter.put(fileExtension, ++count);
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (Map.Entry<String, Integer> extensionCounterSet : extensionCounter.entrySet()) {
            bufferedWriter.write(extensionCounterSet.getKey() + " " +extensionCounterSet.getValue() + "\n");
        }
        bufferedWriter.flush();
    }
}
