//Programmers question: https://programmers.co.kr/learn/courses/30/lessons/42587
#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    //ADd the priorities in queue
    queue<int> store;
    //flag to check 
    bool print;
    for(int i=0; i<priorities.size(); i++) {
        store.push(priorities[i]);
    }
    //If there is only 1 document
    if(priorities.size()==1) {
        return 1;
    }
    while(1) {
        //condition for print: when there is no higher priority than front -> answer++
        //Iterate to check if there is element with higher priority than front
        for(int i=0; i<priorities.size(); i++) {
            //After iterating till end of queue, When there is doc with higher priority, move front to back: Nothing printed, therefore count does not increase
            int cmp = store.front();
            if(cmp < priorities[i]) {
                //If the following document is the document to find, move location to end of queue
                if(location == 0) {
                    location = store.size()-1;
                } 
                else {
                    location--;
                }
                int temp = store.front();
                store.pop();
                store.push(temp);
                //Update the vector priority aswell : shift values, while moving first element to end
                int temp2 = priorities[0];
                for(int j=1; j<priorities.size(); j++) {
                    priorities[j-1] = priorities[j];
                }
                priorities[priorities.size()-1] = temp2;
                //Check print as false
                print = false;
                break;
            } else {
                print = true;
            }
        }
        //When iterate till end, and there is no doc with higher priority than doc
        //When the front has highest priority: print the document
        if(print == true){
            if(location == 0) {
                //Doc of track is printed : Ending condition
                return answer+1;
            } 
            else {
                //When other doc is printed
                store.pop();
                answer++;
                if(location == 0) {
                    location = store.size()-1;
                } 
                else {
                    location--;
                }
                //Update the vector priority: shift values, ignore the first element
                for(int j=1; j<priorities.size(); j++) {
                    priorities[j-1] = priorities[j];
                }
                priorities.pop_back();
            }
        }
    }
    return answer;
}