//time - O(n)
//space - O(h)
class Solution {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);

        if(prev!=null && prev.val >= root.val){
            if(first==null){
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}
