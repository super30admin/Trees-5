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
 1,3,4,2
 preorder = root -> left -> right.
 1 2 3 4
 2 3
 
 
 
 a = 3
 b = 2
 
 TC - O(N)
 SC - O(H)
 
 
 */
class Solution {
    public void recoverTree(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        TreeNode lastpopped = null;
        TreeNode a = null;
        TreeNode b = null;
        
        while(true)
        {
            if (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            else 
            {
                if (stack.isEmpty())
                {
                    break;
                }
                
                TreeNode popped = stack.pop();
                
                if (lastpopped != null && popped.val < lastpopped.val)
                {
                    // need to swap
                    
                    if (a == null)
                    {
                        a = lastpopped;
                    }
                    
                    b = popped;
                }
              
                lastpopped = popped;
                current = popped.right;
            }
        }
        
        
        // swap the values of a & b
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
