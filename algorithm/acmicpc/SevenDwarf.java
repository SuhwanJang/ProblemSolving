import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main
{
	static int[] height = new int[9];
	static boolean find = false;
	public static void find(int idx, int totalH, ArrayList<Integer> array)
	{
		if(find)
			return;
		if(array.size() == 7)
		{
			if(totalH==100)
				find = true;
			return;
		}
		if(totalH > 100 || array.size() > 7 || idx >= 9)
			return;
		//해당 난쟁이 안 넣는 경우
		find(idx+1, totalH, array);
		//해당 난쟁이 넣는경우
		if(!find)
		array.add(height[idx]);
		find(idx+1, totalH+height[idx], array);
		if(!find)
			array.remove(array.size()-1);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<9; i++)
		{
			height[i] = sc.nextInt();
		}
		ArrayList<Integer> arr = new ArrayList<>();
		
		find(0, 0, arr);
		Collections.sort(arr);
		for(int i : arr)
			System.out.println(i);
	}
}