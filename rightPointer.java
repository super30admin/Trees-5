/*
Time Complexity: O(n) - We visit each node once.
Space Complexity: O(1) - We use constant extra space.
*/

class Solution {
    public Node connect(Node root) {
        //base
        if(root == null) {
            return root;
        }

        //logic
        Node left, curr;
        left = root;

        while(left.left != null) {
            curr = left;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }
        return root;
    }
}