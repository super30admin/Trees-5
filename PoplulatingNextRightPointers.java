//time complexity: O(N)
//space complexity: O(N)

import java.util.*;

class Solution {
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
    public Node connect(Node root) {        
        if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                Node temp = q.poll();
                if( i== size -1)
                {
                    temp.next = null;
                }
                else
                {
                    temp.next = q.peek();
                }
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            
        }
        return root;
    }
}