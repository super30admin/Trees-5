// Time Complexity :O(n) n-number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
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
        if(root==null) return null;
        Node level=root;
        while(level.left!=null)
        { 
            Node curr=level;
            while(curr!=null)
            {
               curr.left.next=curr.right;
               if(curr.next!=null)
               {
                   curr.right.next=curr.next.left;
               }
               curr=curr.next;
            }
            level=level.left;
        }
        return root;
    }
}

//BFS Approach using queue
//TC:O(n) // as we are touching all nodes
//SC:O(n) //Queue space max of n/2 leaf nodes so n
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Node temp=null;
        while(!q.isEmpty())
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                temp=q.poll(); // Keep popping each level node and point it to next element in queue
                temp.next=q.peek();
                
                if(temp.left!=null) // since its a complete tree checking only left of a root is enough to make sure there is right side too
                {
                    q.add(temp.left);
                    q.add(temp.right);
                }
                
            }
            temp.next=null; // since we are adding children at every for loop after each level the last node wont be null so manually pointing it to null
        }
        return root;
    }
}