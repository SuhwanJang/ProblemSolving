package dp.graph;
import java.util.*;


public class TSP {
	static final int N = 100;
	static int dist[][] = new int[N][N];
	static double dp[][] = new double[N][1<<N];
	//here : current position
	//return length of shortest path from here
	//always assume start from 0's city
	//instead of boolean array, use 32bit integer type
	public static double shortestPath(int here, int visited) {
		if(visited == (1<<N)-1) return dist[here][0];
		
		double ret = dp[here][visited];
		if(ret >= 0) return ret;
		ret = 987654321;
		for(int next = 0; next < N; next++) {
			if((visited & (1<<next))==1) continue;
			double cand = dist[here][next] + shortestPath(next, visited+(1<<next));
			dp[here][visited] = Math.max(dp[here][visited], cand);
		}
		return dp[here][visited];
	}
	public static void main(String[] args)
	{
		
	}
}
