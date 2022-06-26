/**
 * PopulatingNextPointer
 */
public class PopulatingNextPointer {
    class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        Node curr = root;
        while(level.left != null){
            curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}