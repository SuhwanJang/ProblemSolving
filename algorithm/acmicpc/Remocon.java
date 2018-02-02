package acmicpc;
import java.util.*;

public class Remocon {
	static ArrayList<Integer> broken;
	static int numOfBroken;
	public static int canMoveChannel(int channel)
	{
		int tok = 0;
		int number = 0;
		if(channel==0)
		{
			if(broken.contains(channel))
				return -99;
			else
				return 1;
		}
		while(true)
		{
			if(channel == 0)
				break;
			tok = channel%10;
			channel /= 10;
			if(broken.contains(tok))
				return -99;
			number++;
		}
		return number;
	}
	public static void print(int channel)
	{
		if(channel==100)
		{
			System.out.println(0);
			System.exit(0);
		}
		else if(channel == 99 || channel == 101)
		{
			System.out.println(1);
			System.exit(0);
		}
		else if(channel == 98 || channel == 102)
		{
			System.out.println(2);
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int target = sc.nextInt();
		int current = 100;
		numOfBroken = sc.nextInt();
		broken = new ArrayList<>();
		for(int brokenChannel = 0; brokenChannel<numOfBroken; brokenChannel++)
		{
			broken.add(sc.nextInt());
		}
		print(target);
		int count = 0;
		int acount = Math.abs(current - target);
		if(canMoveChannel(target)!=-99)
			{System.out.println(canMoveChannel(target));
			System.exit(0);
			}
		else {
			for(int i = 1; i<500001; i++)
			{
				if(target-i>=0&&canMoveChannel(target-i)!=-99)
				{
					count = canMoveChannel(target-i)+i;
					System.out.println(Math.min(count, acount));
					System.exit(0);
				}
				if(canMoveChannel(target+i)!=-99)
				{
					count = canMoveChannel(target+i)+i;
					System.out.println(Math.min(count, acount));
					System.exit(0);
				}
			}
		}
		System.out.println(acount);
		
		
	}
}
