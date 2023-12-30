import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			int m = s.nextInt();
			if(m==0)
				break;
			int n = 2*m;
			boolean array[] = new boolean[n+1];
			for(int i=2; i<=n; i++) {
				array[i] = true;
			}
			for(int i=2; i<=n; i++) {
				if(array[i]) {
					for(int j=i+i; j<=n; j=j+i) {
						array[j] = false;
					}
				}
			}int count = 0;
			for(int i=m+1; i<=n; i++) {
				
				if(array[i])
					count++;
			}
			System.out.println(count);
		}
		s.close();
	}
}