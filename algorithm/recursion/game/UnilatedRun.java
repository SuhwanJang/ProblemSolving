package recursion.game;
import java.util.*;
/*
 * brute-force
 */
public class UnilatedRun {
	static final int N = 10;
	static int[][] board = new int[N][N];
	public static boolean jump(int y, int x)
	{
		if(y>=N || x>=N)
			return false;
		if(y == N-1 && x == N-1)
			return true;
		int jumpsize = board[y][x];
		return jump(y+jumpsize, x) || jump(y, x+jumpsize);
	}
	public static void main(String[] args)
	{
		
	}
}
