package acmicpc;
import java.util.*;
import java.io.*;

public class Histogram {
	public static long maxRec(int left, int right, long[] arr)
	{
		if(left == right) return arr[left];
		
		long ret = 0;
		int mid = (left + right) / 2;
		ret = maxRec(left, mid, arr);
		ret = Math.max(ret, maxRec(mid+1, right, arr));
		
		long height = arr[mid];
		long rec = arr[mid];
		int l = mid;
		int r = mid;
		long temp = 0;
		while(l > left && r < right)
		{
			if(arr[l-1] == arr[r+1])
			{
				height = Math.min(height, arr[--l]);
				r++;
			}
			else if(arr[l-1] < arr[r+1])
				{
					height = Math.min(height,  arr[++r]);
				}
			else
				{
					height = Math.min(height, arr[--l]);
				}
			temp = height * (r - l + 1);
			rec = Math.max(rec, temp);
		}
		while(l > left)
		{
			height = Math.min(height, arr[--l]);
			temp = Math.max(temp, height*(r-l+1));
			rec = Math.max(rec, temp);
		}
		while(r < right)
		{
			height = Math.min(height, arr[++r]);
			temp = Math.max(temp, height*(r-l+1));
			rec = Math.max(rec, temp);
		}
		ret = Math.max(ret, rec);
		return ret;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] line = reader.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			if(n==0) break;
			
			long[] arr = new long[n];
			for(int i = 0; i < n; i++)
			{
				arr[i] = Long.parseLong(line[i+1]);
			}
			System.out.println(maxRec(0, n-1, arr));
		}
		
	}
}
