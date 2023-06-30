import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int key = s.nextInt();
		int array[] = new int[key+1];
		array[0] = 0;
		array[1] = 0;
		if(key >1) {
			for(int i=2; i<array.length; i++) {
				array[i] = 10000;
			}
			for(int i=2; i<array.length; i++) {
				int a = array[i-1] + 1;
				int b = 10000;
				int c = 10000;
				if(i%2==0)
					b=array[i/2]+1;
				if(i%3==0)
					c=array[i/3]+1;
				array[i] = Math.min(c, Math.min(a, b));
			}
			
		}
		System.out.println(array[key]);
		s.close();
	}

}
