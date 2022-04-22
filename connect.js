// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {Node} root
 * @return {Node}
 */

//DFS Solution with 1 pointer
var dfs =function(root) {
    if(root.left === null) return;
    root.left.next = root.right;
    if(root.next !== null) root.right.next = root.next.left;
    dfs(root.left);
    dfs(root.right);
}

var connect = function(root) {
    if(root === null) return null;
    dfs(root);
    return root;
};