//https://www.acmicpc.net/problem/7568
//문제 : 덩치

#include <iostream>

using namespace std;

void print_rank(int arr[][2], int num_person) {
    for(int i=0; i<num_person; i++) {
        int count =0;
        for (int j=0; j<num_person; j++) {
            if(i==j) {
                continue;
            }
            else {
                //If there is someone bigger in both weight and height than current person
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) {
                    count++;
                }
            }
        }
        cout<<count+1<<" ";
    }
}

int main() {
    int num_person;
    cin>>num_person;
    int ppl[num_person][2];
    for(int i=0; i<num_person; i++) {
        cin>>ppl[i][0]>>ppl[i][1];
    }
    print_rank(ppl, num_person);
    return 0;
}