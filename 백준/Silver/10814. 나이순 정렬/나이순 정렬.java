import java.io.*;
import java.util.Objects;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            TreeSet<Member> treeSet = new TreeSet<>(Member::compareTo);
            String[] inputs;

            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                treeSet.add(new Member(Integer.parseInt(inputs[0]), inputs[1]));
            }

            while (!treeSet.isEmpty()) {
                writer.append(treeSet.pollFirst().asString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Member implements Comparable {
    private int age;
    private String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Member other = (Member) o;

        if (this.getAge() == other.getAge()) {
            return 1;
        }

        return this.getAge() - other.getAge();
    }

    @Override
    public boolean equals(Object o) {
        Member other = (Member) o;

        return this.getAge() == other.getAge() && this.getName() == other.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public String asString() {
        return this.getAge() + " " + this.getName();
    }
}