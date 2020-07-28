//Time Complexity: O(n)

class Solution {
    TreeNode first; TreeNode last;
    TreeNode prev; boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;      
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);        
        if(prev != null && root.val < prev.val){
            if(!flag){
                flag = true;
                first = prev; last = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}