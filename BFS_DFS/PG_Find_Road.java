//https://school.programmers.co.kr/learn/courses/30/lessons/42892

import java.util.*;

class Solution {
    public static Node makeTree(List<Node> tempStore) {
        if (tempStore.isEmpty())
            return null;

        Node root = tempStore.get(0);
        List<Node> leftStore = new ArrayList<>();
        List<Node> rightStore = new ArrayList<>();

        for (int i = 1; i < tempStore.size(); i++) {
            Node curNode = tempStore.get(i);
            if (root.x > curNode.x) {
                leftStore.add(curNode);
            } else {
                rightStore.add(curNode);
            }
        }

        root.left = makeTree(leftStore);
        root.right = makeTree(rightStore);

        return root;
    }

    public static void preorder(Node root, List<Node> resultStore) {
        if (root == null)
            return;
        resultStore.add(root);
        preorder(root.left, resultStore);
        preorder(root.right, resultStore);
    }

    public static void postorder(Node root, List<Node> resultStore) {
        if (root == null)
            return;
        postorder(root.left, resultStore);
        postorder(root.right, resultStore);
        resultStore.add(root);
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        List<Node> tempStore = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            tempStore.add(new Node(nodeinfo[i][1], nodeinfo[i][0], i + 1));
        }
        tempStore.sort((a, b) -> b.y - a.y);
        Node root = makeTree(tempStore);

        List<Node> preorderStore = new ArrayList<>();
        List<Node> postorderStore = new ArrayList<>();

        preorder(root, preorderStore);
        postorder(root, postorderStore);

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorderStore.get(i).index;
            answer[1][i] = postorderStore.get(i).index;
        }

        return answer;
    }

    public static void main(String strs[]) {
        int[][] nodeInfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
                { 2, 2 } };
        for (int[] curArr : solution(nodeInfo)) {
            for (int i : curArr)
                System.out.print(i + ",");
            System.out.println("");
        }
    }
}

class Node {
    int x;
    int y;
    int index;
    Node left;
    Node right;

    public Node(int y, int x, int index) {
        this.y = y;
        this.x = x;
        this.index = index;
        this.left = null;
        this.right = null;
    }
}