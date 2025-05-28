import java.io.*;
import java.util.Stack;

public class Main {
    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';
    private static final int PARENTHESIS_VALUE = 2;
    private static final int BRACKET_VALUE = 3;

    public static void main(String[] args) {
        String input;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(calculate(input));
    }

    private static int calculate(String str) {
        if (!isParenthesesOrBracketsOnly(str)) {
            return 0;
        }

        int result = 0;
        int value = 1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == LEFT_PARENTHESIS) {
                stack.push(ch);
                value *= PARENTHESIS_VALUE;
            } else if (ch == LEFT_BRACKET) {
                stack.push(ch);
                value *= BRACKET_VALUE;
            } else if (ch == RIGHT_PARENTHESIS) {
                if (stack.isEmpty() || !isPair(stack.peek(), ch)) {
                    result = 0;
                    break;
                }

                if (str.charAt(i - 1) == LEFT_PARENTHESIS) {
                    result += value;
                }

                stack.pop();
                value /= PARENTHESIS_VALUE;
            } else if (ch == RIGHT_BRACKET) {
                if (stack.isEmpty() || !isPair(stack.peek(), ch)) {
                    result = 0;
                    break;
                }

                if (str.charAt(i - 1) == LEFT_BRACKET) {
                    result += value;
                }

                stack.pop();
                value /= BRACKET_VALUE;
            }
        }

        return stack.isEmpty() ? result : 0;
    }

    private static boolean isParenthesesOrBracketsOnly(String str) {
        for (char ch : str.toCharArray()) {
            if (ch != LEFT_PARENTHESIS && ch != RIGHT_PARENTHESIS && ch != LEFT_BRACKET && ch != RIGHT_BRACKET) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPair(char left, char right) {
        return (left == LEFT_PARENTHESIS && right == RIGHT_PARENTHESIS)
                || (left == LEFT_BRACKET && right == RIGHT_BRACKET);
    }
}