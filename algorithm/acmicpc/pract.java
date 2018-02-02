package acmicpc;
import java.util.*;

public class pract {
	static int[] num = {1, 4, 5, 2, 6};
	public static void go(ArrayList<Integer> arr)
	{
		if(!arr.isEmpty())
		{
			System.out.printf("num in arr : ");
			for(Integer it : arr)
			{
				System.out.printf(it+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < 5; i++)
		{
			arr.add(num[i]);
			go(arr);
			for(int j = i+1; j < 5; j++)
			{
				arr.add(num[j]);
				go(arr);
			}
			for(int j = i+1; j < 5; j++)
			{
				arr.remove(arr.size()-1);
			}
			arr.remove(arr.size()-1);
		}
	}
	public static void main(String[] args)
	{
		go(new ArrayList());
	}
}
