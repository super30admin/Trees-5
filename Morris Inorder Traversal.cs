/*
  Time complexity: O(n) Amortized
  Space complexity: O(1)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<int> InorderTraversal(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        List<int> result = new();

        while(curr!=null)
        {
            if(curr.left==null)
            {
                result.Add(curr.val);
                curr = curr.right;
            }
            else
            {
                prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right=null;
                    result.Add(curr.val);
                    curr = curr.right;

                }
            }
        }
        return result;
    }
}
