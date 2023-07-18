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
//Sol: In the inorder traversal, store the values if prev >= root
//Time Complexity = O(N);
//Space Complexity = O(1);

class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inOrder(root);
        //swap
        if(first != null){
            // System.out.println(first.val+ " " + second.val);
            // TreeNode temp= null;
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        // return root;
    }

    private void inOrder(TreeNode root){
        if(root == null)return;
        inOrder(root.left);
        if(prev != null && prev.val >= root.val){
            // System.out.println(prev.val+ " " + root.val);

            if(first == null){
                first = prev;
                second = root;
            }else second = root;

        }
        prev = root;
        inOrder(root.right);
    }
}