// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity if O(n) where n is the number of tree nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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

        if(root == null){return root;}

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();

        Node cur;
        Node prev = null;

        // BFS
        while(!q.isEmpty()){

            cur = q.poll();
            size--;

            if(cur.left != null){
                q.offer(cur.left);
                q.offer(cur.right);
            }

            // point prev's next node to current
            if(prev == null){
                prev = cur;
            }
            else{
                prev.next = cur;
                prev = cur;
            }

            // For each level
            if(size == 0){
                size = q.size();
                prev = null;
            }
        }

        return root;

    }
}