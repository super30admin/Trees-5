//Time Complexity : O(n) where n is the no of nodes.
// Space Complexity : O(h) h is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
//Definition for a binary tree node.
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
 

class Solution1 {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    private void dfs(TreeNode root)
    {
        if(root == null) return;

        dfs(root.left);
        
        if(prev != null && prev.val > root.val)
        {
            if(first == null && second == null)
                first = prev;
            second = root;
        }
        prev = root;

        dfs(root.right);
    }
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
class Solution2 {
    
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode curr = root;

        Stack<TreeNode> stk = new Stack<>();
        
        while(curr != null || !stk.isEmpty())
        {
            while(curr != null)
            {
                stk.push(curr);
                curr = curr.left;
            }

            curr = stk.pop();

            if(prev != null && prev.val > curr.val)
            {
                if(first == null && second == null)
                    first = prev;
                second = curr;
            }
            prev = curr;

            curr = curr.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
}