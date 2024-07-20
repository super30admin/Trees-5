/***
 TC - O(n)
 SC - O(h)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class MorrisInorderTraversal {

    List<Integer> nodeList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null)
            return nodeList;

        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            nodeList.add(root.val);
            root = root.right;
        }

        return nodeList;
    }
}