//TC: O(n)--> traverse through all the nodes
//SC: O(highet of tree)
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
    public void recoverTree(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;
        while(!stack.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                stack.add(root);
                root = root.left;       //Traversing all the way to left child and doing and inorder traversal if prev val is bigger than present value then we found one wrongly placed node.
            }
            
            TreeNode top = stack.pop();
            if(prev!=null && prev.val>top.val)  //Similarly we travers all the tree and find other wrongly placed node. Upon finding 2 wrongly placed nodes. Swap
            {
               y = top;
                if(x!=null)
                    break;
                x=prev;                
            }
            
            prev = top;
            root = top.right;
        }
        swap(x,y);
    }   
    
    void swap(TreeNode x, TreeNode y)
    {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}