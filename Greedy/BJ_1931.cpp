//https://www.acmicpc.net/problem/1931
//문제: 회의실 배정

//Key : Always select the conference that ends the fastest
/*pseudo code
1. Push the conference in order of ealiest end priority queue -> Order jobs in increasing ending time
2. Pop the conference with earliest end time (If conference with multiple same end time, choose one with smallest start time)
3. Pop the next conference and compare if the start time is larger than previous conference end time
4. If false, continue
5. If true, add to list and move to next
*/

#include <iostream>
#include <queue>
#include<bits/stdc++.h>

using namespace std;

int num_of_conf(int time[][2], int N) {
    int count = 0;

    //Increasing priority queue, storing pair of values
    priority_queue<pair<int, int>, vector<int>,greater<int>> store;
    for(int i=0; i<N; i++) {
        //Store in order with respect to end time
        store.push(make_pair(time[i][1], time[i][0]))
    }

    return count;
}

int main() {
    int N;
    cin>>N;
    int time[N][2];
    for(int i=0; i<N; i++) {
        cin>>time[i][0]>>time[i][1];
    }
    cout<<num_of_conf(time, N);

    return 0;
}