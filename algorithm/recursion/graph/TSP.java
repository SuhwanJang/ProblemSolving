package recursion.graph;
import java.util.*;

public class TSP {
	static int n;//number of city
	static double dist[MAX][MAX];//distance between with the two city
	//path : route have made from now
	//currentLength : distance of path
	public static double shortestPath(ArrayList<Integer> path, boolean[] visited, double currentLength)
	{
		if(path.size() == n)
			return currentLength + dist[path.get(0)][path.get(path.size()-1)];
		double ret = 987654321;
		for(int next = 0; next < n; next++)
		{
			if(visited[next]) continue;
			int here = path.get(path.size()-1);
			path.add(next);
			visited[next] = true;
			double cand = shortestPath(path, visited, dist[here][next]+currentLength);
			ret = Math.max(cand, ret);
			visited[next] = false;
			path.remove(path.size()-1);
		}
		return ret;
	}
	public static void main(String[] args)
	{
		
	}

}
