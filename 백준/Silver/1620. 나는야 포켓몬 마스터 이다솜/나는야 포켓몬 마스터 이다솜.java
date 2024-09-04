import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            if (!isValidInput(n, m)) {
                throw new RuntimeException("n과 m은 1보다 크거나 같고 100,000보다 작거나 같아야합니다.");
            }
            String name;

            PokemonDrawingBook drawingBook = new PokemonDrawingBook();
            for (int i = 0; i < n; i++) {
                name = reader.readLine().trim();
                drawingBook.put(name);
            }

            String input;
            for (int i = 0; i < m; i++) {
                input = reader.readLine().trim();
                writer.write(drawingBook.get(input));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValidInput(int n, int m) {
        return n >= 1 && n <= 100000 && m >= 1 && m <= 100000;
    }
}

class PokemonDrawingBook {
    private Map<String, String> mapForNumber;
    private Map<String, String> mapForName;
    private int number;

    public PokemonDrawingBook() {
        this.mapForNumber = new HashMap<>();
        this.mapForName = new HashMap<>();
        number = 1;
    }

    public void put(String name) {
        if (!isValidPokemonName(name)) {
            throw new IllegalArgumentException("포켓몬 이름이 유효하지 않습니다.");
        }

        mapForNumber.put(name, String.valueOf(number));
        mapForName.put(String.valueOf(number), name);
        number++;
    }

    public String get(String question) {
        if (!isValidQuestion(question)) {
            throw new IllegalArgumentException("\n질문의 형식이 맞지 않습니다.\n" +
                    "올바른 형식 : 첫 글자 대문자, 나머지 소문자 or 마지막 글자 대문자, 나머지 소문자 or 숫자\n" +
                    "입력 : " + question);
        }

        if (mapForName.containsKey(question)) {
            return mapForName.get(question);
        } else if (mapForNumber.containsKey(question)) {
            return mapForNumber.get(question);
        } else {
            throw new IllegalArgumentException("도감에 없습니다.");
        }

    }

    private static boolean isValidPokemonName(String name) {
        return (Pattern.matches(PokemonNameRule.FIRST_LETTER_IS_CAPITAL_LETTER, name)
                || Pattern.matches(PokemonNameRule.FIRST_AND_LAST_LETTER_IS_CAPITAL_LETTER, name))
                && name.length() >= PokemonNameRule.NAME_MINIMUM_LENGTH
                && name.length() <= PokemonNameRule.NAME_MAXIMUM_LENGTH;
    }

    private boolean isValidQuestion(String question) {
        try {
            return isValidPokemonName(question) || Integer.parseInt(question) >= 0 && Integer.parseInt(question) < number;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class PokemonNameRule {
    public static final String FIRST_LETTER_IS_CAPITAL_LETTER = "^[A-Z][a-z]*$";
    public static final String LAST_LETTER_IS_CAPITAL_LETTER = "^[a-z]*[A-Z]$";
    public static final String FIRST_AND_LAST_LETTER_IS_CAPITAL_LETTER = "^[A-Z][a-z]*[A-Z]$";
    public static final int NAME_MAXIMUM_LENGTH = 20;
    public static final int NAME_MINIMUM_LENGTH = 2;
}
