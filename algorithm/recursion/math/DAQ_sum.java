package recursion.math;
import java.util.*;
/*
 * divide and conquer
 * sum (1~N)
 */
public class DAQ_sum {
	public static int sum(int N)
	{
		if(N==1) return 1;
		if(N%2 == 1) return sum(N-1)+N;
		else
			return 2*sum(N/2)+(N/2)*(N/2);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(sum(sc.nextInt()));
	}

}
