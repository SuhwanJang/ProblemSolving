import java.util.Scanner;

class Main
{
	public static int[] r;
	public static void rank(int person, int[][][] info)
	{
		if(person == r.length)
			return;
		int weight = info[person][0][0];
		int height = info[person][1][0];
		int rankPerson = 1;
		for(int i = 0; i < r.length; i++)
		{
			if(i != person && info[i][0][0] > weight && info[i][1][0] > height)
				rankPerson++;
		}
		r[person] = rankPerson;
		rank(person+1, info);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = new int[N];
		int[][][] info = new int[N][2][1];
		for(int i = 0; i< N; i++)
		{
			info[i][0][0] = sc.nextInt();
			info[i][1][0] = sc.nextInt();
		}
		rank(0, info);
		for(int rank : r)
			{
				System.out.print(rank + " ");
			}
	}
}