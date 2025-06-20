/**
 * * LeetCode 99: Recover Binary Search Tree
 * * * Approach:
 * * - We can use an in-order traversal to find the two nodes that are swapped.
 * * - During the traversal, we keep track of the previous node and compare it with the current node.
 * * - If we find a node that is less than the previous node, we have found a violation of the BST property.
 * * - We can then identify the first and second nodes that need to be swapped.
 * * - After the traversal, we swap the values of the first and second nodes to recover the BST.
 * *
 * * Time Complexity: O(N) where N is the number of nodes in the tree.
 * * Space Complexity: O(H) where H is the height of the tree (due to recursion stack).
 * * - In the worst case, the height of the tree can be N (if the tree is skewed).
 * * - In a balanced tree, the height will be log(N).
 * * - We are not using any additional data structures, so the space complexity is O(1) for the iterative approach.
 * * - However, for the recursive approach, the space complexity is O(H) due to the recursion stack.    
 * 
 */
public class RecoverTree {
    TreeNode prev, first, second;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        prev = null;
        inorder(root);
        // Swapping Values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
