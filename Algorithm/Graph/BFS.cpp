#include <iostream>
#include <queue>
#include <vector>
using namespace std;

void bfs(int start, const vector<vector<int>> &graph, vector<bool> &visited)
{
    queue<int> q;
    visited[start] = true;
    q.push(start);

    while (!q.empty())
    {
        int node = q.front();
        cout << node << " ";
        q.pop();

        for (int neighbor : graph[node])
        {
            if (!visited[neighbor])
            {
                visited[neighbor] = true;
                q.push(neighbor);
            }
        }
    }
}

int main()
{
    int V = 6; // Number of vertices
    vector<vector<int>> graph(V);

    // 0 -- 1 -- 2
    // |    |    |
    // 4    3 -- 5
    graph[0] = {1, 4};
    graph[1] = {0, 2, 3};
    graph[2] = {1, 5};
    graph[3] = {5, 1};
    graph[4] = {0};
    graph[5] = {2, 3};

    vector<bool> visited(V, false);

    bfs(0, graph, visited); // Start BFS from node 0
    return 0;
}
