/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Time complexity : O(n)
 * Space complexity : O(H)
 */
class Solution {
    
    TreeNode first, middle, last, prev;
    
    public void recoverTree(TreeNode root) {
        
        if(root == null){
            return;
        }
        
        inorderTraversal(root);
        
        if(last == null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }else{
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        
    }
    
    private void inorderTraversal(TreeNode root){
        
        //Base Case
        if(root == null){
            return;
        }
        
        //Logic
        inorderTraversal(root.left);
        
        if(prev != null && prev.val > root.val){
            
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        
        prev = root;
        
        inorderTraversal(root.right);
    }
}