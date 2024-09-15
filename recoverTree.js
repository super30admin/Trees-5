// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
let first = null;
let second = null;
let prev = null;

//tree inorder traversal
//comparing prev value and root value
var inorder = function(root) {
    //base case
    if(root === null) return;
    //action
    inorder(root.left);
    //if prev val is greater than root val -> found one of the swaped value
    if(prev !== null && prev.val >= root.val) {
        if(first === null && second === null) {
            first = prev;
            second = root;
        } else {
            second = root;
        }
    }
    prev = root;
    inorder(root.right);
}

var recoverTree = function(root) {
    inorder(root);

    //swaping first and second value to recover the tree 
    let temp = first.val;
    first.val = second.val;
    second.val = temp;
    first = null;
    second = null;
    prev = null;
};