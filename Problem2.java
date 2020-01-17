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
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to use three pointers (first,middle,last) to keep track of positions where the inorder traversal of tree is not sorted. The inorder traversal of BST is always sorted so situations where prev node value is greater than current node value we know there is discrepancy in BST. For first incorrect position we populate first and middle. For Second incorrect position we populate last pointer. Once inorder traversal is done check for first/middle node and last node and return accordingly.

**/
class Solution {
    TreeNode first,middle,last,prev;
    public void recoverTree(TreeNode root) {
     
        if(root == null)
            return;
        
        inorder(root,null);
        
        int val;
        if(first != null && last != null)
        {
            val       = first.val;
            first.val = last.val;
            last.val  = val;
        }else if(first != null && middle != null){
            val       = first.val;
            first.val = middle.val;
            middle.val  = val;
        }
       
        
        
    }
    
    private void inorder(TreeNode root,TreeNode prev){
        if(root == null)
            return;
        
        //Traverse Left Sub Tree
        inorder(root.left,root);
        
        if(prev != null && root!= null && root.val < prev.val){
            //First Error in BST
            if(first == null){
                first  = prev;
                middle = root;
            }else{
                last   = root; 
            }    
        }
        
        //Assign root to previous
        prev = root;
        
        //Traverse Right Subtree
        inorder(root.right,root);
    }
}
