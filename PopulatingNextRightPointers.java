package s30.trees.trees5;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointers {

    //DFS
    //Tc: O(n);
    //SC: O(logn);
    public Node connect(Node root) {

        connect(null, root);

        return root;

    }

    private void connect(Node par, Node node){

        if(node == null) return;

        if(par != null) {

            if(par.left == node){
                node.next = par.right;
            }else if(par.next != null){
                node.next = par.next.left;
            }

        }

        connect(node, node.left);
        connect(node, node.right);
    }

    //BFS
    //TC: O(n);
    //SC: O(n/2);
    public Node connectBFS(Node root) {
        Queue<Node> level = new LinkedList();

        if(root == null) return root;

        level.add(root);

        while(!level.isEmpty()){

            Node prev = null;

            int size = level.size();

            while(size >0){

                Node node = level.poll();

                if(node.left != null) level.add(node.left);
                if(node.right !=null) level.add(node.right);

                if(prev != null) {
                    prev.next = node;
                }
                prev = node;
                size--;
            }

            prev.next = null;
        }

        return root;

    }

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
    public static void main(String[] args) {

    }
}
