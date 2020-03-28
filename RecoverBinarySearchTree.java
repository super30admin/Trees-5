// Time Complexity : O(n) n--> no. of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 1: Iterative approach
// Main intuition is that a BST when traversed in inorder fashion produces result in sorted manner.
// When two elements are swapped, then there will be 2 cases which needs to be addressed.
// case 1: when the elements lie on opposite sides of the root.
// case 2: when the elements lie on the same side of the root(left ubtree or right subtree)
// To address both the situations, two pointers can be maintained for identifying the positions wherein the sorted order is breached. Once the pointers are identified, the values can simply be swapped.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public void recoverTree(TreeNode root) {
        //edge case
        if(root == null) return;
        TreeNode firstMismatch = null, secondMismatch = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev.val > curr.val) {
                if(firstMismatch == null) {
                    firstMismatch = prev;
                }
                secondMismatch = curr;// takes care of case1 as well as case2
            }
            prev = curr;
            curr = curr.right;
        }
        swap(firstMismatch, secondMismatch);
    }
    
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
*/

// Approach 2: Recursive approach

class Solution {
    public void recoverTree(TreeNode root) {
        //edge case
        if(root == null) return;
        wrapper w = new wrapper();
        inorder(root, w);
        swap(w.firstMismatch, w.secondMismatch);
    }
    
    private void inorder(TreeNode root, wrapper w) {
        if(root == null) return;
        inorder(root.left, w);
        // main logic
        if(w.prev.val > root.val) {
            if(w.firstMismatch == null) {
                w.firstMismatch = w.prev;
            }
            w.secondMismatch = root;// takes care of case1 as well as case2
        }
        w.prev = root;
        
        inorder(root.right, w);
        
    }
    
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    
    // wrapper class to avoid global variables
    class wrapper {
        TreeNode firstMismatch;
        TreeNode secondMismatch;
        TreeNode prev;
        
        private wrapper() {
            firstMismatch = null;
            secondMismatch = null;
            prev = new TreeNode(Integer.MIN_VALUE);
        }
    }
}



