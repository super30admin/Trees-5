// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//99. Recover Binary Search Tree
//https://leetcode.com/problems/recover-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    // ITERATION
    // time: O(n)
    // space: O(h) - Stack Space

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();

        if (root == null)
            return;

        while (root != null || !st.isEmpty()) {

            while (root != null) {
                st.add(root); // System.out.print("in while loop " + root.val + " ");
                root = root.left;
            }
            root = st.pop(); // if(prev!=null){System.out.print("prev " + prev.val+" ");}
                             // System.out.println("root " + root.val);

            if (prev != null && prev.val > root.val) {
                if (first == null) {
                    first = prev; // System.out.println("first" + first.val);
                    second = root; // System.out.println("second" + second.val);
                } else {
                    second = root; // System.out.println("seo=cond second " + second.val);
                }
            }
            prev = root;

            root = root.right;
        }

        swap(first, second);
    }

    private void swap(TreeNode first, TreeNode second) {

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

/*
class Solution {
    // RECURSION
    // time: O(n)
    // space: O(h)

    // TreeNode curr = null;
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {

        if (root == null)
            return;

        helper(root);

        swap(first, second);
    }

    private void helper(TreeNode curr) {
        // base
        if (curr == null)
            return;

        // logic
        helper(curr.left);

        if (prev != null && prev.val > curr.val) {
            if (first == null) {
                first = prev;
                second = curr;
            } else {
                second = curr;
            }
        }
        prev = curr;

        helper(curr.right);
    }

    private void swap(TreeNode first, TreeNode second){
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}*/
