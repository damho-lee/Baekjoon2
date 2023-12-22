import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
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

        for (Map.Entry<String, Integer> extensionCounterSet : extensionCounter.entrySet()) {
            System.out.println(extensionCounterSet.getKey() + " " +extensionCounterSet.getValue());
        }
    }
}
