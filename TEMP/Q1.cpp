#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    string input;
    getline(cin, input);

    vector<int> numList;
    int curNum = 0;
    bool beforeColon = true;

    for (char c : input) {
        if (c == ':') {
            beforeColon = false;
        } else if (c == ',' && beforeColon) {
            numList.push_back(curNum);
            curNum = 0;  
        } else if (beforeColon) {
            curNum = curNum * 10 + (c - '0');
        }
    }

    // Store the last number if it was before the colon
    if (beforeColon) {
        numList.push_back(curNum);
    } else {
        // Handle the number after the colon if it exists
        curNum = stoi(input.substr(input.find(':') + 1));
    }
    // Display the extracted data
    cout << "Numbers before colon: ";
    for (int num : numList) {
        cout << num << " ";
    }
    cout << endl;

    cout<<curNum;

    return 0;
}
