package dp.string;
import java.util.*;

public class DragonCurve {
	public static void curve(String seed, int generation)
	{
		if(generation == 0)
		{
			System.out.println(seed);
			return;
		}
		for(int i = 0; i < seed.length(); i++)
		{
			if(seed.charAt(i)== 'X')
				curve("X+YF", generation-1);
			else if(seed.charAt(i) == 'Y')
				curve("FX-Y", generation-1);
			else
				System.out.println(seed.charAt(i));
		}
	}
	final static int MAX = 100000000 + 1;
	static int length[] = new int[51];
	public static void precalc() {
		length[0] = 1;
		for(int i = 1; i<=50; i++)
		{
			length[i] = Math.max(MAX, length[i-1]*2 + 2);
		}
	}
	final static String EXPAND_X = "X+XF";
	final static String EXPAND_Y = "FX-Y";
	public static char expand(String dragonCurve, int generation, int skip)
	{
		if(generation == 0) {
			return dragonCurve.charAt(skip);
		}
		for(int i = 0; i < dragonCurve.length(); i++)
		{
			if(dragonCurve.charAt(i) == 'X' || dragonCurve.charAt(i)=='Y') {
				if(skip >= length[generation])
					skip -= length[generation];
				else if(dragonCurve.charAt(i) == 'X')
					return expand(EXPAND_X, generation-1, skip);
				else
					return expand(EXPAND_Y, generation-1, skip);
			}
			else if(skip > 0)
				--skip;
			else
				return dragonCurve.charAt(i);
		}
		return '#'
				; //not execute this line 
	}
	public static void main(String[] args)
	{
		
	}
}
