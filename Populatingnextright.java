/*
 * Definition for a Node.
 * public class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node next;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, Node _left, Node _right, Node _next) {
 *         val = _val;
 *         left = _left;
 *         right = _right;
 *         next = _next;
 *     }
 * }
 */
// Time Complexity : O(H)
// Space Complexity : O(1) no queue used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// we can use bfs also dfs also
// here we just used pointers
// we have curr left child point to right
// then curr right child point to the left of next node
// we keep doing this till end

public class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node curroot = root;

        while (curroot.left != null) {

            Node curr = curroot;

            while (curr != null) {

                curr.left.next = curr.right;

                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            curroot = curroot.left;
        }

        return root;
    }
}