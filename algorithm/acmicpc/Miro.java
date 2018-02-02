package acmicpc;

import java.util.*;
import java.io.*;

class Lo
{
	int y;
	int x;
	public Lo(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}
class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		String[] sizeStr = reader.readLine().split(" ");
		N = Integer.parseInt(sizeStr[0]);
		M = Integer.parseInt(sizeStr[1]);
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
		{
			sizeStr = reader.readLine().split("");
			for(int j = 0; j < M; j++)
			{
				map[i][j] = Integer.parseInt(sizeStr[j]);
			}
		}
		
		int curY, curX, ddy, ddx;
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, -1, 0, 1};
		int[][] count = new int[N][M];
		count[0][0] = 1;
		Queue<Lo> queue = new LinkedList<Lo>();
		queue.add(new Lo(0,0));
		while(!queue.isEmpty())
		{
			curY = queue.peek().y;
			curX = queue.poll().x;
			
			if(curY == N-1 && curX == M-1) break;
			
			if(visited[curY][curX])
			visited[curY][curX] = true;
			
			for(int d = 0; d < 4; d++)
			{
				ddy = curY + dy[d];
				ddx = curX + dx[d];
				if(ddy < 0 || ddx < 0 || ddy >=N || ddx >=M) continue;
				
				if(visited[ddy][ddx] || map[ddy][ddx] == 0) continue;
				count[ddy][ddx] = count[curY][curX] + 1;
				queue.add(new Lo(ddy, ddx));
			}
		}
		System.out.println(count[N-1][M-1]);
	}
}