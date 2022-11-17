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

// TC : O(n)
// SC : O(1)
// Method -1 BFS


class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
                
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            Node curr = q.poll();
            if(curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            for(int i = 1; i < size; i++) {
                Node next = q.poll();
                curr.next = next;
                if(next.left != null) {
                    q.add(next.left);
                    q.add(next.right);
                }
                curr = next;
            }
        }
       return root; 
    }
}
