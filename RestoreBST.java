// Time Complexity : 0(n)
// Space Complexity : 0(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RestoreBST {
    TreeNode first, last, prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        //do inorder traversal and find two breaches
        inorder(root);
        //swap values of first and last
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
    }

    //inorder function
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            //1st breach
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }
            //2nd breach
            else{
                last = root;
                flag = false;
            }
        }
        //mark root as prev and proceed ahead with inorder
        prev = root;
        if(first == null || last==null || flag){
            inorder(root.right);
        }
    }
}