import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int arr[] = new int[x+1];
        int a[] = new int[2];
        for(int i=0; i<arr.length; i++) {
            arr[i] = -1;
        }
        a[0] = 2;
        a[1] = 5;
        for(int j=0; j<2 && a[j] <= x; j++) {
            arr[a[j]] = 1;
            for(int i=a[j]+1; i<arr.length; i++) {
                if(arr[i-a[j]]!=-1) {
                    arr[i] = arr[i-a[j]] + 1;
                }
            }
        }
        System.out.println(arr[x]);
    }
}