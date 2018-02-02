package dp.string;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ? == any one of character
 * * == zero or more number of character
 */
public class WildCard {
	static int N = 100;
	static int dp[][] = new int[N][N];
	static String pattern, cand;
	public static int match(int w, int s)//O(n^3)
	{
		int ret = dp[w][s];
		if(ret!=-1)
			return ret;
		while(w<pattern.length()&&s<pattern.length()&&(pattern.charAt(w)=='?'||cand.charAt(w)==pattern.charAt(s)))
		{
			w++;
			s++;
		}
		if(w==pattern.length()&&s==cand.length())
			return dp[w][s] = 1;
		if(pattern.charAt(w)=='*')
		{
			for(int skip = 0; skip+s<cand.length(); skip++)
			{
				if(match(w+1, skip+s)==1)
					return dp[w][s] = 1;	
			}
		}
		return dp[w][s] = 0;
		
	}
	public static int Opmatch(int w, int s)//O(n^2)
	{
		//if pattern[w] == cand[s] -> compare from w+1 in pattern to s+1 in cand
		int ret = dp[w][s];
		if(ret != -1)
			return ret;
		while(w < pattern.length() && s < pattern.length() && (pattern.charAt(w)=='?'||pattern.charAt(w)==cand.charAt(s)))
		{
			return dp[w][s] = Opmatch(w+1, s+1);
		}
		if(pattern.charAt(w)=='*')
		{
			if(Opmatch(w+1, s)==1 || (s<cand.length()&&Opmatch(w, s+1)==1)
					return dp[w][s] = 1;
		}
		return dp[w][s] = 0;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		while(C-->0)
		{
			pattern = sc.nextLine();
			int n = sc.nextInt();
			String cand;
			while(n-->0)
			{
				for(int d[] : dp)
					Arrays.fill(d, -1);
				
				cand = sc.nextLine();
				match(0, 0);
				if(dp[pattern.length()-1][cand.length()-1]==1)
					System.out.println(cand);
			}
		}

	}
}
