// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    private void inorder(TreeNode root){
        //Base
        if(root == null) return;
        
        //Logic
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        
        
        
//         if(root == null) return ;
//         Stack<TreeNode> s = new Stack<>();
//         TreeNode prev = null;
//         TreeNode first = null;
//         TreeNode second = null;
        
//         while(!s.isEmpty() || root != null){
//             while(root != null){
//                 s.push(root);
//                 root = root.left;
//             }
//             root = s.pop();
//             //System.out.println(root.val);
//             if(prev != null && prev.val > root.val){
//                 if(first == null) first = prev;
//                 second = root;
//             }
//             prev = root;
//             root = root.right;
//         }
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;        
    }
}
