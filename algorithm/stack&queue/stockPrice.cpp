#include <string>
#include <vector>
#include <stack>
using namespace std;

vector<int> solution(vector<int> prices) {
	vector<int> answer(prices.size());
	stack<pair<int, int>> price;
	int i;
	price.push({ 0,prices[0] });
	for (i = 1; i < prices.size(); i++)
	{
		int cur = prices[i];
		while (!price.empty())
		{
			int topStack = price.top().second;
			if (topStack > cur) {
				answer[price.top().first] = i - price.top().first;
				price.pop();
			}
			else {
				break;
			}
		}
		price.push({ i, cur });
	}
	while (!price.empty()) {
		answer[price.top().first] = prices.size() - price.top().first -1;
		price.pop();
	}
	return answer;
}
int main()
{
	solution({ 498, 501, 470, 489 });
}