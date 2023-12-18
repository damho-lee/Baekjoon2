import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        InOutResolver inOutResolver = new InOutResolver(inputString);

        int n = inOutResolver.getN();
        int m = inOutResolver.getM();
        int count = 0;

        List<String> nList = new ArrayList<>();
        List<String> mList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nList.add(scanner.nextLine().trim());
        }
        for (int i = 0; i < m; i++) {
            mList.add(scanner.nextLine().trim());
        }

        for (int i = 0; i < m; i++) {
            if (nList.contains(mList.get(i))) {
                count++;
            }
        }

        System.out.println(count);
    }

    static class InOutResolver {
        private int n;
        private int m;
        public InOutResolver(String inputString) {
            if (inputString == null) {
                throw new IllegalArgumentException("입력이 null일 수 없습니다.");
            }

            StringTokenizer st = new StringTokenizer(inputString, " ");
            if (st.countTokens() != 2) {
                throw new IllegalArgumentException("입력이 정수 2개가 아닙니다.");
            }

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            classInvariant();
        }

        private void classInvariant() {
            if (this.n < 0 || this.m < 0) {
                throw new IllegalArgumentException("class invariant!! n : " + n + ", m : " + m);
            }
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }
    }
}
