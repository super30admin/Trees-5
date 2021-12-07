// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        prev=null;
        flag=false;
        helper(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(prev!=null && prev.val>root.val){
            if(flag==false){
                first=prev;
                second=root;
                flag=true;

            }else{
                second=root;
            }
        }
        prev=root;
        helper(root.right);
    }
}