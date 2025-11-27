// Time Complexity : O(n).
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Approach : We perform inorder traversal by pointing the same node's children first and then pointing the current node's right to the next node's left.

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        helper(root);
        return root;
    }

    private void helper(Node curr){
        if(curr.left == null) return;

        curr.left.next = curr.right; //pointing the same node children
        if(curr.next != null){
            curr.right.next = curr.next.left; //pointing the right to curr node to next node's left
        }

        helper(curr.left);
        helper(curr.right);
    }
}