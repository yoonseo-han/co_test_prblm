#include <iostream>
#include <array>

using namespace std;

void rotate_array(int N, int array[]) {
    int temp = array[N-1];
    for(int i=N-1; i>0; i--) {
        array[i] = array[i-1];
    }
    array[0] = temp;
}

int main() {
	int TC; //Number of test case
	cin >> TC;

    for (int i=0; i<TC; i++) {
        //Input size of array and num or rotations
        int N,K;
        cin>>N>>K;
        int store[N];
        for(int j=0; j<N; j++) {
            //Get input of array
            cin>>store[j];
        }
        //Rotate array by k times
        for(int j=0; j<K; j++) {
            rotate_array(N, store);
        }
        //Print array
        for (int j=0; j<N; j++) {
            cout<<store[j]<<" ";
        }
        cout<<"\n";
    }
	
	return 0;
}