#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <unordered_map>
#include <queue>

#define PRIME_SIZE 17;

using namespace std;
typedef pair<int, int> P;

//Double Hashing
//Make M a prime number

class ComparisionClass {
public:
	bool operator() (P const &p1, P const &p2)
	{
		if (p1.first == p2.first) {
			return p1.second > p2.second;
		}
		return p1.first < p2.first;
	}
};

typedef priority_queue<P, vector<P>, ComparisionClass> Q;

int hashCode(string str, int size)
{
	int convert = hash<string>{}(str);
	convert = (abs(convert))%size;
	return convert;
}
int jump(int code, int size)
{
	return code * PRIME_SIZE;
}
vector<int> solution(vector<string> genres, vector<int> plays) {

	int i, j, genreCode;
	int gsize = genres.size();
	int M = 128;

	vector<int> answer;
	vector<Q> priorityPlayGenre(M);
	vector<P> genre_cntOfPlay(M, { 0,0 });

	string genre;

	map<string, int> genreHashIndex;
	map<int, string> bindingGenreWithIndex;
	for (i = 0; i < gsize; i++)
	{
		genre = genres[i];
		auto giter = genreHashIndex.find(genre);
		if (giter != genreHashIndex.end()) {
			genreCode = giter->second;
		}
		else
		{
			genreCode = hashCode(genre, M);
			int stepSize = (jump(genreCode, M) % M) | 1;
			int newIndex = genreCode;
			j = 1;
			auto bgwi = bindingGenreWithIndex.find(genreCode);
			while (bgwi != bindingGenreWithIndex.end()) {
				newIndex = (genreCode + j * stepSize) & (M - 1);
				bgwi = bindingGenreWithIndex.find(newIndex);
			}
			genreCode = newIndex;
			bindingGenreWithIndex.insert({ genreCode, genre });
			genreHashIndex.insert({ genre, genreCode });
		}
		
		if (genre_cntOfPlay[genreCode].second == 0) {
			genre_cntOfPlay[genreCode] = { genreCode, plays[i] };
		}
		else {
			genre_cntOfPlay[genreCode].second += plays[i];
		}
		priorityPlayGenre[genreCode].push(make_pair(plays[i], i));
	}

	Q genrePlayRank;

	for (auto ghi : genreHashIndex)
	{
		genrePlayRank.push(make_pair(genre_cntOfPlay[ghi.second].second, genre_cntOfPlay[ghi.second].first));
	}

	for (i = 0; i < gsize; i++)
	{
		if (genrePlayRank.empty()) {
			break;
		}
		genreCode = genrePlayRank.top().second;
		genrePlayRank.pop();

		int musicCnt = 0;
		while (!priorityPlayGenre[genreCode].empty())
		{
			if (musicCnt==2) {
				break;
			}
			answer.push_back(priorityPlayGenre[genreCode].top().second);
			priorityPlayGenre[genreCode].pop();
			musicCnt++;
		}
	}

	
	return answer;
}

int main()
{
	solution({ "c","p","c","c","p"}, { 150, 600, 150, 150,2500});
}