package traversal;

import java.util.*;
import java.io.*;

class Main
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
        tok = new StringTokenizer(reader.readLine(), " ");
		int N = Integer.parseInt(tok.nextToken());
		int M = Integer.parseInt(tok.nextToken());
		
        int trust, trustee;
		int[] count = new int[N+1];
		
		ArrayList<Integer> com = new ArrayList<>();
		ArrayList<ArrayList<Integer>> connectedCom = new ArrayList<>();
		int max = 0;
        
		for(int i = 0; i <= N; i++)
			connectedCom.add(new ArrayList<>());
        
		for(int i = 1; i <= M; i++)
		{
			tok = new StringTokenizer(reader.readLine());
			trust = Integer.parseInt(tok.nextToken());
			trustee = Integer.parseInt(tok.nextToken());
			
			connectedCom.get(trustee).add(trust);
		}
        
		int cur, next, curCount;
		ArrayList<Integer> curCom;
		for(int i = 1; i <= N; i++)
		{
			boolean[] visited = new boolean[N+1];
			visited[i] = true;
			curCount = 0;

			com.add(i);
			cur = i;
			
			while(!com.isEmpty())
			{
				cur = com.remove(com.size()-1);
				curCom = connectedCom.get(cur);
				for(int j = 0; j < curCom.size(); j++)
				{
					next = curCom.get(j);
					if(!visited[next])
					{
							com.add(next);
							curCount += 1;
							visited[next] = true;
					}
				}
			}
			count[i] = curCount;
			max = Math.max(curCount, max);
		}
        
		StringBuilder builder = new StringBuilder();
		for(int i = 1; i <= N; i++)
			if(max == count[i])
				builder.append(i).append(" ");
		System.out.println(builder.toString());
	}
}