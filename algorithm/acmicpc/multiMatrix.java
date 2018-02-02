package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class multiMatrix {
	public static void make(int[][] arr, int N, int M, BufferedReader reader) throws IOException
	{
		StringTokenizer tok;
		int i = 0;
		while(i!=N)
		{
			String str = reader.readLine();
			tok = new StringTokenizer(str, " ");
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = Integer.parseInt(tok.nextToken());
			}
			i++;
		}
	}
	public static void multi(int[][] A, int[][] B)
	{
		int al = A.length;
		int bt = B[0].length;
        int m = A[0].length;
		int[][] result = new int[al][bt];
		
		for(int i = 0; i < al; i ++)
			for(int j = 0; j < bt; j++)
				for(int k = 0; k < m; k++)
					result[i][j] += A[i][k] * B[k][j];
		
		for(int i = 0; i < al; i++)
		{
			for(int k : result[i])
				System.out.print(k+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		String[] line;
		int[][] A, B;
		
		line = reader.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		A = new int[N][M];
		make(A, N, M, reader);
		
		line = reader.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		B = new int[N][M];
        
		make(B, N, M, reader);
		multi(A, B);
	}
}
