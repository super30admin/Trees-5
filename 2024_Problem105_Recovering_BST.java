//99. Recovery Binary Search Tree - https://leetcode.com/problems/recover-binary-search-tree/description/
//Time Complexity: O(n)
//Space Complexity; O(h) ~ recursive stack

class Solution {
    TreeNode first, second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);
        swap(first, second);
    }

    private void helper(TreeNode root){
        //base case
        if(root == null) return;

        //process in inorder: left -> root -> right
        helper(root.left);
        if(prev != null && prev.val >= root.val){ //found a breach
            if(first == null){
                first = prev;
                second = root;
            } else{
                second = root;
            }
        }
        prev = root;
        helper(root.right);
    }

    //swap first and secord to fix the BST
    private void swap(TreeNode first, TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}