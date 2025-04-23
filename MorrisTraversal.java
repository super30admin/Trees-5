//Time Complexity : O(n) where n is the no of nodes.
// Space Complexity : O(1) constant space.
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
 
class MorrisTraversal {
    public List<Integer> morris(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null)
        {
            if(curr.left == null)
            {
                result.add(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;
                
                if(prev.right == null)
                {
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }
}
