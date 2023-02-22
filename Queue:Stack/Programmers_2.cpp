//https://programmers.co.kr/learn/courses/30/lessons/42583
//다리를 지나는 트럭

#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

//helper function to calculate total weight on vector
int calculate_weight(vector<int> weight, int start) {
    int total_weight=0;
    for(int i=start; i<weight.size(); i++) {
        total_weight+=weight[i];
    }
    return total_weight;
}

//helper function to shift values of vector
void update_vector(vector<int> &ref) {
    if(!ref.empty()) {
        for(int i=0; i<ref.size()-1; i++) {
            ref[i] = ref[i+1];
        }
        ref.pop_back();
    }
}

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int time = 0;
    //queue to store 
    queue <int> store;
    //bridge queue
    queue <int> bridge;
    //Vector to store all finished trucks
    vector<int> finished;
    int numElements = truck_weights.size();
    //store vector in form of queue
    for(int i=0; i<numElements; i++) {
        store.push(truck_weights[i]);
    }
    int total_weight = calculate_weight(truck_weights, 0);
    //Repeate till store queue is empty
    while(calculate_weight(finished,0)!=total_weight) {
        int store_front = store.front();
        //get total weight on bridge = total weight - total weight in waiting array (excluding the front element)
        int weight_on_bridge = total_weight - calculate_weight(truck_weights, 0) - calculate_weight(finished,0);
        //Subtract weight on bridge from the front of bridge (if bridge is not null)
        if(!bridge.empty() && bridge.size()==bridge_length) weight_on_bridge -= bridge.front();
        //Add the first element on truck_weights for weight_on_bridge
        if(!truck_weights.empty()) weight_on_bridge += truck_weights.front();
        //Compare the updated new weight is smaller or equal to bridge max weight
        if(weight_on_bridge<=weight) {
            //If so, update the members on store queue, bridge queue, truckweights vector
            if(!bridge.empty() && bridge.size() == bridge_length) {
                finished.push_back(bridge.front());
                bridge.pop();
            }
            bridge.push(store_front);
            store.pop();
            //Update vector
            update_vector(truck_weights);
        }
        else {
            //If not, leve the store queue and truck weights unchaged, 
            //Remove front on bridge and add 0 to end
            if(!bridge.empty() && bridge.size() == bridge_length) {
                finished.push_back(bridge.front());
                bridge.pop();
            }
            bridge.push(0);
        }
        //For both cases increment time by 1
        time++;
    }
    return time;
}

int main() {
    int bridge_length = 2;
    int weight = 10;
    vector<int> truck_weights {7,4,5,6};

    int time = solution(bridge_length, weight, truck_weights);
    cout<<"time: "<<time;

    return 0;
}