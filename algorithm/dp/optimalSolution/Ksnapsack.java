package dp.optimalSolution;
import java.util.*;

public class Ksnapsack {
	static int dp[][] = new int[100][100];
	static int volume[] = new int[100];
	static String name[] = new String[100];
	public static int pack(int capacity, int item)//return max Desperation sum
	{
		if(capacity==item) return 0;
		if(dp[capacity][item] != -1)
			return dp[capacity][item];
		//not pack this item
		int ret = pack(capacity, item+1);
		if(capacity >= volume[item])
		{
			ret = Math.max(ret, pack(capacity-volume[item], item+1));
		}
		return dp[capacity][item] = ret;
	}
	public static void reconstruct(int capacity, int item, ArrayList<String> picked)
	{
		if(item==99) return;
		if(pack(capacity, item)==pack(capacity, item+1)) {
			reconstruct(capacity, item+1, picked);
		}
		else
		{
			picked.add(name[item]);
			reconstruct(capacity-volume[item], item+1, picked);
		}
		
		
	}
	public static void main(String[] args)
	{
		
	}
}
