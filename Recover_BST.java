// Time Complexity : O(n)
// Space Complexity :  O(h) for recursive
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

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

// recursive O(n), O(h) 
// class Solution {
//     TreeNode prev;
//     TreeNode first, second;
//     int cnt;
//     public void recoverTree(TreeNode root) {
//         if(root == null){
//             return;
//         }
//         inorder(root);
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
//     }
//     private void inorder(TreeNode root){
//         if(root == null || cnt == 2){
//             return;
//         }
//         inorder(root.left);
//         if(prev != null && prev.val > root.val){
//             cnt++; // optimization to prvent unnecessary recursion after 2 swap node are found
//             if(first == null){
//                 first = prev;
//             }
//             second = root;
//         }
//         prev = root;
//         inorder(root.right);
//     }
// }
//iterative TC: O(n), O(h)
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode prev = null;
        TreeNode first = null, second = null;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root= root.left;
            }
            root = s.pop();
            if(prev!= null && prev.val > root.val){
                if(first == null){
                    first = prev;
                }
            second = root;
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}