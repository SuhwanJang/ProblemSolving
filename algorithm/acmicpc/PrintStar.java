package acmicpc;
import java.util.*;
import java.io.*;

public class PrintStar {
	static int n = 24;
	static char[][] p = new char[n][n];
	public static void set(int y, int x, int l)
	{
		if (l == 1)
			p[y][x] = '*';
		
		int d = l/3;
		for(int i = 1; i <= 3; i++)
		{
			for(int j = 1; j <= 3; j++)
			{
				if(i==2 && j==2);
				
				else
					set(y+(i*d), x+(j*d), d);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Arrays.fill(p, ' ');
		set(0, 0, 24);
	}
}
