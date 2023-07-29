public class Node {

    int val;
    Node left;
    Node right;

    Node next;

    Node() {}

    Node(int x) {

        val = x;
    }

    Node(int x, Node l,  Node r, Node n) {

        val = x;

        left = l;

        right = r;

        next =  n;
    }
}


