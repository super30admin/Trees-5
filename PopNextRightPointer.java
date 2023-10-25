//TC will be O(n)
//TC will be O(n)


import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node.
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


class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                Node curr = q.poll();
                if(i < size - 1){
                    curr.next = q.peek();
                }
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Create the sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the connect method
        Node connectedRoot = solution.connect(root);

        // Print the tree structure (next pointers)
        printTree(connectedRoot);
    }

    // Helper method to print the tree structure (next pointers)
    public static void printTree(Node root) {
        while (root != null) {
            Node current = root;
            while (current != null) {
                System.out.print(current.val);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
            root = root.left;
        }
    }


}