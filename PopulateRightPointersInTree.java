import java.util.LinkedList;
import java.util.Queue;

//Leetcode - 99
//TimeComplexity - O(N)
//Space Complexity - O(1)
public class PopulateRightPointersInTree {
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

    //O(N), O(1)
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
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

    //O(N), O(H)
    /*public Node connect(Node root) {
        if(root == null) return root;
        dfs(root);
        return root;
    }
    private void dfs(Node root) {
        //base
        if(root.left == null) return;
        //logic
        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }*/
    //O(N), O(N) BFS
    /*public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                if(i != size -1) {
                    curr.next = q.peek();
                }
                if(curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }*/

    /* DFS O(N), O(H)
    public Node connect(Node root) {
        if(root == null) return root;
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right) {
        //base
        if(left == null) return;
        //logic
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
     */
}
