package acmicpc;
import java.util.*;

public class Ball {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		/*
		 * 처음 공이 1번컵에 위치
		 * &1 3 1 -> case에 ball idx포함하므로 ball idx = 3
		 * &2 2 3 -> case에 ball idx포함 ball idx = 2
		 */
		int ball = 1;
		for(int i = 0; i <M; i++)
		{
			int first = sc.nextInt();
			int second = sc.nextInt();
			if(first==ball)
			{
				ball = second;
			}
			else if(second == ball)
			{
				ball = first;
			}
			else
				continue;
		}
		System.out.println(ball);
	}
}
