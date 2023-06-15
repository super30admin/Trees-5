## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

// Time Complexity - 0(n)
// Space Complexity - 0(1)

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
        if (root == null) {
            return null;
        }
        Node left = root;
        Node curr = null;

        while (left.left != null) {
            curr = left;
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


## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

// Time Complexity - 0(n)
// Space Complexity - 0(h)

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
    TreeNode prev, first, second;
    int cnt;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;    
    }
    private void inorder(TreeNode root) {
        if (root == null || cnt >= 2) {
            return;
        }
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            cnt++;
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}