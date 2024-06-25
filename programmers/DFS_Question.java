import java.util.*;

class Node {
    int curID;
    int curConsumption;
    int powerLimit;
    int numDevice;
    List<Node> childNode;

    Node(int curID, int curConsumption, int powerLimit , int numDevice) {
        this.curID = curID;
        this.curConsumption = curConsumption;
        this.powerLimit = powerLimit;
        this.numDevice = numDevice;
        this.childNode = new ArrayList<>();
    }
}

class Solution {
    private  void calculateParentsAndLeafNodes(Node node, Map<Node, Node> parentMap, Queue<Node> leafNodes) {
        for (Node child : node.childNode) {
            parentMap.put(child, node);
            calculateParentsAndLeafNodes(child, parentMap, leafNodes);
        }
        if (node.childNode.isEmpty()) {
            leafNodes.add(node);
        }
    }

    public int calculateCurConsumption(Node node, int k) {
        // Base case for leaf nodes
        if (node.childNode.isEmpty()) {
            node.curConsumption = node.numDevice * k;
            return node.curConsumption;
        }

        int childConsumptionSum = 0;
        for (Node child : node.childNode) {
            childConsumptionSum += calculateCurConsumption(child, k);
        }

        node.curConsumption = (node.numDevice * k) + childConsumptionSum;

        return node.curConsumption;
    }

    private int numDeviceRemoved(Node curNode, int k) {
        int deviceCount = 0;

        if(curNode.curConsumption == 0 && curNode.childNode.isEmpty()) return 0;

        // Recursive call to adjust child nodes first
        for (Node childNode : curNode.childNode) {
            deviceCount += numDeviceRemoved(childNode, k);
        }

        // Recalculate cuConsuption based on child node chjange
        int childConsumptionSum = 0;
        for (Node childNode : curNode.childNode) childConsumptionSum += childNode.curConsumption;
        curNode.curConsumption = (curNode.numDevice * k) + childConsumptionSum;

        // If current consumption exceeds limit
        if (curNode.curConsumption > curNode.powerLimit) {
            int devicesToRemove = (int) Math.ceil((double) (curNode.curConsumption - curNode.powerLimit) / k);
            curNode.numDevice = Math.max(0, curNode.numDevice - devicesToRemove);
            deviceCount += devicesToRemove;

            curNode.curConsumption = (curNode.numDevice * k) + childConsumptionSum;
        }

        return deviceCount;
    }


    public int solution(int k, int[] limits, int[][] sockets) {
        int answer = 0;
        int N = sockets.length;

        Node[] nodeStore = new Node[N];

        for(int i=0; i<N; i++){
            nodeStore[i] = new Node(i, 0, limits[i], 0);
        }

        for(int i=0; i<N; i++) {
            int numDevice = 0;
            for(int j=0; j<5; j++) {
                //Assign childs to the child array
                if(sockets[i][j] == -1) nodeStore[i].numDevice++;
                else if(sockets[i][j]!=0) nodeStore[i].childNode.add(nodeStore[sockets[i][j]-1]);
            }
        }

        calculateCurConsumption(nodeStore[0], k);

        answer = numDeviceRemoved(nodeStore[0], k);

        return answer;
    }
}