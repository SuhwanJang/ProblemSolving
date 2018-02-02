package acmicpc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KthNum {
	static long[] seq; 
	static long kth;
	static int N;
//	static void find(ArrayList<Long> array, int K)
//	{
//		
//		if(array.size()>K)
//			return;
//		if(array.size()==K&&!array.contains(kth))
//		{
//			Collections.sort(array);
//			if(kth > array.get(K-1))
//				{kth = array.get(K-1);
//				return;
//				}
//		}
//		if(!array.isEmpty())
//			return;
//		for(int i = 0; i< N; i++)
//		{
//			if(kth < seq[i])
//				continue;
//			array.add((long) seq[i]);
//			find(array, K);
//			for(int j = i+1; j < N; j++)
//			{
//				if(kth<seq[i])
//					continue;
//				array.add((long)seq[j]);
//				find(array, K);
//				array.remove(array.size()-1);
//			}
//			array.remove(array.size()-1);
//		}
//	}
	public static void mergeSort(int left, int right)
	{
		if(right - left == 1)
		{
			if(seq[right] < seq[left])
				{
					long temp = seq[left];
					seq[left] = seq[right];
					seq[right] = temp;
				}
			return;
		}
		int m = (left+right)/2;
		mergeSort(left, m);
		mergeSort(m+1, right);
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		N = sc.nextInt();
		int K = sc.nextInt();
		seq = new long[N];
		long max = 0;
		sc.nextLine();
		String line = reader.readLine();
		tok = new StringTokenizer(line, " ");
		int i = 0;
		while(tok.hasMoreTokens())
		{
			seq[i] = Integer.parseInt(tok.nextToken());
			max = Math.max(max, seq[i++]);
		}
		kth = max;
		mergeSort(0, N-1);
		System.out.println(seq[K-1]);
	}
}
