package acmicpc;
import java.util.*;
import java.io.*;

public class QuardTree {
	public static int[][] board;
	public static int verify(int y, int x, int size)
	{
		boolean containZero = false;
		boolean containOne = false;
		
		for(int i = y; i < y+size; i++)
		{
			for(int j = x; j < x+size; j++)
			{
				if(board[i][j]==1)
					containOne = true;
				if(board[i][j]==0)
					containZero = true;
				if(containOne && containZero)
					return 2;
			}
		}
		if(containZero)
			return 0;
		else
			return 1;
	}
	
	public static String split(int y, int x, int size)
	{
		int ret = verify(y, x, size);
		if(ret == 0) return "0";
		if(ret == 1) return "1";
		String str = "(";
		str += split(y, x, size/2);
		str += split(y, x+(size/2), size/2);
		str += split(y+(size/2), x, size/2);
		str += split(y+(size/2), x+(size/2), size/2);
		str += ")";
		return str;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		board = new int[N][N];
		
		String[] line;
		for(int i = 0; i < N; i++)
		{
			line = reader.readLine().split("");
			for(int j = 0; j < N; j++)
			{
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		System.out.println(split(0, 0, N));
	}
}
