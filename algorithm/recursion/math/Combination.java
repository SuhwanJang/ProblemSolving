package recursion.math;
import java.util.*;

/*
 * select n element of m numbers
 * find the number of cases
 */
class Combination
{
	static int count;
	static int pick(int n, ArrayList<Integer> numbers, int m)
	{
		if(m==0)
			return ++count;
		int smallest = numbers.isEmpty()?0:numbers.get(numbers.size()-1)+1;
		for(int j = smallest; j<n; j++)
			{
				numbers.add(j);
				pick(n, numbers, m-1);
				numbers.remove(numbers.size()-1);
			}
		
		return count;
			
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> numbers = new ArrayList<>();
		pick(N, numbers, M);
		System.out.println(count);
	}
}