// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Inorder traverse the BST and note where the 2 breaches happens (prev>root)
// If only 1 breach happens -> parent - child swap
// 2 breaches -> left and right subtree swaps

class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    Boolean flag=false;

    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void helper(TreeNode root){

        if(root == null) return;

        helper(root.left);

        if(prev != null && prev.val  >= root.val){
            if(first == null){
                first = prev;
                second = root;
            } else{
                flag = true;
                second = root;
            }
        }
        prev = root;
        
        if(!flag) //flag to avoid further traversal
            helper(root.right);
    }
}