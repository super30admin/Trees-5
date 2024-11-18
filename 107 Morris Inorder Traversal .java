// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
    public void traverse(TreeNode root)
    {
        if(root == null )
        {
            return;
        }

        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }

}