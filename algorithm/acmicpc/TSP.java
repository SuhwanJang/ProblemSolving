package acmicpc;
import java.util.*;

public class TSP {
	static int N;
	static double[][] city;
	static boolean[] visited;
	public static double travel(double currentLength, boolean[] visited, ArrayList<Integer> list)
	{
		if(list.size()==N)
			return currentLength;
		
		int cur = list.size()==0?0:list.get(list.size()-1);
		
		double ret = 0;
		for(int i = 0; i < N; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				visited[cur] = true;
				list.add(i);
				ret = Math.max(ret, travel(currentLength+city[cur][i], visited, list));
				visited[i] = false;
				visited[cur] = false;
				list.remove(i);
				list.remove(cur);
			}
		}
		return ret;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		while(C-->0)
		{
			N = sc.nextInt();
			city = new double[N][N];
			for(int i = 0; i<N; i++)
			{
				for(int j = 0; j<N; j++)
				{
					city[i][j] = sc.nextDouble();
				}
			}
			visited = new boolean[N][N];
			
		}
	}
}
