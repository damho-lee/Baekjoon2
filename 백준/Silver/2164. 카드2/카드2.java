import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String str = s.readLine();
        String str1[] = str.split("\n");
        int size = Integer.parseInt(str1[0]);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<size; i++) {
            list.add(i+1);
        }
        while(list.size()!=1) {
            list.remove(0);
            int key = list.get(0);
            list.remove(0);
            list.add(key);
        }
        System.out.println(list.get(0));
    }
}