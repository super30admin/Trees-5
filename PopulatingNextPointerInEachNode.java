//Time Complexity O(n)
//Space Complexity O(h)
//Leetcode tested

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointerInEachNode {
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
    }
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node dummy = new Node(root.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node current = queue.poll();
                dummy.next = current;
                dummy = dummy.next;
                //System.out.println(current);
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            dummy  = new Node(-1);
            //break;
        }
        return root;
    }
}
