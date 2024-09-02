import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Integer> sanggeun = Arrays.stream(Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray())
                    .boxed()
                    .collect(Collectors.toList());
            Deck deck = new Deck(sanggeun);

            int m = Integer.parseInt(reader.readLine().trim());
            int[] compare = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (Integer card : compare) {
                if (deck.hasCard(card)) {
                    writer.write("1");
                } else {
                    writer.write("0");
                }

                writer.write(" ");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Deck {
    private List<Integer> cardList;

    public Deck(List<Integer> cardList) {
        this.cardList = cardList;
        this.cardList.sort(Integer::compareTo);
    }

    public boolean hasCard(int card) {
        int l = 0;
        int r = cardList.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (cardList.get(mid) < card) {
                l = mid + 1;
            } else if (cardList.get(mid) > card) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}