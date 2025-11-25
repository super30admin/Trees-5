/*
 Algorithm: Inorder traversal to detect two swapped nodes in a BST

 Approach:
 - Use an inorder DFS to traverse the tree in sorted order.
 - Keep track of the previous visited node. When we find a pair where previous.val >= current.val,
   we record the first and second nodes that are out of order. There are two cases:
     1) The swapped nodes are adjacent in inorder — we detect one inversion and record both nodes.
     2) The swapped nodes are not adjacent — we detect two inversions and record first from the first inversion and second from the second inversion.
 - After traversal, swap the values of the two recorded nodes to restore the BST.

 Time Complexity: O(n) where n is number of nodes (single inorder traversal).
 Space Complexity: O(h) recursion stack where h is tree height (not counting input tree), O(1) extra space otherwise.

 LeetCode: https://leetcode.com/problems/recover-binary-search-tree/ (99)
*/

public class RecoverBinarySearchTree {

    private TreeNode previous;
    private TreeNode first;
    private TreeNode second;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode root) {
        //base
        if (root == null) return;

        //logic
        dfs(root.left);
        if (previous != null && !(previous.val < root.val)) {
            if (first == null) {
                first = previous;
                second = root;
            } else {
                second = root;
            }
        }
        previous = root;
        dfs(root.right);
    }
}
