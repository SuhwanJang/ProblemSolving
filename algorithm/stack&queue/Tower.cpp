#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights) {

	vector<int> answer;
	int i = 0;
	while (i != heights.size())
	{
		int cur_height = heights[i];
		int find_flag = 0;
		for (int j = i - 1; j >= 0; j--)
		{
			if (cur_height < heights[j])
			{
				find_flag = 1;
				answer.push_back(j + 1);
				break;
			}
		}
		if (!find_flag)
		{
			answer.push_back(0);
		}
		i++;
	}
	return answer;
}