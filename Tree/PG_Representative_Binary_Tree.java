class Node {
    int val;
    Node left;
    Node right;
    
    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public String convertToBinary(long number) {
        if(number == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            long remainder = number % 2;
            sb.append(remainder);
            number /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    public int getHeight(int numNodes) {
        int height = 1;
        while((1 << height) - 1 < numNodes) {
            height++;
        }
        return height;
    }
    
    public String padToFullTree(String binary, int n) {
        StringBuilder sb = new StringBuilder();
        int height = getHeight(n);
        int fullLength = (1 << height) -1;
        
        for(int i = 0; i < fullLength - binary.length(); i++) {
            sb.append("0");
        }
        sb.append(binary);
        
        return sb.toString();
    }
    
    public Node buildTree(String binary, int start, int end) {
        if(start > end) return null; 
        
        int mid = (start + end) / 2;
        Node curNode = new Node(binary.charAt(mid) - '0');
        
        curNode.left = buildTree(binary, start, mid - 1);
        curNode.right = buildTree(binary, mid + 1, end);
        
        return curNode;
    }
    
    public boolean determineHelp(Node curNode, boolean isParentZero) {
        if(curNode == null) return true;
        if(curNode.val == 1 && isParentZero) return false;

        boolean nextParentZero = (curNode.val == 0);

        return determineHelp(curNode.left, nextParentZero) && determineHelp(curNode.right, nextParentZero);
    }

    public boolean determineTree(Node root) {
        return determineHelp(root, false); // root는 부모가 없으므로 false
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long curNum = numbers[i];
            
            String binary = convertToBinary(curNum);
            String fullBinary = padToFullTree(binary, binary.length());
            
            Node root = buildTree(fullBinary, 0, fullBinary.length() - 1);
            boolean result = determineTree(root);
            
            answer[i] = result ? 1 : 0;
        }
        
        return answer;
    }
}