// Time Complexity : O(n) n = no. of nodes
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

//inorder recursive
//prev, root used while traversing like in validate BST problem

//case 1 : the two nodes are in separate subtrees - two breaches in inorder traversal sorting
//case 2 : the two nodes are either neighbors or parent-baby - only one breach

class Solution {

    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;

    public void recoverTree(TreeNode root) {

        inorder(root);

        //swap value of first and second
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void inorder(TreeNode root)
    {
        //base
        if(root == null)
            return;

        //logic
        inorder(root.left);

        if(prev != null && prev.val > root.val) //breach happened
        {
            if(!flag) // flag = false means this is first breach
            {
                first = prev;
                second = root;
                flag = true;
            }
            else //this is second breach, overwrite second
                second = root;
        }

        prev = root;
        inorder(root.right);
    }
}
