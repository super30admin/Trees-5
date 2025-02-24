/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Utilize the fact that there is a next pointer available to traverse on that level, use no extra space
 */

public class PopulatingNextRightPointersInEachNode {
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
    
    public Node connect(Node root) {
        if (root == null)
            return root;

        Node left = root;
        while (left.left != null) {
            Node curr = left;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }

        return root;
    }
    
    public static void main(String[] args) {
        // Your code here
    }
}