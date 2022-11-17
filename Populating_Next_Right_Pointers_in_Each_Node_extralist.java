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
// SC : O(n)
// Method -1 Using extra list


class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        
        List<Node> list = new ArrayList<>();
        
        q.add(root);
        Node prev = null;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size - 1; i++)
                list.get(i).next = list.get(i+1);
            list.clear();
            
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                    list.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                    list.add(curr.right);
                }
            }
        }
       return root; 
    }
}
