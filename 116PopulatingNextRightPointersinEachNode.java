/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Optimized Level order Traversal

class Solution {
    public Node connect(Node root) {

        if(root == null) return root;

        // Here level keeps track of what is the next level and curr is the node which traverses all the nodes in a level and 
        // maintains links
        Node level = root, curr = null;

        // When we are at the last level and it's left is null we don't need to continue the loop bcoz it is a perfect 
        // binary tree. If childrens are not present and the first itself then there won't be any children at that level
        while(level.left != null)
        {
            curr = level;

            while(curr != null)
            {
                curr.left.next = curr.right;

                // When curr is at extreme right node then we can't do this because curr.next is null and we apply left
                // to this null.
                if(curr.next != null)
                {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            level = level.left;
        }

        return root;
    }
}
