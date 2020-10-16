/* 99. Recover Binary Search Tree - HARD
https://leetcode.com/problems/recover-binary-search-tree/

An inorder traversal of a BST gives elements in sorted order.
A pair (x1,y1) value of x1 is greater than value of y1 is a violation of BST property.
If there are 2 such pairs (x1,y1) and (x2,y2) in the tree,
then swapping the values of y1 and x2 will put the tree in proper format.

If there's only a single violation, we should swap x1 and y1's values.

TC: O(n) - we may have to traverse all the nodes
SC: O(h) - stack space
*/

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class RecoverBST {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> st = new Stack<>();
        // x and y are nodes to be swapped
        // prev is used to check for property violation
        TreeNode curr = null, prev = null, x = null, y = null;
        
        // modify iterative inorder
        while(!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            curr = st.pop();
            // Compare curr and prev
            if (prev != null && curr.val < prev.val) {
                x = curr;
                if (y == null) {
                    y = prev;    
                } else {
                    // if we want to break early after getting 2 violations
                    break;
                }
            }
            // Update prev
            prev = curr;
            root = curr.right;
        }
        
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}