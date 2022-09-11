
//Time O(n)
//Space O(logn)


class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean isSwapped = false;
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val=temp;
        
    }
    
    private void inorder(TreeNode root){
        //base
        if(root==null)
            return;
        //logic
        inorder(root.left);
        TreeNode curr = root;
        if(prev!=null && prev.val>=curr.val){
            if(!isSwapped){
                isSwapped = true;
                first = prev;
                second = curr;
            }
            else{
                second = curr;
            }
        }
        prev=curr;
        inorder(root.right);
    
    }
}
