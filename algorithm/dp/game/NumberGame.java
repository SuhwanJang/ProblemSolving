package dp.game;
import java.util.*;

public class NumberGame {
	final int EMPTY = -987654321;
	int n, board[] = new int[50];
	int dp[][] = new int[50][50];
	public int play(int left, int right) {
		if(left > right) return 0;
		if(dp[left][right]!=EMPTY) return dp[left][right];
		dp[left][right] = Math.max(board[left] - play(left+1, right),
				board[right] - play(left, right-1));
		if(right - left + 1 >=2) {
			dp[left][right] = Math.max(dp[left][right], -play(left+2, right));
			dp[left][right] = Math.max(dp[left][right], -play(left, right+2));
		}
		return dp[left][right];
	}
	public static void main(String[] args)
	{
		
	}
}
