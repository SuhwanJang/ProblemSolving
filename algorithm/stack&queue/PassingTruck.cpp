#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
	int answer = 0;
	int bridge_sum = 0;
	int time_count = 0;
	vector<int> time_vec(truck_weights.size() + 1, 0);
	queue<int> q;
	int to_vi = 0;
	int from_vi = 0;
	int i = 1;

	while (to_vi <= truck_weights.size() - 1)
	{

		if (q.empty())
		{
			bridge_sum = truck_weights[to_vi];
			q.push(truck_weights[to_vi++]);
			//printf("empty");
		}
		else {
			if (time_vec[from_vi] == bridge_length)
			{
				q.pop();
				bridge_sum -= truck_weights[from_vi];
				from_vi++;
			}
			int next_truck = truck_weights[to_vi];
			if (bridge_sum + next_truck <= weight)
			{
				bridge_sum += truck_weights[to_vi];
				q.push(truck_weights[to_vi++]);
				//	printf("d2");
			}
		}

		for (i = from_vi; i < to_vi; i++)
		{
			time_vec[i]++;
		}
		time_count++;
		//printf("time : %d", time_count);

	}


	time_count += bridge_length - time_vec[to_vi];

	return time_count;
}