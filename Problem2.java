// https://leetcode.com/problems/recover-binary-search-tree/
// Time complexity : O(N)
// Space complexity : (H)

class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
    public void inorder(TreeNode root){
        if(root == null)
            return ;
        
        inorder(root.left);
        if(prev.val > root.val){
            if(first == null)
                first = prev;
            second = root;
        }
        
        prev = root;
        inorder(root.right);
    }
}

