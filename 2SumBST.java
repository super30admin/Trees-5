// Time Complexity : O(mlogn) m-> no. of nodes in 1st tree, n -> no. of nodes in 2nd tree
// Space Complexity : O(height of tree on which we are iterating)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Since we are given two binary search trees, we can leverage the fact that complementarty of
// the number on first tree will either exist on left of second tree or on the right. We'll proceed in a 
// similar way as we search for an element in a binary search.
// We can iterate over one tree and do binary search on the other recursively.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null) return false;
        TreeNode curr1 = root1, curr2 = root2;
        while(root2 != null)  {
                int num1 = root1.val;
                int num2 = target-root1.val;
                if(num2 == root2.val) return true;
                if(num2 < root2.val) {
                    root2 = root2.left;
                }
                else root2 = root2.right;
        }
        boolean res1 = twoSumBSTs(root1.left, curr2, target); 
        boolean res2 = twoSumBSTs(root1.right, curr2, target); 
        return res1|| res2;
    }
}
