// Time Complexity : O(n) --> where n is number of nodes in the tree
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode (116): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        // edge case
        if (root == null) return null;
        
        Node level = root;
        while (level.left != null) { // iterate on depth of tree
            Node curr = level;
            while (curr != null) { // iterate of level
                curr.left.next = curr.right;
                if (curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
            
        return root;
    }
}