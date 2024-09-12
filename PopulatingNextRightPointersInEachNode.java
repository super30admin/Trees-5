// Time Complexity : O(N),N = #nodes
// Space Complexity : O(H) H = height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class PopulatingNextRightPointersInEachNode {
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
            if(root == null) return root;
            dfs(root);
            return root;
        }

        private void dfs(Node root) {
            if(root.left == null) return;
            root.left.next = root.right;
            dfs(root.left);
            if(root.next !=null) {
                root.right.next = root.next.left;
            }
            dfs(root.right);

        }
    }
}
