//https://www.acmicpc.net/problem/1149

#include <iostream>

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

    for(int i=0; i<N; i++) {
        for(int j=0; j<3; j++) {
            cout<<store[i][j];
        }
        cout<<endl;
    }
}