#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <cstdlib>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {

	vector<vector<string>> hash_table(completion.size() + 1);
	int p_size = completion.size();
	for (int i = 0; i < completion.size(); i++)
	{
		string part = completion[i];
		int str_hash = hash<string>{}(part);
		hash_table[abs(str_hash%p_size)].push_back(part);
	}
	while (1)
	{

		for (int i = 0; i < participant.size(); i++)
		{
			string comp = participant[i];
			int str_hash = hash<string>{}(comp);
			int abs_hash = abs(str_hash % p_size);
			bool found = 0;
			if (hash_table[abs_hash].size() == 0)
			{
				return comp;
			}
			else
			{
				for (int j = 0; j < hash_table[abs_hash].size(); j++)
				{
					if (comp == hash_table[abs_hash].at(j))
					{
						hash_table[abs_hash].erase(hash_table[abs_hash].begin() + j);
						found = 1;
						break;
					}
				}
			}
			if (!found)
			{
				return comp;
			}
		}
	}

}