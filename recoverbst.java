//Time complexity:O(n)
//Space complexity:O(h)
class Solution {
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        helper(root);
        //swap
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
    }
    private void helper(TreeNode root){
        //base
        if(root==null){
            return;
        }
        //logic
        helper(root.left);
        if(prev!=null && prev.val>=root.val){
            if(!flag){
                first=prev;
                last=root;
                flag=true;
            }
            else{
                last=root;
            }
        }
        prev=root;
        helper(root.right);
        
    }
}