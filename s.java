/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        // base
        if (node == null) {
            return;
        }
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }

}

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode prev = null;
    TreeNode firstswap = null;
    TreeNode secondswap = null;

    public void recoverTree(TreeNode root) {

        inorder(root);
        int temp = firstswap.val;
        firstswap.val = secondswap.val;
        secondswap.val = temp;

    }

    private void inorder(TreeNode currNode) {
        if (currNode == null) {
            return;
        }
        inorder(currNode.left);
        if (prev != null && prev.val >= currNode.val) {
            if (firstswap == null) {
                firstswap = prev;
            }
            secondswap = currNode;
        }
        prev = currNode;
        inorder(currNode.right);
    }
}
//
/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node next;
 * 
 * public Node() {}
 * 
 * public Node(int _val) {
 * val = _val;
 * }
 * 
 * public Node(int _val, Node _left, Node _right, Node _next) {
 * val = _val;
 * left = _left;
 * right = _right;
 * next = _next;
 * }
 * };
 */

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // Get the number of nodes at the current level

            // Loop through ALL nodes on this level
            for (int i = 0; i < size; i++) {
                Node currnode = q.poll();

                // Connect to the next node if it's not the last one on this level
                if (i < size - 1) {
                    currnode.next = q.peek();
                }

                // Add children for the next level's processing
                if (currnode.left != null) {
                    q.add(currnode.left);
                }
                if (currnode.right != null) {
                    q.add(currnode.right);
                }
            }
        }
        return root;
    }
}