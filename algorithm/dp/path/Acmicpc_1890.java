package dp.path;

import java.io.*;

class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i, j, down, right, jump;
		String[] inputStr;
		int N = Integer.parseInt(reader.readLine());
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];
		for(i = 0; i < N; i++)
		{
			inputStr = reader.readLine().split(" ");
			for(j = 0; j < N; j++)
			{
				map[i][j] = Integer.parseInt(inputStr[j]);
			}
		}
		dp[0][0] = 1;
	    for (i = 0; i < N; i++) 
	    {
	        for (j = 0; j < N; j++) 
	        {
	            if (dp[i][j] == 0 || (i == N-1 && j == N-1)) continue;

	            jump = map[i][j];
	            down = jump + i;
	            right = jump + j;
	 
	            if (down < N) {
	                dp[down][j] += dp[i][j];
	            }
	 
	            if (right < N) {
	                dp[i][right] += dp[i][j];
	            }
	        }
	    }
		System.out.println(dp[N-1][N-1]);
	}
}