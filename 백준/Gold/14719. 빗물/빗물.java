import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] s = str.split(" ");
        Queue<Integer> q = new LinkedList<>();
        int h = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        int[] field = new int[w];
        str = br.readLine();
        s = str.split(" ");
        for(int i=0; i<w; i++) {
            field[i] = Integer.parseInt(s[i]);
        }
        for(int i = 1; i < w - 1; i++) { //인덱스 별 모이는 빗물. 첫, 마지막 제외
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(field[j], left);
            }

            for(int j = i + 1; j < w; j++) {
                right = Math.max(field[j], right);
            }

            if(field[i] < left && field[i] < right)
                sum += Math.min(left, right) - field[i];
        }
        System.out.println(sum);
    }
}