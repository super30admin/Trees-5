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
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* we take 3 variables first, second and prev. WE check 2 breaches where the root value is less than the prev value. 
 * we do all this while running a inorder recursion function. later swapping the first and second variables.
 */ 
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root)
    {
        if(root == null)
            return;

        inorder(root.left);

        if(prev != null && root.val <= prev.val)
        {
            if(first == null)
            {
                //1st breach
                first = root;
                second = prev;
            }
            else{
                first = root;
            }

        }
        prev = root;
        inorder(root.right);
    }
}




//iterative


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
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* Iterative approach using stack
 */ 
class Solution {
    
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty())
        {
            while(root != null)
            {
                st.push(root);
                root = root.left;
            }
            //check breach
            root = st.pop();
        
            if(prev != null && prev.val >= root.val)
            {
                if(first == null)
                {
                    first = root;
                    second = prev;
                }
                else{
                    first = root;
                }
            }
            prev = root;
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}