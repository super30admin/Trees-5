/**
 * @param {TreeNode} root
 * @return {number[]}
 * 94. Binary Tree Inorder Traversal
Intuition:
We recursively traverse the tree in inorder (left → root → right).
For each node, we first visit its left subtree, then record it's value, and finally visit it's right subtree.
T.C: O(N)
S.C: O(1)
 */
var inorderTraversal = function (root) {
    let result = [];
    const inorderTraversalHelper = (root) => {
        if (!root) return;
        inorderTraversalHelper(root.left);
        result.push(root.val);
        inorderTraversalHelper(root.right);
    }
    inorderTraversalHelper(root);
    return result;
};