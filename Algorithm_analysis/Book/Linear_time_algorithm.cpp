//Moving average algorithm

#include <iostream>
#include <vector>

using namespace std;

void print_vector(vector<int> a) {
    for(int i=0; i<a.size(); i++) {
        cout<<a[i];
    }
    cout<<'\n';
}

//Following algorithm uses 2 loops to calculate the average every time
//Has complexity of O(n^2)
vector<int> movingAverage1(const vector<int> A, int N) {
    vector<int> temp;
    int size = A.size();
    for(int i=N-1; i<size; i++) {
        //Calculate averqage of the last N elements
        //Have to start on N-1th element
        int sum = 0;
        for(int j=0; j<N; j++) {
            sum += A[i-j];
        }
        temp.push_back(sum/N);
    }
    return temp;
}

//Calculate the sum without loop: Update based on 중복 values of calculating sum
//Has O(n) complexity
vector<int> movingAverage2(const vector<int> A, int N) {
    int size = A.size();
    vector<int> store;
    //Calculate the new partial sum by removing the first item and adding the ith item to the sum
    //Updating the sum without looping for new calculation every time
    int partialSum = 0;
    for(int i=0; i<N-1; i++) {
        partialSum += A[i];
    }

    for(int i=N-1; i<size; i++) {
        partialSum += A[i]; //Add the newly added element to the array of N elements
        store.push_back(partialSum/N);
        partialSum -= A[i-N+1]; //Deleting the first element included in the partial sum
    }

    return store;
}

int main() {
    //Calculate the moving average of the latest N data items added
    int N; //Lastest N data to deal with
    cout<<"Number of latest data : ";
    cin>>N;
    int M;
    cout<<"Size of vector : ";
    cin>>M;
    vector<int> store;
    int temp;
    cout<<"Input Vector: ";
    for(int i=0; i<M; i++) {
        int temp;
        cin>>temp;
        store.push_back(temp);
    }
    print_vector(movingAverage1(store, N));
    print_vector(movingAverage2(store, N));
}

