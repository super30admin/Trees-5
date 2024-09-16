
// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach
1) Here in this problem we are tracking the nodes and counting for the the mismatches occuring. 
2) Instead of going in brute force approach, we can use 2 pointers
-> First -> which will take care of the first mismatch
-> Prev-> which will take care of the second mismatch
3) we would have a mismatch variable to detect the mismatches. thus with every recursive call if we have already set the first mismatch then we make mismatch as true and only count for the last mismatch in the nodes
4) In the next recursive call we will just track the last pointer if the misnatch is already true. 
5) we keep the pointers in global scope, otherwise we the first and last pointers will get updated in every recursive call

*/


public class RecoverBinarySearchTree {
    
    public class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }


    TreeNode first, last, prev;
    boolean mismatch;
    public void recoverTree(TreeNode root) {
        
        // perform the inorder traversal and then swap the first and last.
        
        if(root==null)
            return;
        
        inorder(root);
        
        
        // performing the swapping operation
        int temp= first.val;
        first.val = last.val;
        last.val = temp;
        
        
        
        
    }
    
    public void inorder(TreeNode root)
    {
        // base case
        if(root==null)
        {
            return;
        }
        
        
        // logic
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            
            // if mismtach has never occurred before
            if(!mismatch)
            {
                first = prev;
                last = root;
                mismatch = true;
                
                
            }
            // mismtach has already occurred once
            else
            {
                last = root;
                return;
                
                
            }
            
            
        }
        prev =root;
        inorder(root.right);
        
        
        
        
        
        
        
    }
    
}
