
// Approach: We do Level order traversal (BFS) Iterative solution and make connections as required while traversing
 // the tree.
 // Time: O(n)
 // Space: O(1)
    

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


public class PopulatingNextRightPointersEachNode {
    public Node connect(Node root) {
        if (root == null) return root;
        Node res = root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                Node node = q.poll();
                if (i != size-1) node.next = q.peek();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return res;
    }
}
