
// Time Complexity :  O(N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode :Yes

class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        first = null;
        second = null;
        prev = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        
        if(first==null && ( prev==null || prev.val >=root.val )){
            first = prev;
        }
        if(first!=null && prev.val >= root.val){
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}