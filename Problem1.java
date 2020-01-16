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

/**
LeetCode Submitted : YES
Space Complexity : O(Number of leaf nodes)
Time Complexity : O(Number of total nodes)

The idea is to use BFS level order traversal and on each level check size of queue and map next pointer so each nodes at each level are connected till we reach end of node.


**/
class Solution {
    public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        Queue<Node> q = new LinkedList<>();
        
        //Adding root to null
        q.add(root);
        
        //Add Next Pointer to Root Node (Which will always be single)
        //root.next = null;
        
        while(!q.isEmpty()){
            Node currNode = q.poll();
            currNode.next = null;
            int currSize = q.size();
            if(currNode.left != null && currNode.right != null)
            {
                q.add(currNode.left);
                q.add(currNode.right);
            }
            for(int i = 0; i<currSize; i++){
                Node t = q.poll();
                if(t.left != null && t.right != null)
                {
                    q.add(t.left);
                    q.add(t.right);
                }
                currNode.next = t;
                currNode = currNode.next;
            }
        }
        return root;
    }
}
