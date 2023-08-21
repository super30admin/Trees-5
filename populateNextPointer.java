// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Using preorder traversal, we can connect the left and right nodes of the current node.
 * 2. If the curr node's next exists, then we can connect the right node of the current node to the left node of the next node.
 * 3. Recursively call the helper function on the left and right nodes of the current node.
 * 4. Return the root node.
 */


class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        helper(root);
        return root;
    }

    private void helper(Node curr){
        if(curr.left == null)
            return;
        
        curr.left.next = curr.right;
        if(curr.next != null){
            curr.right.next = curr.next.left;
        }

        helper(curr.left);
        helper(curr.right);
    }
}