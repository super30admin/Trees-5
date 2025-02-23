//TC => O(n)
//SC => O(H)

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
    TreeNode prev, first, second;
    int cout = 0;
    public void RecoverTree(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Inorder(root);
        var temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void Inorder(TreeNode root)
    {
        if (root == null || count == 2)
        {
            return;
        }
        Inorder(root.left);
        if (prev != null && prev.val > root.val)
        {
            if (first == null)
            {
                first = prev;
            }
            second = root;
            count++;
        }
        prev = root;
        Inorder(root.right);
    }
}