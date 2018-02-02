import java.util.*;

public class Main{
	static long[] arr;
	public static void sieve(long N)
	{
		for(int i = 2; i*i<=N; i++)
		{
			if(arr[i] == 0)
				continue;
			for(int j = i+i; j<= N; j+=i)
			{
				arr[j] = 0;
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long M = sc.nextLong();
		long N = sc.nextLong();
		arr = new long[1000001];
		Arrays.fill(arr, -1);
		long[] numbers = new long[1000001];
		sieve(1000000);
		
		
		for(int i = 2; i <= (int)Math.sqrt(N); i++)
		{
			if(arr[i] == 0) continue;
			long primePow = (long) Math.pow(i, 2);
			long x = M/primePow;
			if(M%primePow != 0)
				x += 1;
			
			while(x*primePow <= N)
			{
				numbers[(int) (x*primePow-M)] = 1;
				x++;
			}
		}
		int count = 0;
		for(int i1 = 0; i1 <= N-M; i1++)
		{
			if(numbers[i1] == 0)
				count++;
		}
		System.out.println(count);
	}
}
