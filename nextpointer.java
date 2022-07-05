// Time Complexity :O(n) where n is no of nodes
// Space Complexity :recursive stack will have O(h) space where h is height of tree 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        helper(root.left, root.right);
        return root;
    }

    public void helper(Node leftRoot, Node rightRoot) {
        // edge case
        if (leftRoot == null)
            return;
        // logic
        leftRoot.next = rightRoot;
        // lefts left will point to left's right
        helper(leftRoot.left, leftRoot.right);
        // lefts right will point to right's left
        helper(leftRoot.right, rightRoot.left);
        // right's left will point to right's right
        helper(rightRoot.left, rightRoot.right);
    }
}

// -------------------USING ONE NODE--------------------
// Time Complexity :O(n) where n is no of nodes
// Space Complexity :recursive stack will have O(h) space where h is height of
// tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// here we are using only one node as parameter of recursive method and using
// next pointers
// which are already there, we are making next pointers

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        helper(root);
        return root;
    }

    public void helper(Node root) {
        // edge case
        if (root.left == null)
            return;
        // logic
        root.left.next = root.right;
        helper(root.left);
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        helper(root.right);

    }
}