// Time Complexity : O(N)
// Space Complexity : O(N)
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
var connect = function(root) {
    if (!root) return root;
    
    const q = [root];
    while (q.length > 0) {
        // console.log(q);
        let level = q.length;
        for (let i = 0; i < level; i++) {
            let curr = q.shift();
            if (i < level - 1) curr.next = q[0];
            else curr.next = null;
            
            if (curr.left) q.push(curr.left, curr.right);
        }
    } 
    return root;
};
