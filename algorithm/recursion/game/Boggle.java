package recursion.game;
import java.util.*;

/*
 * find specific word in n*n board
 * one arbitrary character contained in each room of board
 * only one direction at a time is possible to move in 8 directions
 * if move-route that can make the word to find is exist, hasWord returns true else false
 */
class Boggle
{
	final static int dx[] = {-1, 0, -1, -1, 0, -1, -1, 0, -1};
	final static int dy[] = {1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int board[][] = new int[20][20];
	final static int N = 20;
	public static boolean hasWord(int y, int x, String words)
	{
		if(!isRange(y, x))
			return false;
		if(board[y][x] != words.indexOf(0))
			return false;
		if(words.length() == 1)
			return true;
		for(int i = 0; i<8; i++)
		{
			int nextY = y+dy[i];
			int nextX = x+dx[i];
			if(hasWord(nextY, nextX, words.substring(1)))
				return true;
		}
		return false;
	}
	public static boolean isRange(int y, int x)
	{
		if(y>=N||x>=N||y<=0||x<=0)
			return false;
		else
			return true;
	}
	public static void main(String[] args)
	{
		hasWord(0, 0, "bitcoin");
	}
}