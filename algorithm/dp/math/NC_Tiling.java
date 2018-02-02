package dp.math;
import java.util.*;

public class NC_Tiling {
	static int dp[][];
	public static int fill(int n)
	{
		final int M = 1000000007;
		dp = new int[101][3];
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[2][1] = 1;
		dp[2][2] = 1;
		for(int i = 3; i <= n; i++)
		{
			dp[i][1] = (dp[i-1][1] + dp[i-1][2])%M;
			dp[i][2] = (dp[i-2][1] + dp[i-2][2])%M;
		}
		return (dp[n][1]+dp[n][2])%M;
	}
	//recursive way, memoization
	public static int tiling(int width)
	{
		if(width <= 1) return 1;
		//memoization
		if(dp[width] != -1) return dp[width];
		return dp[width] = (tiling(width-2) + tiling(width-1))%M;
	}
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while(C-->0)
		{
			int n = sc.nextInt();
			System.out.println(fill(n));
		}
	}
}
