// Time Complexity : O(n)
// Space Complexity : O(log n)

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
        if(root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = q.poll();
            if(prev.left != null){
                q.add(prev.left);
                q.add(prev.right);
            }
            for(int i = 1; i < size; i++){
                Node cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                    q.add(cur.right);
                }
                prev.next = cur;
                prev = cur;
            }
        }
        return root;
    }
}