//프로그래머스 
//신고결과 받기 : https://programmers.co.kr/learn/courses/30/lessons/92334
#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <set>

using namespace std;

void print_Map(unordered_map <string, set<string>> record) {
    for(auto i = record.begin(); i!=record.end(); i++) {
        cout<<i->first<<": ";
        //cout<<i->second.size();
        for(auto j = i->second.begin(); j!= i->second.end(); j++) {
            cout<<*j<< ",";
        }
        cout<<endl;
    }
    return;
}

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    //Store in map to prevent any duplication of records
    //Save the reported person in key and the person who reported as values
    //person who reported should not be duplicated, therefore stored as set
    unordered_map <string, set<string>> record;
    //Save the (report, person who reported) in a pair of map
    for(int i=0; i<id_list.size(); i++) {
        int length = id_list[i].size();
        int count = 0;
        for(int j=0; j<report.size(); j++) {
            if(report[j].substr(0,length)==id_list[i]) {
                record[report[j].substr(length+1,report[j].size())].insert(report[j].substr(0,length));
            }
        }
    }
    //print_Map(record);
    
    for(auto i = record.begin(); i!=record.end(); i++) {
        //Erase the reports that have report number less than k from the map
        if(i->second.size()<k) {
            record.erase(i->first);
        }
    }
    //Iterate over the report and find if current key is located inside the reported person. If included, increase count by 1
    for(int i=0; i<id_list.size(); i++) {
        string compare = id_list[i];
        //Iterate over map to see if compare is a value of the key
        int count = 0;
        for(auto i=record.begin(); i!=record.end(); i++) {
            for(auto j = i->second.begin(); j!= i->second.end(); j++) {
                if(*j == compare) {
                    count++;
                }
            }
        }
        answer.push_back(count);
    }
    
    return answer;
}