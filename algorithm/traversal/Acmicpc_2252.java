package traversal;

import java.util.*;
import java.io.*;

//topological sort
class Main
{
	public static void dfs(int here, int[] visited, Queue<Integer> queue, ArrayList<ArrayList<Integer>> graph)
	{
		if(visited[here] == 1) return;
		visited[here] = 1;
		
		for(int i = 0; i < graph.get(here).size(); i++)
		{
			int there = graph.get(here).get(i);
			dfs(there, visited, queue, graph);
		}
		queue.add(here);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		tok = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tok.nextToken());
		int M = Integer.parseInt(tok.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; i++)
		{
			graph.add(new ArrayList<Integer>());
		}
		
		int[] visited = new int[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= M; i++)
		{
			tok = new StringTokenizer(reader.readLine());
			int A = Integer.parseInt(tok.nextToken());
			int B = Integer.parseInt(tok.nextToken());
			graph.get(B).add(A);
		}
		
		for(int i = 1; i <= N; i++)
			dfs(i, visited, queue, graph);
		
		StringBuilder build = new StringBuilder();
		while(!queue.isEmpty())
			build.append(queue.poll()+" ");
		
		System.out.println(build.toString());
	}
}