// Time Complexity : O(n)
// Space Complexity : O(h) h -> height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Dificult to think the optimal approach

// Your code here along with comments explaining your approach

class Solution {
    
    TreeNode first; //first node swapped
    TreeNode second; //second node swapped
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        inorder(root); //inorder should be in ascending order in BST
        int temp = first.val; //swap the values
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root) {
        //base case
        if(root == null) 
            return;
        inorder(root.left);
        //breach in ascending order
        if(prev != null && prev.val >= root.val){
            if(first == null && second == null){
                //1st breach in ascending order
                first = prev;
                second = root;
            } else {
                //2nd breach in ascending order (only need to update second reference
                second = root;
            }
        }
        prev = root; // to check if it is in ascending order or not
        inorder(root.right);
    }
}
