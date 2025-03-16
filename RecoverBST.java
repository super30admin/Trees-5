//Recursive solution:-
//Time complexity:- O(n)
//Space complexity:- O(h) : Recursive stack

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        
        this.prev = null;
        //we will perform inorder similar to validating BST
        helper(root);

        //we will swap the first value and the second value
        //If we find 2 incorrect value [prev1, root1] and [prev2, root2] then we swap prev1 with root2
        //special case:- where both incorrect are parent and child, in that case there is not second hence replace prev1 and root1
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public void helper(TreeNode root) {

        //base
        if(root == null)
            return;

        //logic
        helper(root.left);

        if(prev != null && prev.val >= root.val) {

            //case 1:- if we find the first incorrect value store both prev and root value
            if(first == null) {
                first = prev;
                second = root;
            }
            else {
                //if we find the second incorrect value then just store the second value            
                second = root;
            }
        }
        
        prev = root;
        helper(root.right);
    }
}