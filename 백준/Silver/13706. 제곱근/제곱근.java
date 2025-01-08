import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BigInteger n = new BigInteger(reader.readLine());
            System.out.println(n.sqrt());
        } catch (IOException e) {
        }
    }
}