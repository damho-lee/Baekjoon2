import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long key = Long.parseLong(br.readLine());

        int count = 1;
        while(key > 0) {
            key-=count;
            if(key < 0)
                break;
            count++;
        }
        System.out.println(count-1);
    }
}
