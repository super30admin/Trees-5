// Time Complexity : O(n) - Average case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Morris Inorder Traversal - 
Iterate while current node is not null - 
    Case 1 - If current.left == null, process the current node and set current = current.right
    Case 2 - Set predecessor node = current.left
             While predecessor node.right exists and doesn't point to current move predecessor = predecessor.right
             Case 2.1 - If predecessor.right equals current, set predecessor.right = null. Process current and move current = current.right
             Case 2.2 - Else, set predecessor.right = current and move current to current.left.
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
public class Solution
{
    List<int> result;
    public IList<int> InorderTraversal(TreeNode root)
    {
        result = new();
        MorrisTraversal(root);
        return result;
    }

    public void MorrisTraversal(TreeNode current)
    {
        while (current != null)
        {
            if (current.left == null)
            {
                result.Add(current.val);
                current = current.right;
            }

            else
            {
                TreeNode pred = current.left;

                while (pred.right != null && pred.right != current)
                {
                    pred = pred.right;
                }

                if (pred.right == current)
                {
                    pred.right = null;
                    result.Add(current.val);
                    current = current.right;
                }

                else
                {
                    pred.right = current;
                    current = current.left;
                }
            }
        }
    }
}