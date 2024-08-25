import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           StringTokenizer st = new StringTokenizer(reader.readLine());
           System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        } catch (IOException e) {
           throw new RuntimeException();
        }
    }
}