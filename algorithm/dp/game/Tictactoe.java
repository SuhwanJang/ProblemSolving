package dp.game;
import java.util.*;

public class Tictactoe {
	//boolean isFinished(final ArrayList<String> board, char turn); return whether turn make one line
	//convert board state to [0, 19682] range integer
	public static int bijection(final int[][] board)
	{
		int ret = 0;
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 3; x++)
			{
				ret *= 3;
				if(board[y][x] == 'o') ++ret;
				else if(board[y][x] == 'x') ret += 2;
			}
		}
		return ret;
	}
	static int dp[] = new int[19683]; //initial with -2
	//if I can win, retun 1, else if draw return 0, else -1
	public static int canWin(final int[][] board, char turn)
	{
		//if(isFinished(board, 'o'+'x'-turn)) return -1;
		if(dp[bijection(board)]!=-2) return dp[bijection(board)];
		int minValue = 2;
		for(int y = 0; y <3; y++)
		{
			for(int x= 0; x < 3; x++)
			{
				if(board[y][x]=='.') {
					board[y][x] = turn;
					minValue = min(minValue, canWin(board, 'o'+'x'-turn));
					board[y][x] = '.';
				}
			}
		}
		if(minValue == 2 || minValue == 0) return dp[bijection(board)] = 0;
		return dp[bijection(board)] = -minValue;
	}
	public static void main(String[] args)
	{
		
	}
}
