//https://programmers.co.kr/learn/courses/30/lessons/42626

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int count =0;
    //Store scoville values in the form of min priority queue
    priority_queue<int, vector<int>, greater<int>> store(scoville.begin(), scoville.end());
    //First check if smallest value is larger than K -> If not, add the smallest and 2nd smallest
    //Repeat process till smallest value is larger than K
    while(store.size() > 1 && store.top() < K) {
        int smallest_1st = store.top();
        store.pop();
        int smallest_2nd = store.top();
        store.pop();
        store.push(smallest_1st+(2*smallest_2nd));
        count++;
    }
    //When add all elements and still not larger than K :return -1
    if(store.top()<K) return -1;

    return count;
}

int main() {
    vector<int> scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;

    cout<<"Number of times mixing: " <<solution(scoville, K);

    return 0;
}