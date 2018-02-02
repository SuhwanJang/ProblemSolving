package acmicpc;
import java.util.*;

public class AsymTiling {
	public static int dp[];
	public static int tiling(int w)
	{
		if(w<1) return 0;
		if(w==1) return 1;
		if(w==2) return 2;
		int ret = dp[w];
		if(ret != -1) return ret;
		return dp[w] =  tiling(w-1)+tiling(w-2);
	}
	public static int asym(int w)
	{
		if(w%2 == 1)
			return (tiling(w)-tiling(w/2))
		int ret = tiling(w);
		ret = (ret - tiling(w/2))
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while(C-->0)
		{
			int W = sc.nextInt();
			dp = new int[W+1];
			
			Arrays.fill(dp, -1);
			tiling(W);
			dp[1] = 1;
			dp[2] = 2;
			System.out.println(asym(W));
		}
	}
}
