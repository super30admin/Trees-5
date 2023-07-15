import java.util.LinkedList;
import java.util.Queue;

//Definition for a Node.
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


// Time Complexity : O(n) where n is the number of nodes as we need to vist each node at least once
// Space Complexity : O(1) assuming implicit stack space does not count as extra space for this problem.
// Did this code successfully run on Leetcode :yes
public class PopulateNextRightPointer {
    public Node connect(Node root) {

        if(root == null) return root;
        preorder(root, null, false);
        return root;
    }

    private void preorder(Node node, Node parent, boolean isLeftChild){

        if(node == null) return;
        if(parent == null){
            preorder(node.left, node, true);
            preorder(node.right, node, false);
        }else{
            if(isLeftChild){
                node.next = parent.right;
            }else{
                if(parent.next != null){
                    node.next = parent.next.left;
                }
            }

            preorder(node.left, node, true);
            preorder(node.right, node, false);
        }
    }

    private void preorder2(Node node){
        if(node.left == null) return;

        node.left.next = node.right;
        if(node.next != null){
            node.right.next = node.next.left;
        }

        preorder2(node.left);
        preorder2(node.right);
    }
}

// Time Complexity : O(n) where n is the number of nodes as we need to vist each node at least once
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
 class PopulateNextRightPointerWithExtraSpace {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                Node current = q.poll();
                if (i != l - 1) {
                    current.next = q.peek();
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return root;
    }
}

class PopulateNextRightPointerIterative{

    //iterative, no extra space
    public Node connect(Node root) {

        if(root == null) return root;
        Node level = root;
        while(level.left != null){
            Node current = level;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            level = level.left;
        }

        return root;
    }
}
