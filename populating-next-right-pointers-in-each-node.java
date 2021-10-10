// Time Complexity : O(n)
// Space Complexity :O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


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
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            
            int size = q.size();
             Node curr1 = null;
             Node curr2 = null;
            
             curr1 = q.poll();
            if(curr1 != null && curr1.left != null)
                q.add(curr1.left);
                if(curr1 != null && curr1.right != null)
                q.add(curr1.right);
            
            for(int i =0; i < size-1; i++)
            {
              
                curr2 = q.poll();
                    if(curr2 != null && curr2.left != null)
                   q.add(curr2.left);
                    if(curr2 != null && curr2.right != null)
                    q.add(curr2.right);
                
                
                 if(curr2 != null)
                curr1.next = curr2;
                else 
                     if(curr1 != null)
                    curr1.next = null;
                curr1 = curr2;
                
              
                
            }
        }
        
        return root;
    }
}