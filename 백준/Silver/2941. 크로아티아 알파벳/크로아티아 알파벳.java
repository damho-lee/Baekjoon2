import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine().trim();

            System.out.println(CroatiaAlphabetCalculator.calculate(input));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class CroatiaAlphabetCalculator {
    private CroatiaAlphabetCalculator() {
    }

    public static int calculate(String string) {
        int i = 0;
        int count = 0;
        int result;

        while (i < string.length()) {
            String twoWord;
            String threeWord;
            int twoWordResult = 1;
            int threeWordResult = 1;

            if (i + 2 <= string.length()) {
                twoWord = string.substring(i, i + 2);
                twoWordResult = calculateWord(twoWord);
            }

            if (i + 3 <= string.length()) {
                threeWord = string.substring(i, i + 3);
                threeWordResult = calculateWord(threeWord);
            }

            result = Math.max(twoWordResult, threeWordResult);

            count++;
            i += result;
        }

        return count;
    }

    private static int calculateWord(String word) {
        if (isValid(word)) {
            return word.length();
        }

        return 1;
    }

    private static boolean isValid(String word) {
        CroatiaAlphabet[] alphabets = CroatiaAlphabet.values();

        for (CroatiaAlphabet alphabet : alphabets) {
            if (word.equals(alphabet.getAlphabet())) {
                return true;
            }
        }

        return false;
    }
}

enum CroatiaAlphabet {
    C_EQUAL("c="),
    C_MINUS("c-"),
    DZ_EQUAL("dz="),
    D_MINUS("d-"),
    LJ("lj"),
    NJ("nj"),
    S_EQUAL("s="),
    Z_EQUAL("z=");

    private final String alphabet;

    CroatiaAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getAlphabet() {
        return alphabet;
    }
}
