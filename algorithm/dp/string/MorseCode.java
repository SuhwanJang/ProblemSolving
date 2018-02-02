package dp.string;
import java.util.*;

/*
 * find Kth morsecode
 */
public class MorseCode {

	public void generate(int n, int m, String s)// make possible all code
	{
		if(n==0 && m==0)
		{
			System.out.println(s);
			return;
		}
		if(n>0) generate(n-1, m, s+"-");
		if(m>0) generate(n, m-1, s+"o");
	}
	static int skip;
	public void generate2(int n, int m, String s)//make only Kth code
	{
		if(skip<0)
			return;
		if(n==0 && m==0)
		{
			if(skip==0) System.out.println(s);
			skip--;
			return;
		}
		if(n>0) generate2(n-1, m, s+"-");
		if(m>0) generate2(n, m-1, s+"o");

	}
	/*
	 * generate2 have to make code until Kth codeax
	 * if value of k is high, time complexity bad
	 * -->using binomial coefficient, skip more efficient 
	 */
	static final int M = 100000000+100;// max of K is 100. prevent it from overflow when bino calc
	static int bino[][] = new int[201][201];
	static int skip2;
	static void calcBino() {
		for(int b[] : bino)
			Arrays.fill(b, 0);
		for(int i = 0; i<=200; i++) {
			bino[i][0] = bino[i][i] = 1;
			for(int j = 1; j<i; j++) {
				bino[i][j] = Math.min(M, bino[i-1][j-1] + bino[i-1][j]);
			}
		}
	}
	static void generate3(int n, int m, String s)
	{
		if(skip2 < 0) return;
		if(n==0 && m==0)
		{
			if(skip2 == 0) System.out.println(s);
			skip2--;
		}
		if(bino[n+m][n] <= skip2) {
			skip -= bino[n+m][n];
			return;
		}
		if(n>0) generate3(n-1, m, s+"-");
		if(m>0) generate3(n, m-1, s+"o");
	}

public static void main(String[] args)
{

}
}
