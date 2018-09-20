#include <string>
#include <vector>
#include <cmath>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

int answer=1;

int solution(vector<vector<string>> clothes)
{
	unordered_map<string, int> m;
	unordered_map<string, int>::iterator iter;
	int i;
	for (i = 0; i < clothes.size(); i++)
	{
		iter = m.find(clothes[i][1]);
		if (iter == m.end())
		{
			m.insert({ clothes[i][1], 1});
		}
		else {
			iter->second += 1;
		}
	}

	for (iter = m.begin(); iter != m.end(); iter++)
	{
		answer *= (iter->second + 1);
	}

	return answer-1;
}
int main()
{
	cout << solution({ { "ye43", "ah2ead" } ,{ "yee3", "ahead" }, { "yee23", "ahead" }, {"c3ac", "ciis" },{ "cac2", "ciis" },{ "cac", "ciis" } });

	system("pause");
}            