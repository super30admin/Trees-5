//Time complexity: O(n) where n is the number of nodes in the tree
//Space complexity: O(1) since we are not using any extra space except for the pointers

// Intuition: The algorithm uses a level order traversal to connect the next pointers of each node in a perfect binary tree. 
// In populated next level, we iterate through each node at the current level and set the next pointer of the left child to the right child, 
// and if the current node has a next pointer, we set the right child's next pointer to the left child of the next node.

public class NextRightPointer {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node leftNode = root;

        while (leftNode.left != null) {
            populateNextLevel(leftNode);
            leftNode = leftNode.left;
        }
        return root;
    }

    public void populateNextLevel(Node startNode) {
        Node iter = startNode;
        while (iter != null) {
            iter.left.next = iter.right;

            if (iter.next != null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
