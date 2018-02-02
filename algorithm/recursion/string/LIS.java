package recursion.string;
import java.util.*;

/*
 * Longest Increase String
 */
public class LIS {
	public static int lis(int[] A)
	{
		if(A.length==0) return 0;
		int ret = 0;
		for(int i = 0; i<A.length; i++)
		{
			int[] B = new int[100];
			for(int j = i; j<A.length; j++)
			{
				if(A[i] < A[j])
					B[i] = A[j];
			}
			ret = Math.max(ret, lis(B));
		}
		return ret;
	}
	public static void main(String[] args)
	{
		
	}
}
