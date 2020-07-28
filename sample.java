// Time Complexity : O(n)
// Space Complexity :O(n) as n/2 leaf nodes worst case in queue
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


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
        //edge case
        if(root==null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root); // push root to queue
        while(!q.isEmpty()) // till queue is not empty
        {
            int size = q.size(); // to process level by level
            for(int i=0;i<size;i++) // iterate over the size of queue 
            {
                Node curr = q.poll(); // get the topmost node from queue
                if(i!=size-1) // if it is not the last node
                {
                    Node next = q.peek(); // get the next node (at top of queue)
                    curr.next = next;  // establish a connect between curr and next
                }
                if(curr.left!=null) 
                    q.add(curr.left); //add left and right child of the node to queue
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        
        return root;
        
    }
}

// Time Complexity : O(n)
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


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
        //edge case
        if(root == null)
            return root;
        
        Node level = root; // to traverse level wise
        
        while(level.left!=null) // till we have not reached the last level
        {
            Node curr = level; // to traverse all element in the level
            
            while(curr!=null) // till we dont reach null
            {
            curr.left.next = curr.right; // set the left child next to right child
            if(curr.next!=null) // if we have another node in the level
            {
                curr.right.next = curr.next.left; // set the next of right child to currents next's left
            }
            curr = curr.next;  // move curr
            }
           level = level.left; // move the level
        }
        
        return root;
    }
}


// Time Complexity : O(n)
// Space Complexity :O(h) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first; // to point to first element of breach
    TreeNode last; // to point to last element of breach
    TreeNode prev; // to keep track of prev element
    boolean flag; // to check if it is first breach or second
    public void recoverTree(TreeNode root) {
        //edge
        if(root == null)
            return;
        
        inorder(root);
        int temp = first.val; // swapping values of first and last
        first.val = last.val;
        last.val = temp;
    }
    private void inorder(TreeNode root)
    {
        //base
        if(root == null)
            return;
        
        //logic
        inorder(root.left);
        
        if(prev!=null && prev.val>= root.val) // if prev is there and prev value is greater than root which is invalid in inorder
        {
            if(!flag) // check if flag is false i.e first breach
            {
                flag = true; // make flag true
                first = prev; // set first as prev and last as root
                last = root;
            }
            else  // second breach
                last = root; // move last pointer to the root value
        }
        
         prev = root; // setting prev as root each time
        inorder(root.right);
    }
}