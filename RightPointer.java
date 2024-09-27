/*
Iterative: 
TC: O(N) - number of nodes in a tree
SC: O(1)

1. Do level order traversal of the tree to its left nodes. 
2. Connect left node to right, and left tree to right.

Recursion:

TC: O(N) - we visit all nodes in tree.
SC: O(H) - the stack can contain Height at max.


*/

class Node{
    int val;
    Node left, right, next;
    public Node(int val){
        this.val = val;
    }
}

public class RightPointer{

    public Node connectIterative(Node root){
        //base
        if(root == null) return null;
        Node cur = root;
        while(cur.left != null){
            Node p = cur;
            while(p != null){
                p.left.next = p.right;
                if(p.next != null){
                    p.right.next =p.next.left;
                }
                p = p.next;
            }
            cur = cur.left;
        }
        return root;
    }

    public Node connectRecursive(Node root){
        if(root == null) return null;
        helper(root);
        return root;
    }

    private void helper(Node node){
        if(node == null) return;

        if(node.left != null){
            node.left.next = node.right;
            if(node.next != null){
                node.right.next = node.next.left;
            }
        }
        helper(node.left);
        helper(node.right);

    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        RightPointer rp = new RightPointer();
        rp.connectIterative(root);
    }
}