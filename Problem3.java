// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We walk through the tree using Morris traversal, without stack or recursion.
//If a node has no left, we print it and go right; else we link the predecessor to current.
//When that link brings us back, we remove it and print the node.

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
 //Morris inorder Traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        
        List<Integer> res = new ArrayList<>();

        while(cur != null) {
            if(cur.left != null) {
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    //make connection
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null; //delete connection
                    res.add(cur.val);
                    cur = cur.right;
                }
            } else {
                res.add(cur.val);
                cur = cur.right;
            }
            
        }
        return res;
        
    }
}
