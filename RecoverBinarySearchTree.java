// Time Complexity : O(n) -> number of nodes
// Space Complexity : O(h) -> height of the tree
// Did this code successfully run on Leetcode : Yes

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
 }

public class RecoverBinarySearchTree {
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        helper(root);
        swap(first,second);
    }

    public void swap(TreeNode first, TreeNode second)
    {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root)
    {
        if(root == null) return;
        helper(root.left);
        if(prev != null && prev.val > root.val)
        {
            if(first == null)
            {
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}
