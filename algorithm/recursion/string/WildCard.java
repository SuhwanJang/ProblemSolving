package recursion.string;
import java.util.*;

public class WildCard {
	public static boolean match(String w, String s)
	{
		int pos = 0;
		while(pos < w.length() && pos < s.length()&&(w.charAt(pos)=='?'||w.charAt(pos)==s.charAt(pos)))
		{
			pos ++;
		}
		if(pos==w.length())
			return pos == s.length();
		if(w.charAt(pos)=='*')
		{
			for(int skip = 0; pos+skip <s.length(); skip++)
			{
				if(match(w.substring(pos+1), s.substring(pos+skip)))
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		while(C-->0)
		{
			String pattern = sc.nextLine();
			int n = sc.nextInt();
			String cand;
			while(n-->0)
			{
				cand = sc.nextLine();
				if(match(pattern, cand))
					System.out.println(cand);
			}
		}
		
	}
}
