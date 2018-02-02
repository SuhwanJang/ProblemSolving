package util;
import java.util.*;
/*
 * if X is [0, - - - n-1], return lexical ordering number
 */

public class FindLexiIndex {
	static int factorials[] = new int[12]; //factorials[i] = i!
	int getIndex(ArrayList<Integer> X)
	{
		int ret = 0;
		for(int i = 0; i<X.size(); i++)
		{
			int less = 0;
			for(int j = i+1; j<X.size(); j++)
			{
				if(X.get(j) < X.get(i))
					less++;
			}
			ret += factorials[X.size() - i - 1]*less;
		}
		return ret;
	}
}
