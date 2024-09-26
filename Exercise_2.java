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
    TreeNode t1, t2, prev;
    public void recoverTree(TreeNode root) {
        t1 = t2 = prev = null;

        inorder(root);

        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    private void inorder(TreeNode curr){
        if(curr != null){
            inorder(curr.left);

            if(prev!=null && curr.val < prev.val){
                if(t1 == null){
                    t1 = prev;
                }
                t2 = curr;
            }

            prev = curr;

            inorder(curr.right);
        }
    }
}

//tc = O(n)
//sc = O(n)
