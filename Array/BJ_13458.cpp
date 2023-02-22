// https://www.acmicpc.net/problem/13458
// 시험감독

#include <iostream>
#define max_int 1000001

using namespace std;

int main(){
    int numClass = 0;
    cin>>numClass;
    int numStudents[max_int];
    //Get input of num of students for each classroom
    for(int i=0; i<numClass; i++) {
        cin>> numStudents[i];
    }
    int mainInsp = 0;
    cin>>mainInsp;
    int subInsp = 0;
    cin>>subInsp;

    int count = 0;
    
    for(int i=0; i<numClass; i++) {
        numStudents[i] -= mainInsp;
        count++;

        if(numStudents[i] > 0) {
            count += (numStudents[i]/subInsp);

            if(numStudents[i]%subInsp) count++;
        }
    }
    cout<<count;
    return 0;
}