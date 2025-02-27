/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first = null, second = null, prev= null;
    Stack<TreeNode> s = new Stack<>();
    public void recoverTree(TreeNode root) {
        recover(root);
        int temp=second.val;
        second.val = first.val;
        first.val = temp;
    }
    private void recover(TreeNode root) {
        while ( root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root=root.left;
            }
            root = s.pop();
            if (prev != null && prev.val > root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev= root;
            if (root != null) {
                root = root.right;
            }

        }
    }
}



/*
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
*/
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return root;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                Node curr = q.poll();
                if( i == size-1) {
                    curr.next = null;
                } else {
                    curr.next=q.peek();
                }
                if (curr.left != null ) {
                    q.add(curr.left);
                }
                if (curr.right != null ) {
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}
