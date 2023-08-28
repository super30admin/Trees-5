//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    private TreeNode prev = null , first = null , sec = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(first , sec);
        return;
    }
    private void swap (TreeNode a , TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    private void helper (TreeNode root){
        if(root == null)
        return;

        helper(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null)
                first = prev;
            sec = root;
        }

        prev = root;

        helper(root.right);
    }
}
