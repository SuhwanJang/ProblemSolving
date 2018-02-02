package acmicpc;
import java.util.*;

public class TrianglePath {
	static final long NEGINF = Long.MIN_VALUE;
	static int n, m, A[], B[], dp[][];
	public static int jlis(int indexA, int indexB)
	{
		int ret = dp[indexA+1][indexB+1];
		if(ret != 0) return ret;
		
		ret = 2;
		long a = (indexA==-1?0:A[indexA]);
		long b = (indexB==-1?0:B[indexB]);
		long maxElement = Math.max(a, b);
		for(int next = indexA+1; next < n; next++)
		{
			if(maxElement < A[next])
			{
				ret = Math.max(ret, jlis(next, indexB)+1);
			}
		}
		for(int next = indexB+1; next< n; next++)
		{
			if(maxElement < B[next])
			{
				ret = Math.max(ret, jlis(indexA, next)+1);
			}
		}
	}
	public static void main(String[] args)
	{
		A = new int[100];
		B = new int[100];
		dp = new int[101][101];
		
		
	}
	
}
