// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain global variables first, second and previous all of TreeNode type. I call the Inorder function on the root node. While visiting
the root node, I check if previous exists and if so, the value of previous node is greater than or equal to current node. If so, I 
set first = previous and second = root if first has not been found yet. If not I simply set second = root. If previous doesn't exist or
the condition is not fulfilled, I simply set previous = root and iterate on the right subtree recursively. After performing inorder
traversal, I swap values of first and second to recover the binary search tree.
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
    private TreeNode first;
    private TreeNode second;
    private TreeNode previous;
    public void RecoverTree(TreeNode root) {
        Inorder(root);
        
        // Swapping values of first and second
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void Inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        Inorder(root.left);

        // Logic
        if(previous != null && previous.val >= root.val)
        {
            if(first == null)
            {
                first = previous;
                second = root;
            }

            else
            {
                second = root;
            }
        }
        previous = root;

        Inorder(root.right);
    }
}