//https://www.acmicpc.net/problem/1931
//문제: 회의실 배정

#include <iostream>

using namespace std;

int num_of_conf(int time[][2], int N) {
    int count = 0;

    

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