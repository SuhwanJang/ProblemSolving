package recursion.math;
import java.util.*;


public class KaratsubaFastMultiply{
	public static void normalize(int[] num)
	{
		num[num.length] = 0;
		for(int i = 0; i<num.length; i++)
		{
			if(num[i]<0)
			{
				int borrow = (Math.abs(num[i])+9)/10;
			}
			else {
				num[i+1] += num[i]/10;
				num[i] = num[i]%10;
			}
		}		
	}
	public int[] multiply(int[] a, int[] b)
	{
		int[] c = new int[a.length+b.length+1];
		for(int i = 0; i<a.length; i++)
		{
			for(int j = 0; j<b.length; j++)
			{
				c[i+j] += a[i]*b[j];
			}
		}
		normalize(c);
	}
	
	public static void main(String[] args)
	{
		
	}
}
