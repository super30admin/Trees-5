// Time Complexity : O(n).
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Approach : We perform inorder traversal to find out where the breach happened as it gives te values that are interchanged. There is a possibility of
// either one or two breaches. We maintain two pointers while doing inorder traversal and capture the nodes that are smaller than the previous one. Finally
// we swap them to get the valid BST.

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        helper(root);
        //swap the values of breaches
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(prev != null && prev.val >= root.val){ //breach
            if(first == null){ //first breach
                first = prev;
                second = root;
            }else{ //second breach
                second = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}