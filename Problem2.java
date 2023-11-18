//Time Complexity :O(n)
//Space Complexity:O(h)

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(prev!=null && root.val <= prev.val){
            if(first==null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
