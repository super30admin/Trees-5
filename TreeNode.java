/*
 Simple binary tree node class used across examples.

 Fields:
 - int val: node value
 - TreeNode left: left child
 - TreeNode right: right child

 Notes:
 - This is a lightweight data holder used by traversal and tree-manipulation algorithms in this repository.
 - No algorithmic complexity applies to the class itself; complexity depends on algorithms that operate on TreeNode trees.

 Common LeetCode usage: many tree problems use a similar TreeNode definition (e.g. https://leetcode.com/problems/binary-tree-inorder-traversal/ (94)).
*/

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
