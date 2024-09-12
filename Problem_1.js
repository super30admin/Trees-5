// ## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

// BFS
// Time Complexity : O(n)
// Space Complexity : O(h)

// Constant space/pointers
// Time Complexity : O(n)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
var connect = function (root) {
    if (root === null)
        return root;

    // BFS
    // let queue = []
    // queue.push(root);
    // let node = null;
    // let prevNode = null;

    // while(queue.length>0){
    //     let size = queue.length;
    //     for(let i=0; i<size; i++){
    //         node = queue.shift();
    //         if(node.left !== null && node.right !== null){
    //             queue.push(node.left);
    //             queue.push(node.right);
    //         }
    //         if(i>0){
    //             prevNode.next = node;
    //         }
    //         prevNode = node;
    //     }
    //     node.next = null;
    // }

    // SC: O(1)
    // keep a level for each height
    let level = root;
    let curr = null;
    // While level has nodes
    while (level.left !== null) {
        curr = level;
        // Till curr is not null, set the left child next to right child
        while (curr !== null) {
            curr.left.next = curr.right;
            // If there are nodes on the right, curs left = nexts left
            if (curr.next !== null) {
                curr.right.next = curr.next.left;
            }
            curr = curr.next;
        }
        level = level.left;
    }

    return root;
};