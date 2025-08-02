//https://leetcode.com/problems/recover-binary-search-tree/

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        TreeNode first=null;
        TreeNode second=null;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && root.val<=prev.val){
                //check if first breach
                if(first==null){
                    first=root;
                    second=prev;
                }
                else first = root;
            }
            prev=root;
            root=root.right;
        }
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
    }
}


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
// class Solution {
//     TreeNode first;
//     TreeNode second;
//     TreeNode prev;
//     public void recoverTree(TreeNode root) {
//         if(root==null) return;
//         inorder(root);
//         int temp=first.val;
//         first.val=second.val;
//         second.val=temp;
//     }
//     private void inorder(TreeNode root){
//         //base
//         if(root==null) return;
//         //logic
//         inorder(root.left);
//         if(prev!=null && prev.val >= root.val){
//             //first
//             if(first==null){
//                 first=root;
//                 second=prev;
//             }
//             else{
//                 first=root;
//             }
//         }
//         prev=root;
//         inorder(root.right);
//     }
// }
