// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
    if (!root) return;
    
    const stack = [];
    let first = null,
        second = null,
        prev = null;
    
    while (stack.length > 0 || root != null) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (prev != null && root.val < prev.val) {
            second = root;
            if (first == null) first = prev;
            else break;
        }
        prev = root;
        root = root.right;
    }

    [first.val, second.val] = [second.val, first.val];
};
