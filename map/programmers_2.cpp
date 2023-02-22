//https://programmers.co.kr/learn/courses/30/lessons/42576

#include <iostream>
#include <map>
#include <vector>
#include <string>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer;
    map<string, int> record;
    //Record participants to map
    for(int i=0; i<participant.size(); i++) {
        record[participant[i]] += 1;
    }
    //Decrease count for completed people in map
    for(int i=0; i<completion.size(); i++) {
        record[completion[i]] -= 1;
    }
    //Iterate over participant and store value if int value is larger than 0
    for(string m: participant) {
        if(record[m] > 0) {
            answer = m;
            break;
        }
    }
    return answer;
}

int main() {
    vector<string> participant = {"mislav", "stanko", "mislav", "ana"};
    vector<string> completion = {"stanko", "ana", "mislav"};

    cout<<"Not completed : "<<solution(participant, completion);
}