package dp;
import java.util.*;

public class UnilatedRun {
	
	static final int N = 100;
	static int dp[][] = new int[N][N];
	static int board[][] = new int[N][N];
	public static int jump(int y, int x)
	{
		if(y>=N || x>=N)
			return 0;
		if(y==N-1 && x==N-1)
			return 1;
		int ret = dp[y][x];
		if(ret != -1)
			return ret;
		int jumpsize = board[y][x];
		
		return dp[y][x] = Math.max(jump(y+jumpsize, x), jump(y, x+jumpsize));
	}
	public static void main(String[] args)
	{
		System.out.println(dp[N-1][N-1]==0?false:true);
	}
}
