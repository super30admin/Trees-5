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

//first brute force- do in order traversal, store nodes in array, find breach, then compare and swap, tc- O(n) for inorder
// + O(n)- traversal sc- O(n) storage
//if we have multiple breaaches, in inorder store values in array and sort it, tc- nlogn

//second approach we can keep 2 pointer prev and curr in inorder traversal, when we find the breach store those nodes
//in prev-first and curr - second, if we find second breach replce curr root  with second then swap frist and second
//tc- O(n) for inorder traversal

// class Solution {
//     TreeNode prev;
//     TreeNode first, second;
//     public void recoverTree(TreeNode root) {
//         helper(root);
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
//     }

//     private void helper(TreeNode root){
//         //base
//         if(root == null) return;

//         //logic

//         helper(root.left);

//         if(prev != null && prev.val >= root.val){
//             if(first == null){//only once it will happen when first is assigned for the forst time
//                 first = prev;//assiging prev to first, curr root to second
//                 second = root;
//             }else{
//                 second = root;// at second breach, root will be the one we need to swap with first
//             }
//         }
//         prev = root;
//         helper(root.right);
//     }
// }

//iterative
class Solution {
    TreeNode prev;
    TreeNode first, second;
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null){
            while(root!=null){
                st.push(root);
                root = root.left;

            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
            if(first == null){//only once it will happen when first is assigned for the forst time
                first = prev;//assiging prev to first, curr root to second
                second = root;
            }else{
                second = root;// at second breach, root will be the one we need to swap with first
            }
        }
        prev = root;
        root = root.right;

        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}