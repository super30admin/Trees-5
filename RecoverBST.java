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
/*
method 1: brute approach of using extra space 
do inorder traversal and add node to list.
Traverse the list, if there is no ascending order at any point then that is the point of breach

method 2: recurion and use of prev pointer to keep track of root. 
When there is first breach then set the flag and go find the next node to swap.

time complexity: O(n)
space complexity  :O(h)
*/
class Solution {
    TreeNode first;
    TreeNode last;
    boolean flag;
    TreeNode prev; 
    public void recoverTree(TreeNode root) {
        if(root == null)return;
        
        inorder(root);
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        
    }
    
    private void inorder(TreeNode root){
//         if(root == null)return;
        
//         inorder(root.left);
//             if(prev != null && prev.val > root.val){
//                 //breach has happened;
//                 if(!flag){
//                     first = prev;
//                     last = root;
//                     flag =true;
//                 }else{
//                     last = root;
//                 }
//             }
//         prev = root;
//         inorder(root.right);
        
        
        //iterative code
        Stack<TreeNode> stack  = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();
            
            if(prev != null && prev.val > root.val){
                if(!flag){
                    first = prev;
                    last = root;
                    flag = true;
                }else{
                    last = root;
                }
            }
            // root = stack.pop();
            prev = root;
            root = root.right;
        }
        
    }
}