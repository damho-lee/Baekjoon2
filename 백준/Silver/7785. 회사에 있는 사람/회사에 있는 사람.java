import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Set<Person> set = new HashSet<>();
            String[] inputs;

            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                if (inputs[1].equals("enter")) {
                    set.add(new Person(inputs[0]));
                } else if (inputs[1].equals("leave")) {
                    set.remove(new Person(inputs[0]));
                } else {
                    throw new RuntimeException("잚못된 입력");
                }
            }

            List<Person> result = new ArrayList<>(set);
            result.sort(Person::compareTo);
            for (int i = result.size() - 1; i >= 0; i--) {
                writer.write(result.get(i).getName() + "\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person implements Comparable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Person other = (Person) o;

        return this.getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        Person other = (Person) o;

        return this.getName().compareTo(other.getName());
    }
}