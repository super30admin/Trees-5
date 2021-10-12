
// Time Complexity : O(h)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach
1) In this problem, we are given a perfect binary tree.
2) we need to attach all prev.next = Node if the node is on left side and node.next  = null if the node is present on the right hand side.
3) we use a level order traversal to perform the operations.
4) we use 2 pointers prev and curr to use them on the node and then attach the right pointer to every node to its next possible value.
5) Thus when we first poll we get the elements at root level and level size is 1;
6) we just add the left and right nodes of the prev to queue, This will help us to increase the queue size by 2^n (number of nodes present on every level).
7) the inner for loop will help in polling the next node and keeping it as curr node and then attaching the prev.next = curr and then shifting the prev=curr node to keep it pointing to curr node
*/


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

class PopulatingNextRightPointers {

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
    }


    public Node connect(Node root) {
        
        Queue<Node> queue = new LinkedList();
        
        if(root==null)
        {
            return null;
        }
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Node prev = queue.poll();
            
            
            // given binary tree is perfect
            if(prev.left!=null)
            {
                queue.add(prev.left);
                queue.add(prev.right);
            }
            for(int i=1;i<size;i++)
            {
                Node curr = queue.poll();
                if(curr.left!=null)
                {
                    queue.add(curr.left);
                    queue.add(curr.right);
                    
                }
                prev.next = curr;
                prev= curr;
                
            }
            
            
        }
        
        return root;
    }
}