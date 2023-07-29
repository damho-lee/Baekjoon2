import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int key = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        int x = 0;
        int y = 0;
        int i=n/2;
        int j=n/2;
        int num = 1;
        int st = -1;
        field[i][j] = num++;
        while(num < n*n) {
            int iter = Math.abs(st);
            int p = 0;
            while(p < iter) {
                 i += st/iter;
                if(i < n && i>=0 && j < n && j>=0) {
                    if(num==key) {
                        x = i+1;
                        y = j+1;
                    }
                    field[i][j] = num++;
                }
                p++;
            }
            p = 0;
            st *= (-1);
            while(p < iter) {
                j += st/iter;
                if(i < n && i>=0 && j < n && j>=0) {
                    if(num==key) {
                        x = i+1;
                        y = j+1;
                    }
                    field[i][j] = num++;
                }
                p++;
            }
            if(st > 0) {
                st++;
            }
            else {
                st--;
            }
        }
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                bw.write(field[i][j] + " ");
            }
            bw.write("\n");
        }
        if(x==0 && y==0) {
            x=n/2 + 1;
            y=n/2 + 1;
        }
        bw.write(x + " " + y);
        bw.flush();
    }
}
