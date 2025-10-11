//TC: O(n), SC: O(1)
//Approach: Traverse the tree level order but without a queue, think of a level as the level, current starts with the level until null
//keep setting the next pointers using the current node and move to the next level when current == null -> level.left
public class PopulateNextRightPointer {

    public Node connect(Node root) {
        if (root == null) return null;

        Node level = root;

        while (level.left != null) {
            Node current = level;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) current.right.next = current.next.left;

                current = current.next;
            }

            level = level.left;
        }

        return root;
    }
}
