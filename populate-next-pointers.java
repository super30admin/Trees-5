// Time Complexity : O(n) because each node is visited once
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use already established next pointers to traverse each level without extra space.
// For every node, we connect its left child to its right child and connect across subtrees using the next pointer.
// After finishing a level, we move to the leftmost node of the next level and repeat the process.

class Solution {
    public Node connect(Node root) {

        if(root == null) return null;

        Node level = root;

        // process one level at a time
        while(level.left != null) {

            Node curr = level;

            while(curr != null) {

                // connect children of same parent
                curr.left.next = curr.right;

                // connect across parents
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            level = level.left;
        }

        return root;
    }
}