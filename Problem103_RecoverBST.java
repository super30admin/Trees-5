//Time Complexity: O(n)
//Space Complexity: O(h) ; auxillary data structure 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //prev -> to recover BST in place
    //middle -> will always have the root (element having first breach)
    //first -> prev element of the breach condition
    //last -> to store 2nd breach element
    TreeNode prev, middle, last, first;
    
    public void recoverTree(TreeNode root) {
        //base case
        if(root == null) 
            return;
        
        inorder(root);
        //if first and last has values
        //swap them
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        //swap first with middle (since no last; adjacent nodes needs swap)
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }          
    }
    
    private void inorder(TreeNode root){
        //base case
        if(root == null) return;
        //logic
        inorder(root.left);
        //first breach; since root should be > than prev
        if(prev != null && root.val < prev.val){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        //iterate prev to root
        //and now inorder should be done at root.right
        prev = root;
        inorder(root.right);
    }
    
}