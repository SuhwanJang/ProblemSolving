#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
#include <map>
using namespace std;

int find_lo = 0;

int findMaxPri(vector<int> priorities, int pre_maxPri)
{
	int max_pri = 1;
	for (int i = 0; i < priorities.size(); i++)
	{
		if (max_pri <= priorities[i] && priorities[i] < pre_maxPri)
		{
			max_pri = priorities[i];
		}
	}
	return max_pri;
}


int getOrderPrinted(vector<int> priorities, int location)
{
	vector<int> sorted_vector(priorities);
	sort(sorted_vector.begin(), sorted_vector.end());
	int svIdx = sorted_vector.size() - 1;

	queue<int> q(deque<int>(priorities.begin(), priorities.end()));
	queue<int> queue_after_round;

	int order = 0;
	int max_pri = *max_element(priorities.begin(), priorities.end());
	int q_idx = 0;
	int q_size = q.size() - 1;
	int max_cnt = 0;
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();

		if (cur < max_pri)
		{
			queue_after_round.push(cur);
			if (q_idx == find_lo) {
				find_lo = queue_after_round.size() - 1;
			}
		}
		else {
			svIdx--;
			order++;
			if (max_pri != sorted_vector[svIdx]) {
				max_pri = findMaxPri(priorities, max_pri);
			}
			if (q_idx == find_lo) {
				return order;
			}
		}

		if (q_idx == q_size)
		{
			q_idx = 0;
			q_size = queue_after_round.size() - 1;
			q = queue_after_round;
			queue<int> empty;
			swap(queue_after_round, empty);
		}
		else
			q_idx++;

	}

	return order;
}
int solution(vector<int> priorities, int location) {

	find_lo = location;
	int answer = getOrderPrinted(priorities, location);
	return answer;
}