//https://www.acmicpc.net/problem/1780
//종이의 개수
#include <iostream>
#include <vector>

using namespace std;

int result[3]={0,0,0}; //Count the number of values of page with -1, 0, 1

//Helper function to see if all array is composed of same element
bool check_paper(vector<vector<int>> paper, int size) {
    //If size is 1x1, return true;
    if(size == 1) {
        return true;
    }
    //For paper with size NxN
    int N = size;
    //Reference to check if all elements have same value
    int first = paper[0][0];
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            //Atleast one of them is different : return false
            if(first != paper[i][j]) {
                return false;
            }
        }
    }
    return true;
}

//Helper function to divide array into 9 equal parts and return ith subpart of divided paper
vector<vector<int>> divide(vector<vector<int>> paper, int size, int ith) {
    vector<vector<int>>temp;
    int newSize = size/3;
    int shiftDown = (ith/3)*newSize;
    int shiftRight = (ith%3)*newSize;
    for(int i=0; i<newSize; i++) {
        vector<int> tempRow;
        for(int j=0; j<newSize; j++) {
            int element = paper[shiftDown+i][shiftRight+j];
            tempRow.push_back(element);
        }
        temp.push_back(tempRow);
    }
    return temp;
}

void calculate_weight(vector<vector<int>> paper, int size) {
    //Base condition: When paper is composed of same elements
    if(check_paper(paper, size)) {
        int num = paper[0][0];
        result[num+1]++;
        return;
    }
    else {
        //PAper is composed of different elements: Divide paper into 9 parts
        for(int i=0; i<9; i++) {
            vector<vector<int>> temp = divide(paper, size, i);
            calculate_weight(temp, size/3);
        }
    }
}

int main() {
    int N;
    cin>>N;
    vector<vector<int>> paper;
    for(int i=0; i<N; i++) {
        vector<int> temp;
        for(int j=0; j<N; j++) {
            int tempVal;
            cin>>tempVal;
            temp.push_back(tempVal);
        }
        paper.push_back(temp);
    }
    calculate_weight(paper, N);
    //Print final result
    for(int i=0; i<3; i++) {
        cout<<result[i]<<endl;
    }
    return 0;
}