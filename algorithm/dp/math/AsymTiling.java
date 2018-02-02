package dp.math;
import java.util.*;

public class AsymTiling {
	static final int N = 100;
	static int dp[] = new int[N+1];
	public static int tiling(int n)
	{
		if(n<=1) return 1;
		if(dp[n]!=-1)
			return dp[n];
		return dp[n] = tiling(n-1) + tiling(n-2);
	}
	
	public static int cntOfAsymTile(int n)
	{
		if(n%2==1)
			return tiling(n)-tiling(n/2);
		int ret = tiling(n);
		ret -= tiling(n/2);
		ret -= tiling(n/2-1);
		return ret;
	}
	//brute force
	public static int cnt2(int n)
	{
		if(n<=2) return 0;
		if(dp[n] != -1)
			return dp[n];
		dp[n] = cnt2(n-2);
		dp[n] = dp[n]+cnt2(n-4);
		dp[n] = dp[n]+tiling(n-3);
		dp[n] = dp[n]+tiling(n-3);
		return dp[n];
		
	}
	public static void main(String[] args)
	{
		
	}
}
