/**
 * Time Complexity: O(n), where n is the number of nodes in the binary tree.
 * Each node is visited once and each edge is traversed at most twice (once when linking and once when unlinking), so the time complexity is linear in terms of the number of nodes.

 * Space Complexity: O(1), excluding the space used by the result list.
 * The space complexity is constant because the algorithm uses a few extra variables for traversal and does not use recursion or any additional data structures.
 * The space used by the result list, which stores the traversal values, is O(n), but this is not included in the space complexity of the algorithm itself.
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // Create a list to store the inorder traversal result.
        ArrayList<Integer> result = new ArrayList<>();
        
        // If the tree is empty, return the empty result list.
        if (root == null)
            return result;
        
        // Initialize the current node to the root.
        TreeNode current = root;
        
        // Traverse the tree until there are no more nodes to visit.
        while (current != null) {
            // If the current node has no left child, visit it and move to the right child.
            if (current.left == null) {
                result.add(current.val); // Add the value of the current node to the result list.
                current = current.right; // Move to the right child.
            } 
            // If the current node has a left child, find its inorder predecessor.
            else {
                // The predecessor is the rightmost node in the left subtree.
                TreeNode pred = current.left;
                while (pred.right != null && pred.right != current) {
                    pred = pred.right;
                }
                
                // If the predecessor's right child is null, make the current node its right child.
                if (pred.right == null) {
                    pred.right = current; // Establish a temporary link to the current node.
                    current = current.left; // Move to the left child to continue traversal.
                } 
                // If the predecessor's right child is already pointing to the current node, it means we've completed the left subtree.
                else {
                    pred.right = null; // Remove the temporary link.
                    result.add(current.val); // Visit the current node and add its value to the result list.
                    current = current.right; // Move to the right child.
                }
            }
        }
        
        // Return the final inorder traversal result.
        return result;
    }
}
