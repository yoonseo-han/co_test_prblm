//https://school.programmers.co.kr/learn/courses/30/lessons/118669
function performDFS(adjacencyList, adjacencyMatrix, startNode, gates, summits) {
    const visited = [];
    const neighbour = [];
    
    neighbour.push(startNode);
    let minDist = Number.MAX_SAFE_INTEGER;
    
    while(neighbour.length !== 0 ){
        const node = neighbour.shift();
        //If summit: stop DFS and move to next
        if(summits.includes(node)) continue;
        //If not summit: continue
        if(!visited.includes(node)) {
            visited.push(node);
            neighbour = [...adjacencyList[node], ...neighbour];
        }
    }
    
    //각 summit을 방문을 하게 될시: 아예 삭제를 하는 방법?
}

function solution(n, paths, gates, summits) {
    let adjacencyList = new Array(n+1).fill().map(() => []);

    //Adjacency list made
    for (let curPath of paths) {
        if (curPath[0] >= 0 && curPath[0] <= n && curPath[1] >= 0 && curPath[1] <= n) {
            adjacencyList[curPath[0]].push(curPath[1]);
            adjacencyList[curPath[1]].push(curPath[0]);
        }
    }
    //Adjacency matrix made
    let adjacencyMatrix = new Array(n+1).fill().map(() => new Array(n+1).fill(0));
    for(let curPath of paths) {
        if (curPath[0] >= 0 && curPath[0] <= n && curPath[1] >= 0 && curPath[1] <= n) {
            adjacencyMatrix[curPath[0]][curPath[1]] = curPath[2];
            adjacencyMatrix[curPath[1]][curPath[0]] = curPath[2];
        }
    }
    let minDistance = Number.MAX_SAFE_INTEGER;
    for(curGate of gates) {
        minDistance = Math.min(minDistance, performDFS(adjacencyList, adjacencyMatrix, startNode, gates, summits));
    }

    console.log(adjacencyMatrix);
}