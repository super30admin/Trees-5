// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Check with inorder traversal and swap when violation occurs
 */


public class recoveringBST {
    TreeNode prev;
    TreeNode slow; TreeNode fast;
    boolean flag; 
    public void recoverTree(TreeNode root) {
        
        if(root == null) return;
        inOrder(root);
        int temp = fast.val;
        fast.val = slow.val;
        slow.val = temp;
    }
    
    private void inOrder(TreeNode root){
        
        if(root == null)
            return;
        
        inOrder(root.left);

        if(prev!=null && prev.val >=root.val){  
            
            if(!flag){  
                flag = true;
                slow = prev;
                fast = root;
            }else 
                fast = root;
        }
        prev = root;
        
        inOrder(root.right);
    }
}
