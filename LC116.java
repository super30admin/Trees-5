import java.util.Queue;
import java.util.LinkedList;

// Iterative Solution - BFS - Using Extra Space
// TC: O(N)
// SC: O(N)
public class LC116 {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                Node polled = q.poll();
                // Connect Pointer
                if(size!=1) polled.next = q.peek();
                // Add Childs to Queue
                if(polled.left!=null) q.add(polled.left);
                if(polled.right!=null) q.add(polled.right);
                size--;
            }
        }
        return root;
    }
}


// Iterative Solution - BFS - No Extra Space
// TC: O(N)
// SC: O(1)
class LC116_1 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node left = root;
        while (left.left != null) {
            Node curr = left;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }
        return root;
    }
}

// Recursive Solution - DFS
// TC: O(N)
// SC: O(H) - H is the height of the tree
class LC116_2 {
    private void traverse(Node left, Node right) {
        if (left == null || right == null)
            return;
        left.next = right;
        traverse(left.left, left.right);
        traverse(left.right, right.left);
        traverse(right.left, right.right);
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        traverse(root.left, root.right);
        return root;
    }
}