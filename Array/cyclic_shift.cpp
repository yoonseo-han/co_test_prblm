#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
using namespace std;

//helper function: Convert vector to integer
int convert_vector_to_int(vector<int> A_store, int size) {
    int number = 0;
    for(int i=0; i<size; i++) {
        number = (number*10) + A_store[i];
    }
    return number;
}

int main() {
	int TC=0; //Number of test cases
	cin>>TC;
	for (int i=0; i<TC; i++) {
		int count=0; //Count of iteration
		int size, k; //size: size of input array, k: Number of itme A is equal to B
		cin>>size>>k;
		//input of array A
		int A;
		cin>>A;
		//Store into array in reverse order
        vector<int> A_store;
        for(int j=0; j<size; j++) {
            if(A==0) {
                A_store.push_back(0);
            }
            else {
                A_store.push_back(A%10);
                A = A/10;
            }
        }
        reverse(A_store.begin(), A_store.end());
        
        //Iterate n times to find max value and max position ID
        int max=convert_vector_to_int(A_store, size), maxID=0;
        /*for(int j=1; j<size; j++) {
            //Cyclid shift of array

        }*/
        swap(A_store[0], A_store[size-1]);
        for(int j=0; j<size; j++) {
            cout<<A_store[j];
        }
	}
	return 0;
}