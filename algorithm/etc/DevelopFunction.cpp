#include <string>
#include <vector>
#include <queue>

using namespace std;

int getRemainWorkDay(int progress, int speed)
{
	int mok = (100 - progress ) / speed;
	int remain = (100 - progress) % speed;
	if (remain != 0) {
		return mok + 1;
	}
	return mok;
}
vector<int> solution(vector<int> progresses, vector<int> speeds) {

	vector<int> answer;
	int date = getRemainWorkDay(progresses[0], speeds[0]);
	int psize = progresses.size();
	vector<int> workDone(100, 0);
	workDone[date]+= 1;

	for (int i = 1; i < psize; i++)
	{
		int curRemain = getRemainWorkDay(progresses[i], speeds[i]);
		if (date >= curRemain)
		{
			workDone[date]++;
		}
		else {
			date = curRemain;
			workDone[date] += 1;
		}
		
	}
	for (int i = 0; i < 100; i++)
	{
		if(workDone[i] != 0)
			answer.push_back(workDone[i]);
	}
	
	return answer;
}
