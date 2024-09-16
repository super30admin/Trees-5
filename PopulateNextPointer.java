// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(n)

class Solution {
    public Node connect (Node root) {

        if(root == null) return null;
        helper(root.left, root.right);
        return root;
    }

    private void helper (Node left, Node right) {
        //base case
        if(left == null) return;

        //logic
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}