// Time - O(N)
// Space - O(1)


class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root; // initialize level to root
        while(level.left != null) { // iterate next level until level.left is not null
            Node curr = level;
            while(curr != null) {  // current is not null

                curr.left.next = curr.right;
                if(curr.next != null) { // current.next should not be null
                    curr.right.next = curr.next.left;  // connect right node to current's next left
                }

                curr = curr.next; // move the current pointer

            }
            level = level.left; // move the level down to the leftmost part

        }

        return root;

    }
}