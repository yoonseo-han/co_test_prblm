#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

//helper function: Convert vector to integer
int convert_vector_to_int(vector<int> A_store, int size) {
    int number = 0;
    for(int i=0; i<size; i++) {
        number = (number*10) + A_store[i];
    }
    return number;
}

void shift_vector_by_one(vector<int> & A_store, int size) {
    int temp = A_store[0];
    for(int k=0; k<size-1; k++) {
        A_store[k] = A_store[k+1];
    }
    A_store[size-1] = temp;
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
        for(int j=1; j<size; j++) {
            //Cyclid shift of array
            shift_vector_by_one(A_store,size);
            //Compare to max and update if larger
            if(max<convert_vector_to_int(A_store, size)) {
                max = convert_vector_to_int(A_store, size);
                maxID = j;
            }
        }
        //Update count
        count = maxID;
        k--;
        //Restore original form 
        shift_vector_by_one(A_store, size);
        int origitnal_Val = convert_vector_to_int(A_store,size);
        while(k != 0) {
            shift_vector_by_one(A_store,size);
            if(origitnal_Val == convert_vector_to_int(A_store,size)) {
                k--;
            }
            count++;
        }
        cout<<count<<'\n';
	}
	return 0;
}