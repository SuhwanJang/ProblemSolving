package dp.optimalSolution;

public class CircleRate {
	final int INF = 987654321;
	static String N;
	//return N[a..b] difficulty 
	int classify(int a, int b)
	{
		String M = N.substring(a, b+a-1);
		//only contains one character -> difficulty = 1
		
		//check if increase sequence
		boolean progressive = true;
		
		for(int i = 0; i < M.length()-1; i++)
		{
			if(Integer.valueOf(M.charAt(i+1))-Integer.valueOf(M.charAt(i)) != Integer.valueOf(M.charAt(1))-Integer.valueOf(M.charAt(0)))
				progressive = false;
		}
		if(progressive && Math.abs(M.charAt(1)-M.charAt(0))==1)
			return 2;
		//check if appear alternately
		boolean alternating = true;
		for(int i = 0; i<M.length(); i++)
		{
			if(M.charAt(i) != M.charAt(i%2))
				alternating = false;
		}
		if(alternating) return 4;
		if(progressive) return 5; //common difference is not 1
		return 10;
	}
	static int dp[] = new int[10002];
	int memorize(int begin)
	{
		if(begin == N.length()) return 0;
		
		int ret = dp[begin];
		if(ret != -1) return ret;
		ret = INF;
		for(int L = 3; L<=5; ++L)
		{
			if(begin+L <= N.length())
				ret = Math.min(ret, memorize(begin+L)+classify(begin, begin+L-1));
		}
		return ret;
	}
	public static void main(String[] args)
	{
		
	}
}
