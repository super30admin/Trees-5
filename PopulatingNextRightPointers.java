// TC: O(n)
// SC : O(n)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        Queue<Node> bfsQueue = new LinkedList<Node>();

        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node curr = bfsQueue.poll();
                if(curr.left != null){
                    bfsQueue.add(curr.left);
                }
                if(curr.right != null){
                    bfsQueue.add(curr.right);
                }
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }
        return root;
    }
}