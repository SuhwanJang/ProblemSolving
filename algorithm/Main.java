import java.util.*;
import java.io.*;

class Lo
{
	int y, x;
	public Lo(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}
class Main
{
	static ArrayList<Integer> danCount;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	public static void bfs(int y, int x, int[][] map, int N)
	{
		int count = 1, i = 0, curY = 0, curX = 0, ddy = 0, ddx = 0;
		Queue<Lo> queue = new LinkedList<>();
		queue.offer(new Lo(y, x));
		while(!queue.isEmpty())
		{
			curY = queue.peek().y;
			curX = queue.poll().x;
			
			map[curY][curX] = 0;
			
			for(i = 0; i < 4; i++)
			{
				ddy = curY + dy[i];
				ddx = curX + dx[i];
				if(ddy < 0 || ddx < 0 || ddy >= N || ddx >= N)
					continue;
				if(map[ddy][ddx]==1)
				{
					map[ddy][ddx] = 0;
					queue.offer(new Lo(ddy, ddx));
					count ++;
				}
			}
		}
		danCount.add(count);
	}
	public static void main(String[] args) throws IOException
	{	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] map = new int[N][N];
		danCount = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++)
		{
			String[] line = reader.readLine().split("");
			for(int j = 0; j < N; j++)
			{
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(map[i][j] == 1)
				{
					bfs(i, j, map, N);
				}
			}
		}
		System.out.println(danCount.size());
		Collections.sort(danCount);
		for(int i = 0; i <danCount.size(); i++)
		{
			System.out.println(danCount.get(i));
		}
	}
}