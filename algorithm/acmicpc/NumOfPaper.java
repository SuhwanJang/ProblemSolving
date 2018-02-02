package acmicpc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumOfPaper {
	static int[][] paper;
	static int[] num = new int[3];
	
	public static int verify(int[][] sclied)
	{
		List<int[]> arr = Arrays.asList(sclied);
		if(!arr.contains(0)&&!arr.contains(1))
			return num[0]+=1;
		else if(!arr.contains(-1)&&!arr.contains(1))
			return num[1]+=1;
		else if(!arr.contains(-1)&&!arr.contains(0))
			return num[2]+=1;
		else
			return -1;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		int M = sc.nextInt();
		sc.nextLine();
		paper = new int[M][M];
		
		for(int i = 0; i < M; i++)
		{
			String str = reader.readLine();
			tok = new StringTokenizer(str, " ");
			int j = 0;
			while(tok.hasMoreTokens())
			{
				paper[i][j] = Integer.parseInt(tok.nextToken());
				j++;
			}
		}
		
		
	}
}
