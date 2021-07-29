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
    //Time O(N)
    //Space O(H)
    TreeNode first , second , prev;
    boolean  flag = false;
    public void recoverTree(TreeNode root) {
        if(root == null)
        {
            return;
        }
        DFS(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }
    private void DFS(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        DFS(root.left);
        if(prev != null && prev.val >= root.val)
        {
            if(!flag)
            {
                first = prev;
                second = root;
                flag = true;
            }
            else
            {
                second = root; 
            }
        }
        prev = root;
        DFS(root.right);
    }
}