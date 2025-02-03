#include <iostream>
#include <stack>
#include <vector>
using namespace std;

void dfs(int start, const vector<vector<int>> &graph, vector<bool> &visited)
{
    stack<int> tempStore;
    visited[start] = true;
    tempStore.push(start);

    while (!tempStore.empty())
    {
        int node = tempStore.top();
        cout << node << " ";
        tempStore.pop();

        for (int neighbor : graph[node])
        {
            if (!visited[neighbor])
            {
                visited[neighbor] = true;
                tempStore.push(neighbor);
            }
        }
    }
}

int main()
{
    int V = 6; // Number of vertices
    vector<vector<int>> graph(V);

    // 0 -- 1 -- 2
    // |         |
    // 4 -- 3 -- 5
    graph[0] = {1, 4};
    graph[1] = {0, 2};
    graph[2] = {1, 5};
    graph[3] = {5, 4};
    graph[4] = {0, 3};
    graph[5] = {2, 3};

    vector<bool> visited(V, false);

    dfs(0, graph, visited);
    return 0;
}
