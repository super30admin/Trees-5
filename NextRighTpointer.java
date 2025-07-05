// Time complexity - O(n)
// space complexity - O(1)
// solved on leetcode - yes
// faced any issues - NO
// Using iterative solution without any extra space to connect between the nodes
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;

            while (head != null) {
                // Connect left -> right
                head.left.next = head.right;

                // Connect right -> next left (if exists)
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }
}
