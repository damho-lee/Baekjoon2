import java.io.*;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input;
            while (true) {
                if ((input = reader.readLine()).equals(".")) {
                    break;
                }

                if (ParenthesisDiscriminator.isBalancedString(input)) {
                    writer.write("yes");
                } else {
                    writer.write("no");
                }

                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ParenthesisDiscriminator {
    private static final char leftParenthesis = '(';
    private static final char rightParenthesis = ')';
    private static final char leftBracket = '[';
    private static final char rightBracket = ']';

    private ParenthesisDiscriminator() {
    }

    public static boolean isBalancedString(String string) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = Map.of(
                ')', '(',
                ']', '['
        );

        for (char ch : string.toCharArray()) {
            if (brackets.containsValue(ch)) {
                stack.push(ch);
            } else if (brackets.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}