// Time Complexity : O(n), going through all nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Traverse each level starting from the root (perfect binary tree).
//   - Connect the left and right children of each node.
//   - Also connect the right child to the next node's left child if the current node is not the last in its level.
//   - Move to the leftmost node of the next level.


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

public class PopulatingNextRightPointer {
    // public Node connect(Node root) {
    //     if(root == null) return null;

    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);

    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         for(int i = 0; i < size; i++) {
    //             Node curr = q.poll();
    //             if(i != size - 1) { //no need to add next for last element in level
    //                 curr.next = q.peek();
    //             }

    //             if(curr.left != null) { //left children is not null, if left exists then right exists as well
    //                 q.add(curr.left);
    //                 q.add(curr.right);
    //             }
    //         }
    //     }

    //     return root;
    // }

    public Node connect(Node root) {
        if(root == null)    return null;
        Node level = root;

        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;

                if(curr.next != null) { //not last node in level
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }
            level = level.left;
        }

        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointer obj = new PopulatingNextRightPointer();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        obj.connect(root);

        System.out.println("Level order next pointers:");
        Node level = root;
        while (level != null) {
            Node curr = level;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
            level = level.left;
        }
    }
}
