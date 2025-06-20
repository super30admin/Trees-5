/**
 * Morris Inorder Traversal of a Binary Tree
 * * This algorithm allows us to traverse a binary tree in inorder without using recursion or a stack.
 * * It modifies the tree structure temporarily to create links between nodes, allowing us to traverse the tree in a linear fashion.
 * * After the traversal, the original tree structure is restored.
 * 
 * * Algorithm:
 * - We start with the current node as the root.
 * - If the current node has no left child, we visit the current node and move to its right child.
 * - If the current node has a left child, we find its inorder predecessor (the rightmost node in the left subtree).
 * - We make the current node the right child of its inorder predecessor.
 * - If the right child of the predecessor is null, we set it to the current node and move to the left child.
 * - If the right child of the predecessor is already set to the current node, we revert the changes and visit the current node, then move to its right child.
 * 
 * * * Time Complexity: O(N) where N is the number of nodes in the tree.
 * * * Space Complexity: O(1) since we are not using any additional data structures.
 */
public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        
        while(curr != null)  {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // Move to the right child
            } else {
                // Find the inorder predecessor of current node
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                
                // Make current as the right child of its inorder predecessor
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left; // Move to the left child
                } else {
                    // Revert the changes made to restore the original tree structure
                    predecessor.right = null;
                    res.add(curr.val);
                    curr = curr.right; // Move to the right child
                }
            }
        }
        return res;
    }
}
