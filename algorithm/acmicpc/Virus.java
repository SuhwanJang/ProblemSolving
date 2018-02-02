import java.util.*;
import java.io.*;

class Main
{
	static int count = 0;
	public static void dfs(int next, Vector<Integer>[] ans, boolean[] visited)
	{
		if(visited[next]) return;
		visited[next] = true;
		int curSize = ans[next].size();
		int total = 0;
		for(int i = 0; i < curSize; i++)
		{
			if(visited[ans[next].get(i)]) continue;
			count++;
			dfs(ans[next].get(i), ans, visited);
			visited[ans[next].get(i)] = true;
		}
		return;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int pairN = sc.nextInt();
		Vector<Integer>[] ans = (Vector<Integer>[])new Vector[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i = 1; i<=N; i++)
		{
			ans[i] = new Vector<Integer>();
		}
		
		for(int i = 0; i < pairN; i++)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			ans[n1].add(n2);
			ans[n2].add(n1);
		}
		dfs(1, ans, visited);
		System.out.println(count);
	}
}