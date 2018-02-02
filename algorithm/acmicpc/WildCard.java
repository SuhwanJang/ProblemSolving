package acmicpc;
import java.util.*;

public class WildCard {
	static String target;
	static String[] pattern;
	int dp[][]
	public static int match(int w, int x, String cand)
	{
		while(w<target.length()&&x<cand.length()&&(target.charAt(w)=='?'||target.charAt(w)==cand.charAt(x)))
		{
			w++;
			x++;
		}
		if(w==target.length()&&x==cand.length())
			return 1;
		if(w<target.length())
		{
			if(target.charAt(w)=='*')
				return match(w+1, x, cand);
			else
				return -1;
		}
		else
			return -1;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while(C-->0)
		{
			sc.nextLine();
			target = sc.next();
			sc.nextLine();
			int N = sc.nextInt();
			sc.nextLine();
			pattern = new String[N];
			for(int i = 0; i<N; i++)
			{
				String cand = sc.next();
				System.out.println(match(0, 0, cand));
			}
		}
	}
}
