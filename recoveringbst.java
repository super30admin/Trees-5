//TC: O(n) — single in-order traversal visits each node once.
//SC: O(h) — recursion stack (h = tree height); no extra data structures.

//Do an in-order traversal keeping prev; whenever prev.val ≥ curr.val, record the first violation’s first = prev and set/update second = curr.
//This catches both non-adjacent swaps (two violations) and adjacent swaps (one violation).
//After traversal, swap first.val and second.val to restore BST order.

class Solution {
    TreeNode prev;
    TreeNode first, second;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);

        if(prev != null && prev.val >= root.val) {
            if(first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }

        prev = root;

        helper(root.right);
    }
}