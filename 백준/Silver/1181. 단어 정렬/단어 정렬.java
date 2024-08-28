import java.io.*;
import java.util.Objects;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            TreeSet<Word> treeSet = new TreeSet<>(Word::compareTo);

            int n = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n; i++) {
                treeSet.add(new Word(reader.readLine().trim()));
            }

            while(!treeSet.isEmpty()) {
                writer.append(treeSet.pollFirst().getWord());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Word implements Comparable {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(Object o) {
        Word other = (Word) o;

        if (this.getWord().length() == other.getWord().length()) {
            return this.getWord().compareTo(other.getWord());
        }

        return this.getWord().length() - other.getWord().length();
    }

    @Override
    public boolean equals(Object o) {
        Word other = (Word) o;
        return this.getWord().equals(other.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}