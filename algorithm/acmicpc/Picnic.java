package acmicpc;
import java.util.*;

public class Picnic {
	static int[][] friend;
	static boolean[] pair;
	
	public static int match(int n, boolean[] pair)
	{
		int cur = -1;
		for(int i = 0; i<n; i++)
		{
			if(!pair[i])
			{
				cur = i;
				break;
			}
		}
		if(cur==-1)
			return 1;
		int ret = 0;
		for(int i = cur+1; i < n; i++)
		{
			if(friend[cur][i]==1&&!pair[i])
			{
				pair[i] = true;
				pair[cur] = true;
				ret += match(n, pair);
				pair[i] = false;
				pair[cur] = false;
			}
		}
		return ret;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while(C-->0)
		{
			int n = sc.nextInt();//10>=n>=2
			int m = sc.nextInt();//n*(n-1)/2>=m>=0
			friend = new int[n][n];
			pair = new boolean[n];
			for(int i = 0; i < m; i++)
			{
				int f1 = sc.nextInt();
				int f2 = sc.nextInt();
				friend[f1][f2] = 1;
			}
			
			System.out.println(match(n, pair));
			
			
		}
	}
}
