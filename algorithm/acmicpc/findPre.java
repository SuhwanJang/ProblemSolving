package acmicpc;
import java.util.*;
import java.io.*;

public class findPre {
	static int[] inOrder, postOrder;
	static int n;
	public static String preOrder(int from, int to, int root)
	{
		if(from > to || from <= 0 || to == n+1 || root <= 0)
			return "";
		System.out.println("from : "+from+" to : "+ to + " root: "+ root);
		if(to - from == 1)
			return inOrder[to] + " "+inOrder[from];
		if(to - from == 0)
			return inOrder[to] + "";
			
		int rootIdx = -1;
		String str = "";
		for(int i = from; i <= to; i++)
		{
			if(root == inOrder[i])
				{
					rootIdx = i;
					break;
				}
		}
		
		if(rootIdx == -1)
			return "";
		
		str += root + " " + preOrder(from, rootIdx-1, inOrder[rootIdx-2]);
		str += preOrder(rootIdx+1, to, getRoot(root));
		return str;
	}
	public static int getRoot(int root)
	{
		for(int i = 1; i <= n; i++)
		{
			if (root == postOrder[i])
				return postOrder[i-1];
		}
		return -9999;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		
		n = reader.read()-'0';
		reader.readLine();
		inOrder = new int[n+1];
		postOrder = new int[n+1];
		
		for(int i = 0; i < 2; i++)
		{
			String line = reader.readLine();
			tok = new StringTokenizer(line, " ");
			int j = 1;
			while(i == 0 &&tok.hasMoreTokens())
			{
				inOrder[j++] = Integer.parseInt(tok.nextToken());
			}
			j = 1;
			while(i == 1 &&tok.hasMoreTokens())
			{
				postOrder[j++] = Integer.parseInt(tok.nextToken());
			}
		}
		System.out.println(preOrder(1, n, postOrder[n]));
	}
}
