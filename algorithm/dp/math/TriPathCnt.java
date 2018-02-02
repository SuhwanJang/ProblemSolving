package dp.math;
import java.util.*;

public class TriPathCnt {
	static int dp[][] = new int[100][100];
	static int A[][] = new int[100][100];
	public static int path(int y, int x)
	{
		if(y==99) return A[y][x];
		if(dp[y][x] != -1)
			return dp[y][x];
		return dp[y][x] = A[y][x] + Math.max(dp[y+1][x], dp[y+1][x+1]);
	}
	static int dpPath[][] = new int[100][100];
	public static int cntPath(int y, int x)
	{
		if(y==99) return 1;
		if(dpPath[y][x] != -1)
			return dpPath[y][x];
		if(path(y+1, x+1) >= path(y+1, x)) dpPath[y][x] += cntPath(y+1, x+1);
		if(path(y+1, x+1) <= path(y+1, x)) dpPath[y][x] += cntPath(y+1, x);
		return dpPath[y][x];
		
	}
	public static void main(String[] args)
	{
		
	}
}
