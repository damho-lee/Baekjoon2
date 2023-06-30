import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int i=1;
		int sum = 1;
		while(true) {
			sum += i;
			if(sum > x)
				break;
			i++;
		}
		i++;
		if(i%2==1)
			System.out.println(i-(sum-x) + "/" + (sum-x));
		else
			System.out.println((sum-x) + "/" + (i-(sum-x)));
		s.close();
	}
} 