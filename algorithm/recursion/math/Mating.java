package recursion.math;
import java.util.*;

class Mating
{
	int n;
	static boolean areFriends[][] = new boolean[10][10];
	static int N = 10;
	public static int failCountPairing(boolean taken[])
	{
		boolean finished = true;
		for(int i = 0; i<N; i++) if(!taken[i]) finished = false;
		if(finished) return 1;
		int ret = 0;
		for(int i = 0; i<N; i++)
		{
			for(int j = 0; j<N; j++)
			{
				if(!taken[i]&&!taken[j]&&areFriends[i][j])
				{
					taken[i] = taken[j] = true;
					ret += failCountPairing(taken);
					taken[i] = taken[j] = false;
				}
			}
		}
		return ret;
	}
	public static int correctCountPairing(boolean taken[])
	{
		int firstFree = -1;
		for(int i = 0; i<N; i++)
		{
			if(!taken[i])
			{
				firstFree = i;
				break;
			}
		}
		if(firstFree == -1) return 1;
		int ret = 0;
		
		for(int i = firstFree+1; i<N; i++)
		{
			if(!taken[i]&&areFriends[firstFree][i])
			{
				taken[firstFree] = taken[i] = true;
				ret += correctCountPairing(taken);
				taken[firstFree] = taken[i] = false;
			}
		}
		return ret;
	}
	public static void main(String[] args)
	{
		
	}
}