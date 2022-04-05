#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

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
        
	}
	return 0;
}