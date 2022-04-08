//https://www.acmicpc.net/problem/1149

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int N;  //Number of houses
    cin>>N;
    int store[N][3]; //Array to store the cost of painting houses
    for(int i=0; i<N; i++) {
        for(int j=0; j<3; j++) {
            cin>>store[i][j];
        }
    }

    int cumulative[N][3]; //Array to store cumulative cost till it reaches house N
    //Initialize the values for 1st house
    for(int i=0; i<3; i++) {
        cumulative[0][i] = store[0][i];
    }
    //Update cumulative arrays
    for(int i=1; i<N; i++) {
        cumulative[i][0] = min(cumulative[i-1][1], cumulative[i-1][2]) + store[i][0];
        cumulative[i][1] = min(cumulative[i-1][0], cumulative[i-1][2]) + store[i][1];
        cumulative[i][2] = min(cumulative[i-1][1], cumulative[i-1][0]) + store[i][2];
    }
    //Select the smallest value at last row and return
    cout<<min(min(cumulative[N-1][0], cumulative[N-1][1]), cumulative[N-1][2]);
}