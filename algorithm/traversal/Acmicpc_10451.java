import java.util.*;
import java.io.*;

class Main
{
	public static int bfs(int[] seq, boolean[] visited, int N, int countCycle)
	{
		int curIdx = -1;
		for(int i = 1; i <= N; i++)
		{
			if(!visited[i])
				{
					curIdx = i;
					break;
				}
		}
		if(curIdx == -1) return countCycle;
		
		while(!visited[curIdx])
		{
			visited[curIdx] = true;
			curIdx = seq[curIdx];
		}
		return countCycle = bfs(seq, visited, N, countCycle+1);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		int[] seq;
		boolean[] visited;
		int T = Integer.parseInt(reader.readLine());
		while(T-->0)
			{
				int N = Integer.parseInt(reader.readLine());
				seq = new int[N+1];
				visited = new boolean[N+1];
				tok = new StringTokenizer(reader.readLine());
				for(int i = 1; i <= N; i++)
				{
					seq[i] = Integer.parseInt(tok.nextToken());
				}
				System.out.println(bfs(seq, visited, N, 0));
				
			}
		
	}
}