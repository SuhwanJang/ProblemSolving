#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;



int hashCode(string str, int size)
{
	int convert = hash<string>{}(str);
	int code = abs(convert%size);
	return code;
}
vector<int> solution(vector<string> genres, vector<int> plays) {

	int i, csize = genres.size();
	vector<int> answer;
	vector<map<int, int>> chaining_table(csize);
	map<int, int> codeWithPlayCnt(csize);
	for (i = 0; i < csize; i++)
	{
		string genre = genres[i];
		int genre_code = hashCode(genre, csize);
		chaining_table[genre_code].insert({ plays[i], i });

		auto at = codeWithPlayCnt.find(genre_code);
		if (at == nullptr) {
			codeWithPlayCnt.insert({ genre_code, plays[i] });
		}
		else {
			at->second += plays[i];
		}
	}

	sort(codeWithPlayCnt.begin(), codeWithPlayCnt.end());

	for (auto iter : codeWithPlayCnt)
	{
		int code = iter->first;
		sort(chaining_table[code].begin(), chaining_table[code].end());
		
		for (auto entry_iter : chaining_table[code])
		{
			answer.push_back(entry_iter->second);
		}
	}
	return answer;
}

int main()
{
	solution({ "classic", "pop", "classic", "classic", "pop" }, { 500, 600, 150, 800 2500 });
}