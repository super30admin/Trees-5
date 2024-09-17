/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time complexity:O(n)
// Space complexity: O(1)

class Solution {

    TreeNode firstNode, secondNode, previousNode;

    public void recoverTree(TreeNode root) {

        firstNode = null;
        secondNode = null;
        previousNode = new TreeNode(Integer.MIN_VALUE);

        if(root == null) return;

        inOrder(root);
        swap(firstNode, secondNode);

    }

    private void inOrder(TreeNode root){
        if(root == null) return;


        inOrder(root.left);
        if(firstNode == null && previousNode.val > root.val){
            firstNode = previousNode;
        }

         if(firstNode != null && previousNode.val > root.val){
            secondNode = root;
        }
        previousNode = root;
        inOrder(root.right);

    }

    private void swap(TreeNode a, TreeNode b){
        int val = a.val;
        a.val = b.val;
        b.val = val;
    }
}