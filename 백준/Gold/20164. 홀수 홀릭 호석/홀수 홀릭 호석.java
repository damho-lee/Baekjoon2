import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static void cal(String str, int cnt) {
        if(str.length() < 2) {
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
        }
        else if(str.length() == 2) {
            int v1 = Character.getNumericValue(str.charAt(0));
            int v2 = Character.getNumericValue(str.charAt(1));
            int sum = v1 + v2;
            cal(Integer.toString(sum), cnt+numOdd(Integer.toString(sum)));
        }
        else {
            for(int i=0; i<str.length()-2; i++) {
                for(int j=i+1; j<str.length()-1; j++) {
                    String str1 = str.substring(0, i+1);
                    String str2 = str.substring(i+1, j+1);
                    String str3 = str.substring(j+1, str.length());
                    int sum = Integer.parseInt(str1) + Integer.parseInt(str2) + Integer.parseInt(str3);
                    cal(Integer.toString(sum), cnt+numOdd(Integer.toString(sum)));
                }
            }
        }
    }
    static int numOdd(String str) {
        int x = 0;
        for(int i=0; i<str.length(); i++) {
            if(Character.getNumericValue(str.charAt(i)) % 2 == 1)
                x++;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        cal(input, numOdd(input));
        System.out.print(min + " " + max);
    }
}