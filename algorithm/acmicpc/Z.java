package acmicpc;
import java.util.*;
		
public class Z {
	public static long N, r, c;
	static long count = -1;
	static boolean find = false;
	public static void go(long y, long x, long l)
	{
		if(find)
			return;
		if(l == 2)
		{
			for(long i = y; i < y+l; i++)
			{
				for(long j = x; j <x+l; j++)
				{
					count += 1;
					if(i==r && j==c)
						{
							find = true;
							return;
						}
				}
			}
			return ;
		}
		long div = l/2;
		go(y, x, div);
		go(y, x+div, div);
		go(y+div, x, div);
		go(y+div, x+div, div);
		return;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		if(N==0) System.out.println(0);
		else 
			{
				go(0, 0, (long)Math.pow(2, N));
				System.out.print(count);
			}
		
	}
}
