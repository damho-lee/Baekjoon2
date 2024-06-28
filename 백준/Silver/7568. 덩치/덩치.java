import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Person[] personList;

    private static void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine().trim());
            personList = new Person[size];

            for (int i = 0; i < personList.length; i++) {
                String[] inputs = reader.readLine().split(" ");
                personList[i] = new Person(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static String calculate() {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < personList.length; i++) {
            int rank = 1;
            Person current = personList[i];

            for (int j = 0; j < personList.length; j++) {
                if (i == j) {
                    continue;
                }

                Person next = personList[j];

                if (current.getHeight() < next.getHeight() && current.getWeight() < next.getWeight()) {
                    rank++;
                }
            }

            stringBuffer.append(rank + " ");
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        readInput();
        System.out.println(calculate());
    }
}

class Person {
    private int weight;
    private int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
}