/**
 * Time Complexity: O(n), where n is the number of nodes in the binary tree.
 * Each node is visited exactly once during the in-order traversal, so the time complexity is linear in terms of the number of nodes.

 * Space Complexity: O(h), where h is the height of the binary tree.
 * The space complexity is due to the recursive call stack. In the worst case, the recursion depth can go up to the height of the tree, which is O(h).
 * This is for the stack space used during the DFS traversal. The space used by additional variables (first, second, prev) is constant.
 */


class Solution {
    TreeNode first;  // The first node that is out of order
    TreeNode second; // The second node that is out of order
    TreeNode prev;   // The previous node in the in-order traversal

    public void recoverTree(TreeNode root) {
        // If the tree is empty, there's nothing to recover
        if (root == null)
            return;

        // Perform in-order DFS to identify the two nodes that are swapped
        dfs(root);

        // Swap the values of the first and second nodes to correct the BST
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode root) {
        // Base case: if the current node is null, return
        if (root == null)
            return;

        // Recursively traverse the left subtree (in-order traversal)
        dfs(root.left);

        // Check if the previous node's value is greater than the current node's value
        if (prev != null && prev.val > root.val) {
            // If this is the first violation, mark the previous node as 'first' and the current node as 'second'
            if (first == null) {
                first = prev;
                second = root;
            } 
            // If this is the second violation, just mark the current node as 'second'
            else {
                second = root;
            }
        }

        // Update 'prev' to the current node before moving to the right subtree
        prev = root;

        // Recursively traverse the right subtree (in-order traversal)
        dfs(root.right);
    }
}
