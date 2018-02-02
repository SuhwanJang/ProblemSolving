import java.util.Scanner;

class Main
{
	public static int getSplitSum(int N)
	{
		int sum, quo, mod;
		sum = N;
		while(N>0)
			{
				quo = N/10;
				mod = N%10;
				sum += mod;
				N = quo;
			}
		return sum;
	}
	public static int find(int N)
	{
		for(int i = 1; i<= N; i++)
		{
			if(getSplitSum(i)==N)
				return i;
		}
		return 0;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int inputSum = sc.nextInt();
		System.out.println(find(inputSum));
	}
}