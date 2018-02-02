package acmicpc;
import java.util.*;

public class JumpGame {
	static int[][] board;
	static int[][] dp;
	static int n;
	static boolean find;
	public static int jump(int y, int x)
	{
		if(find)
			{
				return 1;
			}
		if(!IsRange(y, x))
			return 0;
		if(y==n&&x==n)
			{
				find = true;
				return 1;
			}
		if(dp[y][x]!=-1)
			return dp[y][x];
		
		dp[y][x] = jump(y+board[y][x], x);
		dp[y][x] = Math.max(dp[y][x], jump(y, x+board[y][x]));
		return dp[y][x];
	}
	public static boolean IsRange(int y, int x)
	{
		if(y<=0 || x<=0 || y>n || x>n)
			return false;
		else
			return true;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while(C-->0)
		{
			n = sc.nextInt();
			board = new int[n+1][n+1];
			dp = new int[n+1][n+1];
			find = false;
			for(int i = 1; i<=n; i++)
			{
				for(int j = 1; j<=n; j++)
				{
					board[i][j] = sc.nextInt();
					dp[i][j] = -1;
				}
			}
			
			System.out.println(jump(1,1)==1?"YES":"NO");
			
		}
	}
}
