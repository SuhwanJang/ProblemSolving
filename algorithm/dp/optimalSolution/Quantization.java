package dp.optimalSolution;
import java.util.*;

public class Quantization {
	final static int INF = 987654321;
	//A[] will quantize sequence, sorted state
	//pSum[] : store part sum of A[]. pSum[i] = {A[0] ~ A[i]}
	//pSqSum[] : store part sum of A^2[]. pSqSum[i] = {A[0]^2 ~ A[i]^2}
	static int N = 100;
	int[] A = new int[101];
	int[] pSum = new int[101];
	int[] pSqSum = new int[101];
	void precalc() {
		Arrays.sort(A);
		pSum[0] = A[0];
		pSqSum[0] = A[0]*A[0];
		for(int i = 1; i<=N; i++)
		{
			pSum[i] = pSum[i-1] + A[i];
			pSqSum[i] = pSqSum[i-1] + A[i]*A[i];
		}
	}
	//find m that minimize of square of error with using the differential
	int minError(int lo, int hi) {
		int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo-1]);
		int sqSum = pSqSum[hi] - (lo==0?0:pSqSum[lo-1]);
		int m = (int)(0.5 + (double)sum / (hi-lo+1));
		int ret = sqSum - 2*m*sum + m*m*(hi-lo+1);
		return ret;
		
	}
	static int dp[][] = new int[101][11];
	int quantize(int from, int parts)
	{
		if(from == N) return 0;
		if(parts == 0) return INF;
		int ret = dp[from][parts];
		if(ret != -1) return ret;
		dp[from][parts] = INF;
		for(int partSize = 1; partSize <=N; partSize++)
		{
			dp[from][parts] = Math.min(dp[from][parts], minError(from, from+partSize-1) + quantize(from+partSize, parts-1));
		}
		return dp[from][parts];
		
	}
	public static void main(String[] args)
	{
		
	}
}
