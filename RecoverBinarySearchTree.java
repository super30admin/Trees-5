// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Inorder traversal. Similar solution to validate BST
// Using 2 variable to identify what are the elements to swap.
// Fist element found and last element out of the order
class Solution {
    // *********** Inorder traversal ***************** 
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;
        
        while(!stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode popped = stack.pop();
            if(prev != null && prev.val > popped.val){
                x = popped;
                if( y == null){
                    y = prev;
                }
            }
            prev = popped;
            root = popped.right;
        }
        swap(x, y); 
    }
    
    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}