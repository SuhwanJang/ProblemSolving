package dp.path;
import java.util.*;

public class TrianglePath {
	static int n;
	static int[][] triangle = new int[100][100];
	static int[][][] dp = new int[100][100][1000];
	public static int path1(int y, int x, int sum)
	{
		if(y==n-1)
			return sum + triangle[y][x];
		int ret = dp[y][x][sum];
		if(ret != -1) return ret;
		return dp[y][x][sum] = Math.max(path1(y+1, x, sum+triangle[y][x]), path1(y+1, x+1, sum+triangle[y][x]));
	}
	/*
	 * path1 problem : 
	 * require many array space at part of sum in dp
	 * work like brute-force at specific any input case
	 * because sum of different path results different value 
	 */
	static int[][] dp2 = new int[100][100];
	public static int path2(int y, int x)
	{
		if(y==n-1)
			return triangle[y][x];
		int ret = dp2[y][x];
		if(ret != -1)
			return ret;
		return dp2[y][x] = triangle[y][x]+Math.max(path2(y+1, x), path2(y+1, x+1));
	}
	/*
	 * path2 :
	 * path1 - return max total sum of path
	 * path2 - return max sum of part path
	 * -> need not sum var <optimal substructure>
	 */
	final static int N = 100;
	static int[][] dp3 = new int[N][N];
	
	public static int path3()
	{
		for(int i = 0; i < N; i++)
		{
			dp3[N-1][i] = triangle[N-1][i];
		}
		for(int y = N-2; y >=0; --y)
		{
			for(int x = 0; x < y+1; x++)
			{
				dp3[y][x] = Math.max(dp3[y+1][x], dp3[y+1][x+1]) + triangle[y][x];
			}
		}
		return dp3[0][0];
	}
	//path3 : bottom - up
	
	public static int path4()
	{
		for(int i = 0; i < N; i++)
		{
			dp3[(N-1)%2][i] = triangle[N-1][i];
		}
		for(int y = N-2; y<N; y--)
		{
			for(int x = 0; x < y+1; x++)
			{
				dp3[y%2][x] = Math.max(dp3[(y+1)%2][x], dp3[(y+1)%2][x+1]) + triangle[y][x];
			}
		}
		return dp3[0][0];
	}
	/*
	 * path4 : sliding window technique
	 * becaous of only need two space, use modular
	 */
	public static void main(String[] args)
	{
		
	}
}
