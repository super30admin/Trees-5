//Time Complexity : O(n)
//Space Complexity : O(1). Ignoring the recursive stack space
class Solution {
    TreeNode prev,first,last;
    boolean isFirst;
    public void recoverTree(TreeNode root) {
         if(root==null){
             return;
         }
        isFirst = false;
        inorder(root);
        //after figuringing the positions of mismatch, perform swapping
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        //visit left subtree
        inorder(root.left);
        if(prev!=null && prev.val >= root.val){
            //mark the position of mismatch
            if(isFirst == false){
                first = prev;
                last = root;
                isFirst = true;
            }
        
            else{
                last = root;
            }
        }
        prev = root;
        //visit right subtree
        inorder(root.right);
    }
}