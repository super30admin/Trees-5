/*
// Definition for a Node.
 */
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

/*        EXAMPLE
             1
         2       3
       4   5   6   7
*/

// Time Complexity:  O(n)
// Space Complexity: O(n)
// where n is number of nodes in tree

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        connect(root, null);
        return root;
    }
    private void connect(Node node, Node next) {

        if(node == null)
            return;
        // in first iteration, below connections would happen
        node.next = next;                                                       // 1 -> null
        connect(node.left, node.right);                                         // 2 -> 3
        connect(node.right, node.next == null ? null : node.next.left);         // 3 -> null
    }
}

// ****************************** ANOTHER APPROACH ******************************
//// Time Complexity:  O(n)
//// Space Complexity: O(1)
//// where n is number of nodes in tree
//
//class PopulatingNextRightPointers {
//    public Node connect(Node root) {
//
//        if(root == null)
//            return root;
//
//        Node leftmost = root;
//
//        while(leftmost.left != null) {
//
//            Node prev = leftmost;
//            Node cur = prev.left;
//            // in second iteration, below connections would happen
//            while(cur != null) {
//                cur.next = prev.right;                                          // 4 -> 5
//                cur = cur.next;                                                 // cur = 5
//
//                cur.next = prev.next == null ? null : prev.next.left;           // 5 -> 6
//                prev = prev.next;                                               // prev = 3
//                cur = cur.next;                                                 // cur = 6
//            }
//
//            leftmost = leftmost.left;
//
//        }
//
//        return root;
//
//    }
//}