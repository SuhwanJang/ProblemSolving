package dp.string;
import java.util.*;

/*
 * Longest Increase String
 * S = 1, 4, 2, 6, 7
 * LIS of S = 1, 2, 6, 7 ==> length = 4
 */
public class LIS {
	static int dp[] = new int[100];
	static int S[] = new int[100];
	static final int N = 100;
	public static int lis(int start)
	{
		int ret = dp[start];
		if(ret != -1)
			return ret;
		dp[start] = 1;//always exist S[start] min length = 1
		for(int next = start+1; next < N; next++)
		{
			if(S[start] < S[next])
				ret = Math.max(ret, lis(next)+1);
		}
		return ret;
	}
	
	/*
	 * have to assign start point
	 * int maxLen = 0;
	 * for(int begin = 0; begin < N; begin++)
	 * 		maxLen = Math.max(maxLen, lis(begin));
	 * -->
	 * fix start point
	 * S[-1] = -infinite
	 * 
	 */
	public static int lis2(int start) //start = -1
	{
		int ret = dp[start+1];
		if(ret != -1)
			return ret;
		dp[start] = 1;//always exist S[start] min length = 1
		for(int next = start+1; next < N; next++)
		{
			if(start==-1||S[start] < S[next])
				ret = Math.max(ret, lis(next)+1);
		}
		return ret;
	}
	//result = lis2(-1)-1 ( S[-1] is not real value)
	/*
	 * find LIS specific sequence
	 */
	static int choices[] = new int[101];
	public static int lis4(int start) {
		int ret = dp[start+1];
		if(ret != -1) return ret;
		dp[start] = 1;
		int bestNext = -1;
		for(int next = start+1; next < N; next++)
		{
			if(start == -1 || S[start] < S[next])
			{
				int cand = lis4(next) + 1;
				if(cand > ret)
					{dp[start+1] = cand;
					bestNext = next;
					}
			}
		}
		choices[start+1] = bestNext;
		return dp[start];
	}
	public void reconstruct(int start, ArrayList<Integer> seq)
	{
		if(start != -1) seq.add(S[start]);
		int next = choices[start+1];
		if(next != -1) reconstruct(next, seq);
	}
	public static void main(String[] args)
	{
		
	}
}
