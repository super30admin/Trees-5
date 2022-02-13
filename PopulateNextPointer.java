// Time Complexity : O(n)
// Space Complexity : log (n) as its perfect binary tree
// Did this code successfully run on Leetcode : Yes

public class PopulateNextPointer {

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

    public Node connect(Node root) {
        //Optimized BFS

        if(root == null) return null;
        Node level = root;
        while(level.left != null){
            Node curr = level; //iterating each level
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){ //check if level is complete
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }

}
