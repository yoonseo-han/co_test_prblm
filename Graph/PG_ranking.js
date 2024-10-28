//https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=java

class Graph {
    constructor() {
        this.adjacencyList = new Map();
    }

    containsNode(nodeVal) {
        let result = [];
        for(let [key, val] of this.adjacencyList) {
            if(val.contains(nodeVal)) result.add(key);
        }
        return result;
    }
}

function setUpGraph(graph, results) {
    for(let [key, val] of results) {
        if(graph.adjacencyList.has(key)) {
            let curArray = graph.adjacencyList.get(key);
            graph.adjacencyList.set(key, [...curArray, val]);
        } else {
            graph.adjacencyList.set(key, [val]);
        }
    }
}

function combineGraph(graph) {
    for(let [key, val] of graph.adjacencyList) {
        
    }
}

function solution(n, results) {
    var answer = 0;
    let graph = new Graph();
    setUpGraph(graph, results);
    combineGraph(graph);

    return answer;
}


let results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]];
solution(5, results);