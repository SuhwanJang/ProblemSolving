package dp.string;
import java.util.*;

public class UnionLIS {
	static int dp[][] = new int[101][101];
	static int n, m;
	static int A[] = new int[100]; // A = 1, 5, 4
	static int B[] = new int[100]; // B = 2, 6, 7
	//lisResult = lisA(1, 4) + lisB(2, 6, 7) = 1, 2, 4, 6, 7  ==> length = 5
	final static long NEGINF = Long.MIN_VALUE;
	public static int lis(int indexA, int indexB)//start with -1
	{
		int ret = dp[indexA+1][indexB+1];
		if(ret!=-1)
			return ret;
		ret = 2;
		long a = (indexA==-1)?NEGINF:A[indexA];
		long b = (indexB==-1)?NEGINF:B[indexB];
		long maxElement = Math.max(a, b);
		for(int nextA = indexA+1; nextA<100; nextA++)
		{
			if(a < A[nextA])
				dp[indexA][indexB] = Math.max(dp[nextA][indexB], dp[indexA][indexB]);
		}
		for(int nextB = indexB+1; nextB<100; nextB++)
		{
			if(b < B[nextB])
				dp[indexA][indexB] = Math.max(dp[indexA][nextB], dp[indexA][indexB]);
		}
		return dp[indexA][indexB];
	}
	
	public static void main(String[] args)
	{
		
	}
}
