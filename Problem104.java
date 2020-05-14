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

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1) - without recursion
 *                  - O(maxDepth) - with recursion
 */

class Solution {


    public Node connect(Node root) {
        // bfs1(root);
        dfs(root);
        return root;
    }


    // iterative approach => level order without using Queue

    private void bfs1(Node root){
        Node levelStart = root;

        while(levelStart != null){
            Node curr = levelStart;
            while(curr != null){

                if(curr.left!=null)         // Assign left.next <= curr.right
                    curr.left.next = curr.right;

                if(curr.right != null && curr.next != null) // Assign right.next <= root.next.left
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }

    // Recursive approach
    private void dfs(Node root){

        if(root == null)
            return;

        if(root.left != null)
            root.left.next = root.right;

        if(root.right != null && root.next!=null)
            root.right.next = root.next.left;

        dfs(root.left);
        dfs(root.right);
    }
}