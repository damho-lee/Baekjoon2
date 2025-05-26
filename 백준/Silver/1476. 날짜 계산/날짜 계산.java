import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int earth;
        int sun;
        int moon;
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            earth = Integer.parseInt(inputs[0]);
            sun = Integer.parseInt(inputs[1]);
            moon = Integer.parseInt(inputs[2]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        int e = 0;
        int s = 0;
        int m = 0;
        int year = 0;
        
        while (true) {
            year++;
            e++;
            s++;
            m++;
            
            if (e > 15) {
                e = 1;
            }
            if (s > 28) {
                s = 1;
            }
            if (m > 19) {
                m = 1;
            }
            
            if (e == earth && s == sun && m == moon) {
                break;
            }
        }
        
        System.out.print(year);
    }
}