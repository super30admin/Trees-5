//time complexity- O(n) where n is the number of tree nodes
//space complexity- O(1)
public class PopulatingNextRightPointers {
    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int val) {
            this.val = val;
            left = right = next = null;
        }
    }
     static Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        Node curr;

        while(level != null) {
            curr = level;
            while(curr != null) {
                if(curr.left == null) return root;
                curr.left.next = curr.right;
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }

        return root;
    }
    static  void  printnext(Node node) {
        int i = 0;
        while(node != null) {
            Node temp = node;
            System.out.print("Level " + i + ": ");
            while(temp != null) {
                System.out.print(" "+ temp.val);
                temp = temp.next;
            }
            System.out.println();
            node = node.left;
            i++;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        /*
                    1
                 /    \
               2        3
            /   \      /  \
           4    5     6    7

         */
        connect(root);
        System.out.println("Next pointer Connections");
        printnext(root);

    }
}
