import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int j = Integer.parseInt(br.readLine());
        int s = j;
        int cnt_j = 0;
        int cnt_s = 0;
        String[] str = br.readLine().split(" ");
        int[] md = new int[str.length];
        for(int i=0; i<str.length; i++) {
            md[i] = Integer.parseInt(str[i]);
        }
        //준현 계산
        for(int i=0; i<md.length; i++) {
            cnt_j += j/md[i];
            j %= md[i];
        }
        j += cnt_j*md[13];

        for(int i=3; i<md.length; i++) {
            if(md[i-3] > md[i-2] && md[i-2] > md[i-1]) {
                cnt_s += s/md[i];
                s%=md[i];
            }
            if(md[i-3] < md[i-2] && md[i-2] < md[i-1]) {
                s+=cnt_s*md[i];
                cnt_s=0;
            }
        }
        s+=cnt_s*md[13];
        if(j>s){
            System.out.println("BNP");
        }
        else if(j<s) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
}
