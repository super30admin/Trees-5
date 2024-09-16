/*
Population next right pointers at each node
approach:
1. traverse in pre-order, connect left to right
2. level order traversal
3. optimized level order traversal
time: 1. O(n) 2. O(n) 3. O(n) 4. O(n)
space: 1. O(h) 2. O(n) 3. O(1) 4. O(h)
 */
public class Problem1 {
    /*
    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node root) {
        if(root==null) return;
        if(root.left!=null)
            root.left.next = root.right;
        if(root.next!=null && root.right!=null) {
            root.right.next = root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }

     */

    /*
    Optimized Level order traversal
        public Node connect(Node root) {
        Node level = root;

        while(level!=null) {
            Node cur = level;
            while(cur!=null) {
            if(cur.left!=null)
            cur.left.next = cur.right;
            if(cur.right!=null && cur.next!=null) {
                cur.right.next = cur.next.left;
            }
            cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }
     */
    /*
    Approach same as checking symmetry in a tree
        public Node connect(Node root) {
        if(root==null) return null;
        helper(root.left, root.right);

        return root;
    }

    private void helper(Node left, Node right) {
        if(left==null) return;
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);

    }
     */
}
