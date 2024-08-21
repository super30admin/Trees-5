/**
 * Time Complexity: O(n), where n is the number of nodes in the binary tree.
 * Each node is visited exactly once, so the time complexity is linear in terms of the number of nodes.

 * Space Complexity: O(h), where h is the height of the binary tree.
 * The space complexity is due to the recursive call stack. In the worst case, the recursion depth can go up to the height of the tree, which is O(h).
 */

class Solution {
    public Node connect(Node root) {
        // If the root is null, there's nothing to connect, so return null
        if (root == null) return null;
        
        // Perform a depth-first search (DFS) to connect nodes
        dfs(root);
        
        // Return the modified root with all nodes connected
        return root;
    }

    private void dfs(Node root) {
        // If the current node is a leaf node (no left child), return
        if (root.left == null) return; 

        // Connect the left child to the right child of the same parent
        root.left.next = root.right;

        // If the current node has a next node, connect the right child
        // of the current node to the left child of the next node
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        // Recursively connect the left subtree
        dfs(root.left);
        
        // Recursively connect the right subtree
        dfs(root.right);
    }
}
