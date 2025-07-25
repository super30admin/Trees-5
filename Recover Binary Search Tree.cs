/*
  Time complexity: O(n)
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
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void RecoverTree(TreeNode root) {
        helper(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root)
    {
        Stack<TreeNode> stack = new();
        while(stack.Count>0 || root!=null)
        {
            while(root!=null)
            {
                stack.Push(root);
                root = root.left;
            }
            root = stack.Pop();

            if(prev!=null && prev.val>=root.val)
            {
                if(first==null)
                {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root = root.right;
        }
    }
}
