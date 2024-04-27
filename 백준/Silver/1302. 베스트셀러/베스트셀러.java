import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    private static Map<String, Integer> readInput() {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                String input = reader.readLine();
                map.compute(input, (key, value) -> value == null ? 1 : value + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    private static String search(Map<String, Integer> map) {
        PriorityQueue<Book> queue = new PriorityQueue();
        map.forEach((key, value) -> queue.add(new Book(key, value)));

        return queue.poll().getTitle();
    }
    public static void main(String[] args) {
        Map<String, Integer> map = readInput();
        System.out.println(search(map));
    }
}

class Book implements Comparable{
    private String title;
    private int count;

    public Book(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Object o) {
        Book other = (Book) o;
        if (this.getCount() == other.getCount()) {
            return this.getTitle().compareTo(other.getTitle());
        }

        return other.getCount() - this.getCount();
    }
}
