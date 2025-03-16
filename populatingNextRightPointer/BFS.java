package populatingNextRightPointer;

//tc: O(n), where n is the no of nodes in the tree
//sc: O(1)

class BFS {
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Node level  = root;

        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;

                // means it is not a last node
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr=curr.next;
            }
            level = level.left;

        }



        return root;
    }
}
