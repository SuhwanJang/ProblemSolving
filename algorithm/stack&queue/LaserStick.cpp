#include <string>
#include <vector>
#include <stack>

//problem link : https://programmers.co.kr/learn/courses/30/lessons/42585

using namespace std;

int solution(string arrangement) {
	int answer = 0;
	stack<string> sticks;
	int i, j;
	string arrangementTok;

	for (i = 0; i < arrangement.length(); i++)
	{
		arrangementTok = arrangement[i];
		if (arrangementTok == "(")
		{
			sticks.push(arrangementTok);
		}
		else if (arrangementTok == ")")
		{
			string sticksTop = sticks.top();
			if (sticksTop == "(")
			{
				sticks.pop();

				if (!sticks.empty()) {
					sticks.push("l");
				}
			}
			else
			{
				int cntOfLaser = 0;
				while (sticksTop != "(")
				{
					if (sticksTop != "l") {
						cntOfLaser += stoi(sticksTop);
					}
					else {
						cntOfLaser += 1;
					}
					sticks.pop();
					sticksTop = sticks.top();
				}
				sticks.pop();
				sticks.push(to_string(cntOfLaser));
				answer += cntOfLaser + 1;
			}
		}
	}

	return answer;
}
int main()
{
	solution("()(((()())(())()))(())");
}