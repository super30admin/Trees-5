// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Node level = root;
        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                //connecting left to right
                curr.left.next = curr.right;
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}