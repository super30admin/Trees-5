package Trees-5;
// Time Complexity : O(n) n is number of nodes 
// Space Complexity : O(n) n number of nodes in last node
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class RightNextPointer {
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
        Node node;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size-1;i++)
            {
               node = q.poll();
                if(!q.isEmpty())
                {
                    node.next = q.peek();
                }
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            node = q.poll();
             if(node.left!=null)
             {
                    q.add(node.left);
              }
              if(node.right!=null)
                {
                    q.add(node.right);
                }
            node.next = null;
        }
        return root;
    }
}    
}
