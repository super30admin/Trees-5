// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(log n), log n -> Size of recursion stack
class Solution {
    TreeNode prev;
    boolean flag;
    TreeNode first, last;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        //root
        if(prev != null && prev.val > root.val) {
            //first breach
            if(!flag) {
                first = prev;
                last = root;
                flag = true;
            }
            //second breach
            else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}