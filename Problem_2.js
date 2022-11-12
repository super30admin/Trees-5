// ## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

// Time Complexity : O(n); n is the total nodes
// Space Complexity : O(h); h is the tree height

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

let prev, first, second;
var inorder = function (root) {
    // Base
    if (root === null)
        return;
    // Logic
    inorder(root.left);
    if (prev !== null && prev.val >= root.val) {
        if (first === null) {
            first = prev;
        }
        second = root;
    }
    prev = root;
    inorder(root.right);
}
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function (root) {
    if (root === null)
        return;

    // first and second are the nodes which needs to be swapped
    prev = null;
    first = null;
    second = null;

    // Recursive
    // inorder(root);

    // Iterative
    let stack = [];

    // Inorder traversal. Keep track of previous to capture inconsistency
    while (root !== null || stack.length > 0) {
        // Travel leftmost
        while (root !== null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        // If prev was larger than curr, set the first and second
        if (prev !== null && prev.val >= root.val) {
            // If first id null, it is set to prev
            if (first === null) {
                first = prev;
            }
            // Second is the root
            second = root;
        }
        prev = root;
        root = root.right;
    }
    // Swap the 2 nodes
    let temp = first.val;
    first.val = second.val;
    second.val = temp;
};