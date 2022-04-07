// https://programmers.co.kr/learn/courses/30/lessons/42860

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(string name) {
    int count = 0;
    
    int move = name.size()-1; //record the left,right movement

    for(int i=0; i<name.size(); i++) {
        //Total updown movement 
        count += min(name[i]-'A', 'Z'-name[i]+1);

        //Calculate consecutive last index of consecutive 'A's from current position
        int consecutive_A = i+1;
        while(consecutive_A<name.size() && name[consecutive_A] == 'A') {
            consecutive_A++;
        }
        //Compare whether it is fast to go through the consecutive A or move backwards
        move = min(move, i*2+name.size() - consecutive_A);
    }

    return count;
}

int main() {
    string name = "JAZ";
    cout<<"Count : "<<solution(name);
    return 0;
}