/*
 Algorithm: Recursive connection using pair-wise helper calls

 Approach:
 - This implementation assumes a perfect binary tree.
 - For each pair of nodes (left, right) the helper sets left.next = right, then recursively
   connects the internal pairs to propagate next pointers across subtrees:
     helper(left.left, left.right)
     helper(left.right, right.left)
     helper(right.left, right.right)
 - This directly links nodes across subtree boundaries without using extra data structures.

 Time Complexity: O(n) where n is number of nodes (each node visited constant times).
 Space Complexity: O(h) recursion stack where h is tree height (for a perfect tree h = log n).

 LeetCode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ (116)
*/

public class PopulatingNextRightPointersInEachNode4 {

    public Node connect(Node root) {
        if (root == null)
            return root;
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node left, Node right){
        if(left == null) return;

        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}
