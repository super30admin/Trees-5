// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        inorder(root);

        int temp = first.val;

        first.val = second.val;

        second.val = temp;
    }

    private void inorder(TreeNode node){

        if(node == null){
            return;
        }

        inorder(node.left);

        if(first == null && (prev == null || prev.val >= node.val)){
            first = prev;
        }

        if(first != null && prev.val >= node.val){
            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}
