package dp.math;
import java.util.*;

public class ClimbSnail {
	static int n, m;
	static final int N = 100;
	static int dp[][] = new int[N][2*N+1];
	public static int climb(int days, int climbed)
	{
		if(days == N) return climbed>= N ? 1 : 0;
		if(dp[days][climbed]!=-1)
			return dp[days][climbed];
		return dp[days][climbed] = climb(days+1, climbed+1) + climb(days+1, climbed+2);
	}
	public static void main(String[] args)
	{
		
	}
}
