package Trees5;
// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes
import Trees1.TreeNode;

public class RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
