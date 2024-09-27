// Time Complexity : O(n) we will be traversin to each node
// Space Complexity : O(1) since we dont use additional queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// BFS Apprach: Level Order Traversal using a Queue. For each level, maitain a prev ptr and point it to current.
// Level Order Traversal minus the queue - Keep updating the next ptr and traverse using the next ptr.
// DFS Approach : Will use up additional stack space. Not optimal  

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

        if(root == null) return null;
        //connect1(root);
        return root;

    }
//DFS approach
    private void dfs(TreeNode left, TreeNode right) {
        if(left == null || right == null) return;

        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left,right.right);
    }

//Level order traversal without additional queue
    private void connect1(TreeNode root) {
           Node level = root;

        while(level.left != null) {
            Node cur = level;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }

            level = level.left;
        }

    }

}
