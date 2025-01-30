import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    private static final int BLANK = -1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] inputs = reader.readLine().split(" ");
            Queue<Person> persons = new LinkedList<>();
            int[] result = new int[n];
            Arrays.fill(result, BLANK);

            for (int i = 0; i < inputs.length; i++) {
                persons.add(new Person(i + 1, Integer.parseInt(inputs[i])));
            }

            while (!persons.isEmpty()) {
                Person person = persons.poll();
                int count = 0;

                for (int i = 0; i < result.length; i++) {
                    if (result[i] == BLANK) {
                        if (count == person.getHeightOrder()) {
                            result[i] = person.getHeight();
                            break;
                        }

                        count++;
                    }
                }
            }

            System.out.println(Arrays.stream(result)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        } catch (IOException e) {
        }
    }
}

class Person {
    private final int height;
    private final int heightOrder;

    public Person(int height, int heightOrder) {
        this.height = height;
        this.heightOrder = heightOrder;
    }

    public int getHeight() {
        return height;
    }

    public int getHeightOrder() {
        return heightOrder;
    }
}