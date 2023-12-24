import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().trim();
        System.out.println(stringReverser(inputString));

    }

    private static String stringReverser(String inputString) {
        StringBuilder mainStringBuilder = new StringBuilder();
        StringBuilder tmpStringBuilder = new StringBuilder();
        char[] chrArray = inputString.toCharArray();

        for (int i = 0; i < chrArray.length; i++) {
            if (chrArray[i] == '<') {
                mainStringBuilder.append(tmpStringBuilder.reverse());
                tmpStringBuilder.setLength(0);
                int endIndex = i + 1;
                while(chrArray[endIndex] != '>') {
                    endIndex++;
                }
                mainStringBuilder.append(inputString, i, endIndex+1);
                i = endIndex;
            } else if (chrArray[i] == ' ') {
                mainStringBuilder.append(tmpStringBuilder.reverse());
                mainStringBuilder.append(" ");
                tmpStringBuilder.setLength(0);
            } else {
                tmpStringBuilder.append(chrArray[i]);
            }
        }

        if (tmpStringBuilder.length() != 0) {
            mainStringBuilder.append(tmpStringBuilder.reverse());
        }

        return mainStringBuilder.toString();
    }
}
