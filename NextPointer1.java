/* 116. Populating Next Right Pointers in Each Node - MEDIUM
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Approach: Traverse in level order fashion.
At every level, save a pointer to the leftmost node to later move to the next level.
At every level, add next pointers for nodes on the next level.

TC: O(V+E)
SC: O(1)
*/
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class NextPointer1 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Node curr = root;
        Node levelNode = root;
        
        while (levelNode != null) {
            curr = levelNode;
            // traverse all elements on one level
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;   
                }         

                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            // goto next level
            levelNode = levelNode.left;
        }        
        return root;
    }
}
